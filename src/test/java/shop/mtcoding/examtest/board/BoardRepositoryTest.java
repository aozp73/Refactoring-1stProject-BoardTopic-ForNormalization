package shop.mtcoding.examtest.board;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

import shop.mtcoding.examtest.board.dto.BoardResp.BoardDetailRespDto;
import shop.mtcoding.examtest.board.dto.BoardResp.MyBoardListRespDto;
import shop.mtcoding.examtest.board.model.BoardRepository;

@MybatisTest
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void findByIdWithCompany_test() throws Exception {
        // given
        ObjectMapper om = new ObjectMapper();
        int boardId = 1;

        // when
        BoardDetailRespDto boardDetailRespDto = boardRepository.findByIdWithCompany(boardId);
        // String responseBody = om.writeValueAsString(boardDetailRespDto);
        // System.out.println("테스트 : " + responseBody);

        // then
        assertThat(boardDetailRespDto.getCompanyScale()).isEqualTo("대기업");
    }

    @Test
    public void findAllByIdWithCompany_test() throws Exception {
        // given
        ObjectMapper om = new ObjectMapper();
        int userId = 6;

        // when
        List<MyBoardListRespDto> myBoardListRespDto = boardRepository.findAllByIdWithCompany(userId);
        // String responseBody = om.writeValueAsString(myBoardListRespDto);
        // System.out.println("테스트 : " + responseBody);

        // then
        assertThat(myBoardListRespDto.get(1).getTitle()).isEqualTo("공고제목2");
    }
}
