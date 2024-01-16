package com.jk.saraApi.main;

import com.jk.saraApi.common.CommonDAO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository( "BucketDAO" )
public class MainDAO extends CommonDAO {

	/* 로그인 */
	public String login(Map<String, Object> paramMap) throws Exception {
		return sqlSession.selectOne( "MainMapper.login", paramMap );
	}

	// 즐겨찾기 리스트
	public Map<String, Object> selectBookmarkList(Map<String, Object> paramMap) throws Exception {
		return sqlSession.selectOne("MainMapper.selectBookmarkList", paramMap);
	}

	// 버킷리스트 조회
	public List<Map<String, Object>> selectBucketList(Map<String, Object> paramMap) throws Exception {
		return sqlSession.selectList("MainMapper.selectBucketList", paramMap);
	}

	/* 버킷 등록 */
	public int insertBucket(Map<String, Object> paramMap) throws Exception {
		return sqlSession.insert( "MainMapper.insertBucket", paramMap);
	}

	/* 스토리리스트 조회 */
	public List<Map<String, Object>> selectStoryList(Map<String, Object> paramMap) throws Exception {
		return sqlSession.selectList("MainMapper.selectStoryList", paramMap);
	}

	/* 알람리스트 조회 */
	public List<Map<String, Object>> selectAlarmList(Map<String, Object> paramMap) throws Exception {
		return sqlSession.selectList("MainMapper.selectAlarmList", paramMap);
	}

	public List<Map<String, Object>> selectUserList(Map<String, Object> paramMap) throws Exception {
		return sqlSession.selectList("MainMapper.selectUserList", paramMap);
	}

	/* 추천버킷리스트 조회 */
	public List<Map<String, Object>> getSuggestList(Map<String, Object> paramMap) throws Exception {
		return sqlSession.selectList("MainMapper.selectSuggestList", paramMap);
	}

	/* 추천버킷리스트 상세조회 */
	public Map<String, Object> getSuggestDetail(Map<String, Object> paramMap) throws Exception {
		return sqlSession.selectOne( "MainMapper.selectSuggestDetail", paramMap);
	}

	public int insertSuggestBucket(Map<String, Object> paramMap) throws Exception {
		return sqlSession.insert( "MainMapper.insertSuggestBucket", paramMap);
	}

	public Map<String, Object> selectUserInfo(Map<String, Object> paramMap) throws Exception {
		return sqlSession.selectOne( "MainMapper.selectUserInfo", paramMap);
	}

	public Map<String, Object> getBucketDetail(Map<String, Object> paramMap) throws Exception {
		return sqlSession.selectOne( "MainMapper.selectBucketDetail", paramMap);
	}

	public int insertBucketFromSuggest(Map<String, Object> paramMap) throws Exception {
		return sqlSession.insert( "MainMapper.insertBucketFromSuggest", paramMap);
	}

	public int insertSuggestReply(Map<String, Object> paramMap) throws Exception {
		return sqlSession.insert( "MainMapper.insertSuggestReply", paramMap);
	}


}
