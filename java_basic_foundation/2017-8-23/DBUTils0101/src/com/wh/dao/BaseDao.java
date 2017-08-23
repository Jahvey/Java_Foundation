package com.wh.dao;

import java.util.List;

/**
 * CRUD基本操作
 */
public interface BaseDao {
    //插入数据
    public int create(String sql,Object...objects);
    //更新数据
    public int update(String sql,Object...objects);
    //删除数据
    public int delete(String sql,Object...objects);
    //查询数据
    public List retireve(String sql, Class clazz, Object...objects);
}
