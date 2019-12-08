package com.wzh.ems.dao;

import com.wzh.ems.entity.Emp;
import tk.mybatis.mapper.additional.idlist.DeleteByIdListMapper;
import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

public interface EmpDao extends Mapper<Emp>, DeleteByIdListMapper<Emp,String>, IdListMapper<Emp,String>, InsertListMapper<Emp> {
}
