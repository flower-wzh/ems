package com.wzh.ems.service;

import com.wzh.ems.entity.Emp;

import java.util.Map;

public interface EmpService {

    /**
     * 添加员工
     *
     * @param emp 插入的员工的信息
     * @return 返回添加操作后的信息
     */
    Map<String, Object> addEmp(Emp emp);

    /**
     * 删除员工
     *
     * @param id 删除员工的id
     * @return 返回删除员工操作后的信息
     */
    Map<String, Object> removeEmp(String id);

    /**
     * 修改员工信息
     *
     * @param emp 修改的员工的信息（包含id）
     * @return 返回修改员工操作后的信息
     */
    Map<String, Object> modifyEmp(Emp emp);

    /**
     * 根据id查询员工信息详情
     *
     * @param id 需要查询的员工的id
     * @return 返回包含员工信息与查询状态的集合
     */
    Map<String, Object> findOneById(String id);


    /**
     * 查询所有员工
     *
     * @param page 当期页数
     * @param rows 每页的数量
     * @return 返回员工信息集合
     */
    Map<String, Object> findAll(Integer page, Integer rows);

    /**
     * 查找员工的数量
     *
     * @return 员工的数量
     */
    Integer findCount();
}
