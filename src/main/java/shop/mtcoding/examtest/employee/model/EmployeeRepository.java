package shop.mtcoding.examtest.employee.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeRepository {
    
    public List<Employee> findAll();

    public Employee findByUserId(int userId);

    public int insert(int userId);

    public int updateByUserId(Employee company);

    public int deleteByUserId(int userId);
}
