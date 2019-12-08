package com.wzh.ems.entity.service.impl;

import com.wzh.ems.entity.Emp;
import com.wzh.ems.entity.dao.EmpDao;
import com.wzh.ems.entity.service.EmpService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao empDao;

    @Override
    public Map<String, Object> addEmp(Emp emp) {
        Map<String, Object> addMap = new HashMap<>();
        //生成uuid作为主键id
        emp.setEmpId(UUID.randomUUID().toString().replace("-", ""));
        //插入数据库方法，为空不处理
        empDao.insertSelective(emp);
        //封装结果
        addMap.put("emp", emp);
        addMap.put("status", 200);
        addMap.put("message", "插入成功！");
        return addMap;
    }

    @Override
    public Map<String, Object> removeEmp(String id) {
        Map<String, Object> removeMap = new HashMap<>();
        //根据主键删除数据
        empDao.deleteByPrimaryKey(id);
        //封装删除的id，以及执行的状态
        removeMap.put("id", id);
        removeMap.put("status", 200);
        removeMap.put("message", "删除成功！");
        return removeMap;
    }

    @Override
    public Map<String, Object> modifyEmp(Emp emp) {
        Map<String, Object> modifyMap = new HashMap<>();
        //更新员工的方法
        empDao.updateByPrimaryKeySelective(emp);
        //封装更新的员工信息，以及执行的状态
        modifyMap.put("emp", emp);
        modifyMap.put("status", 200);
        modifyMap.put("message", "修改成功！");
        return modifyMap;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Map<String, Object> findOneById(String id) {
        Map<String, Object> findOneMap = new HashMap<>();
        //查询一个员工
        Emp emp = empDao.selectByPrimaryKey(id);
        //封装员工信息，以及执行的状态
        findOneMap.put("emp", emp);
        findOneMap.put("status", 200);
        findOneMap.put("message", "查找成功！");
        return findOneMap;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Map<String, Object> findAll(Integer page, Integer rows) {
        Map<String, Object> findAllMap = new HashMap<>();
        Integer offset = (page - 1) * rows;
        //查询所有员工
        List<Emp> empList = empDao.selectByRowBounds(new Emp(), new RowBounds(offset, rows));
        //封装更新的员工信息，以及执行的状态
        findAllMap.put("empList", empList);
        findAllMap.put("status", 200);
        findAllMap.put("message", "查找成功！");
        return findAllMap;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer findCount() {
        return empDao.selectCount(new Emp());
    }
}
