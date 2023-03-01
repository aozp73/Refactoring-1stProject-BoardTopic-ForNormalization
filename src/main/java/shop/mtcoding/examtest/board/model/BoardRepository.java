package shop.mtcoding.examtest.board.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.mtcoding.examtest.board.dto.BoardResp.BoardDetailRespDto;
import shop.mtcoding.examtest.board.dto.BoardResp.BoardListRespDto;
import shop.mtcoding.examtest.board.dto.BoardResp.BoardMainRespDto;
import shop.mtcoding.examtest.board.dto.BoardResp.BoardUpdateRespDto;
import shop.mtcoding.examtest.board.dto.BoardResp.MyBoardListRespDto;

@Mapper
public interface BoardRepository {

    public List<Board> findAll();

    public BoardDetailRespDto findByIdWithCompany(int boardId);

    public List<BoardListRespDto> findAllWithCompany();

    public List<BoardMainRespDto> findAllWithCompanyToMain();

    public List<MyBoardListRespDto> findAllByIdWithCompany(int userId);

    public BoardUpdateRespDto findByIdForUpdate(int id);

    public Board findById(int id);

    public int insert(Board board);

    public int updateById(Board board);

    public int deleteById(int id);
}
