package shop.mtcoding.examtest.employee.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeTechRepository {
    
    public List<EmployeeTech> findAll();

    public EmployeeTech findByUserId(int userId);

    public int insert(EmployeeTech employeeTech);

    public int updateByUserId(EmployeeTech employeeTech);

    public int deleteByUserId(int userId);
}
