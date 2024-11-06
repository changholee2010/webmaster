package com.yedam.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;

public class ProductServiceImpl implements ProductService {

	private static ProductServiceImpl instance = new ProductServiceImpl();

	private ProductServiceImpl() {
	}

	public static ProductServiceImpl getInstance() {
		return instance;
	}

	SqlSession sqlSession = DataSource.getInstance().openSession();

	@Override
	public List<Map<String, String>> allCategory() {
		return sqlSession.selectList("com.yedam.mapper.ProductMapper.categoryList");
	}

}
