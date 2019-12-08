package com.wzh.ems.controller;

import com.wzh.ems.entity.Emp;
import com.wzh.ems.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmpService empService;

    /**
     * 添加员工
     *
     * @param emp 接受员工信息
     * @return 结果集
     */
    @RequestMapping("/add")
    public Map<String, Object> addEmp(Emp emp) {
        Map<String, Object> addMap = new HashMap<>();
        try {
            //调用添加方法
            addMap = empService.addEmp(emp);
        } catch (Exception e) {
            e.printStackTrace();
            //错误信息封装
            addMap.put("status", -200);
            addMap.put("message", "添加失败");
        }
        return addMap;
    }

    /**
     * 删除员工
     *
     * @param id 接受员工id
     * @return 返回操作结果
     */
    @RequestMapping("/remove")
    public Map<String, Object> removeEmp(String id) {
        Map<String, Object> removeMap = new HashMap<>();
        try {
            //调用删除方法
            removeMap = empService.removeEmp(id);
        } catch (Exception e) {
            e.printStackTrace();
            //错误信息封装
            removeMap.put("status", -200);
            removeMap.put("message", "删除失败");
        }
        return removeMap;
    }

    /**
     * 修改员工
     *
     * @param emp 接收员工信息
     * @return 返回结果
     */
    @RequestMapping("/modify")
    public Map<String, Object> modifyEmp(Emp emp) {
        Map<String, Object> modifyMap = new HashMap<>();
        try {
            //调用修改方法
            modifyMap = empService.modifyEmp(emp);
        } catch (Exception e) {
            e.printStackTrace();
            //错误信息封装
            modifyMap.put("status", -200);
            modifyMap.put("message", "修改失败");
        }
        return modifyMap;
    }

    /**
     * 查看员工详情
     *
     * @param id 员工id
     * @return 返回员工信息结果
     */
    @RequestMapping("/detail")
    public Map<String, Object> empDetail(String id) {
        Map<String, Object> findOne = new HashMap<>();
        try {
            //调用方法查找
            findOne = empService.findOneById(id);
        } catch (Exception e) {
            e.printStackTrace();
            //错误信息封装
            findOne.put("status", -200);
            findOne.put("message", "查找失败");
        }
        return findOne;
    }

    /**
     * 分页查找所有u员工
     *
     * @param page 查找页数
     * @param rows 每页展示数量
     * @return 返回查找结果
     */
    @RequestMapping("/findAll")
    public Map<String, Object> findAll(Integer page, Integer rows) {
        Map<String, Object> findAll = new HashMap<>();
        try {
            //调用方法查找
            findAll = empService.findAll(page, rows);
            //调用数量方法
            Integer count = empService.findCount();
            Integer pages = count % rows == 0 ? count / rows : count / rows + 1;
            findAll.put("page", page);
            findAll.put("total", pages);
            findAll.put("records", count);
        } catch (Exception e) {
            e.printStackTrace();
            //错误信息封装
            findAll.put("status", -200);
            findAll.put("message", "查找失败");
        }
        return findAll;
    }
}
