package com.jk.saraApi.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ibatis.session.SqlSession;

public class CommonDAO {

	@Autowired
	protected SqlSession sqlSession;
}
