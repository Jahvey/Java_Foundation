package com.adonai.dao;

import java.util.List;

public class DaoImpl implements Dao {

	@Override
	public int create(String sql, Object... objects) {
		return DaoUtil.excuteCud(sql, objects);
	}

	@Override
	public int delete(String sql, Object... objects) {
		return DaoUtil.excuteCud(sql, objects);
	}

	@Override
	public int update(String sql, Object... objects) {
		return DaoUtil.excuteCud(sql, objects);
	}

	@Override
	public List retrieve(String sql, Class clazz, Object... objects) {
		return DaoUtil.excuteQuery(sql, clazz, objects);
	}

}
