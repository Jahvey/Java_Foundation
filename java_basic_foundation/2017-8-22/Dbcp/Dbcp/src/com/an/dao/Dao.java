package com.an.dao;

import java.util.List;
//增删改查的接口文件CRUD
public interface Dao {
	//插入数据的方法
	public int create(String sql,Object...objects);
	//删除数据的方法
	public int delete(String sql,Object...objects);
	//更新数据的方法
	public int update(String sql,Object...objects);
	//查询数据的方法
	public List retrieve(String sql,Class clazz,Object...objects);
}
