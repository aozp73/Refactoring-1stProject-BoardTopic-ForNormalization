package shop.mtcoding.examtest.company.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CompanyRepository {

    public List<Company> findAll();

    public Company findByUserId(int userId);

    public int insert(Company company);

    public int updateByUserId(Company company);

    public int deleteByUserId(int userId);
}
