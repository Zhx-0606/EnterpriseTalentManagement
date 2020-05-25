package cn.service.Impl;

import cn.dao.DepartmentMapper;
import cn.entity.Department;
import cn.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DepartmentService")
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> SelDepartment() {
        return departmentMapper.SelDepartment();
    }
}
