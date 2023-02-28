package shop.mtcoding.examtest.board.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardRepository {
    
    public List<Board> findAll();

    public Board findById(int id);

    public int insert(Board board);

    public int updateById(Board board);

    public int deleteById(int id);
}
