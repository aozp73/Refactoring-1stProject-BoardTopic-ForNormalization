package shop.mtcoding.examtest.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.examtest.board.dto.BoardReq.BoardInsertReqDto;
import shop.mtcoding.examtest.board.dto.BoardReq.BoardUpdateReqDto;
import shop.mtcoding.examtest.board.dto.BoardResp.BoardDetailRespDto;
import shop.mtcoding.examtest.board.dto.BoardResp.BoardListRespDto;
import shop.mtcoding.examtest.board.dto.BoardResp.BoardMainRespDto;
import shop.mtcoding.examtest.board.dto.BoardResp.BoardUpdateRespDto;
import shop.mtcoding.examtest.board.dto.BoardResp.MyBoardListRespDto;
import shop.mtcoding.examtest.board.model.Board;
import shop.mtcoding.examtest.board.model.BoardRepository;
import shop.mtcoding.examtest.common.ex.CustomException;
import shop.mtcoding.examtest.common.util.CareerParse;
import shop.mtcoding.examtest.common.util.EducationParse;
import shop.mtcoding.examtest.common.util.JobTypeParse;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public List<BoardMainRespDto> getListToMain() {
        List<BoardMainRespDto> boardListPS;

        try {
            boardListPS = boardRepository.findAllWithCompanyToMain();
        } catch (Exception e) {
            throw new CustomException("서버에 일시적인 문제가 생겼습니다", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return boardListPS;
    }

    @Transactional(readOnly = true)
    public BoardDetailRespDto getDetail(int id) {
        BoardDetailRespDto boardDetailPS;

        try {
            boardDetailPS = boardRepository.findByIdWithCompany(id);
        } catch (Exception e) {
            throw new CustomException("서버에 일시적인 문제가 생겼습니다", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        String career = CareerParse.careerToString(boardDetailPS.getCareer());
        boardDetailPS.setCareerString(career);

        String education = EducationParse.educationToString(boardDetailPS.getEducation());
        boardDetailPS.setEducationString(education);

        String jobType = JobTypeParse.jopTypeToString(boardDetailPS.getJobType());
        boardDetailPS.setJobTypeString(jobType);

        return boardDetailPS;
    }

    @Transactional(readOnly = true)
    public List<BoardListRespDto> getList() {
        List<BoardListRespDto> boardListPS;

        boardListPS = boardRepository.findAllWithCompany();
        return boardListPS;

    }

    @Transactional(readOnly = true)
    public BoardUpdateRespDto getDetailForUpdate(int id, int coPrincipalId) {
        BoardUpdateRespDto boardDetailPS = boardRepository.findByIdForUpdate(id);

        if (boardDetailPS == null) {
            throw new CustomException("없는 게시물을 수정할 수 없습니다", HttpStatus.BAD_REQUEST);
        }

        if (boardDetailPS.getUserId() != coPrincipalId) {
            throw new CustomException("수정 권한이 없습니다", HttpStatus.BAD_REQUEST);
        }

        String career = CareerParse.careerToString(boardDetailPS.getCareer());
        boardDetailPS.setCareerString(career);

        String education = EducationParse.educationToString(boardDetailPS.getEducation());
        boardDetailPS.setEducationString(education);

        String jobType = JobTypeParse.jopTypeToString(boardDetailPS.getJobType());
        boardDetailPS.setJobTypeString(jobType);

        return boardDetailPS;
    }

    @Transactional
    public void updateBoard(BoardUpdateReqDto boardUpdateReqDto, int coPrincipalId) {

        Board boardPS;
        boardPS = boardRepository.findById(boardUpdateReqDto.getId());

        try {
        } catch (Exception e) {
            throw new CustomException("없는 게시물을 수정할 수 없습니다", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (boardPS.getUserId() != coPrincipalId) {
            throw new CustomException("수정 권한이 없습니다", HttpStatus.BAD_REQUEST);
        }

        int career = CareerParse.careerToInt(boardUpdateReqDto.getCareerString());
        int education = EducationParse.educationToInt(boardUpdateReqDto.getEducationString());
        int jobType = JobTypeParse.jobTypeToInt(boardUpdateReqDto.getJobTypeString());

        Board board = new Board(boardUpdateReqDto.getId(),
                boardUpdateReqDto.getUserId(),
                boardUpdateReqDto.getTitle(),
                boardUpdateReqDto.getContent(),
                career,
                jobType,
                education,
                boardUpdateReqDto.getFavor());

        try {
            boardRepository.updateById(board);
        } catch (Exception e) {
            throw new CustomException("서버에 일시적인 문제가 생겼습니다", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Transactional
    public int insertBoard(BoardInsertReqDto boardInsertReqDto, int userId) {

        int career = CareerParse.careerToInt(boardInsertReqDto.getCareerString());
        int education = EducationParse.educationToInt(boardInsertReqDto.getEducationString());
        int jobType = JobTypeParse.jobTypeToInt(boardInsertReqDto.getJobTypeString());

        Board board = new Board(userId, boardInsertReqDto.getTitle(),
                boardInsertReqDto.getContent(),
                career,
                jobType,
                education,
                boardInsertReqDto.getFavor());

        try {
            boardRepository.insert(board);
        } catch (Exception e) {
            throw new CustomException("서버에 일시적인 문제가 생겼습니다", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return board.getId();
    }

    @Transactional(readOnly = true)
    public List<MyBoardListRespDto> getMyBoard(int coPrincipalId, int userId) {
        // 권한 체크
        if (coPrincipalId != userId) {
            throw new CustomException("공고 리스트 열람 권한이 없습니다.");
        }

        List<MyBoardListRespDto> myBoardListPS;
        try {
            myBoardListPS = boardRepository.findAllByIdWithCompany(coPrincipalId);
        } catch (Exception e) {
            throw new CustomException("서버에 일시적인 문제가 생겼습니다", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return myBoardListPS;
    }

}
