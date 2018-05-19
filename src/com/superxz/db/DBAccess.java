package com.superxz.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBAccess {

	public SqlSession getSqlSession() throws IOException {
		// 通过配置文件获取数据库信息
		Reader reader = Resources.getResourceAsReader("com/superxz/config/Configuration.xml");
		// 通过配置信息构建一个SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		// 通过sqlSessionFactory打开一个数据库会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
	}
}
