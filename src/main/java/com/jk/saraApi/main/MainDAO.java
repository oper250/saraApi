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

	public List<Map<String, Object>> getSuggestBucketList(Map<String, Object> paramMap) throws Exception {
		return sqlSession.selectList("MainMapper.selectSuggestBucketList", paramMap);
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



	/* 버킷 목록조회 *//*
	public List<JSONObject> getBucketItems(JSONObject param) throws Exception {
		return sqlSession.selectList( "BucketMapper.selectBucketItems", param );
	}

	*//* 버킷 상세정보 조회 *//*
	public JSONObject getBucketDtlItem(JSONObject param) throws Exception {
		return sqlSession.selectOne( "BucketMapper.selectBucketDtlItem", param );
	}

	*//* 스토리 목록조회 *//*
	public List<JSONObject> getStoryItems(JSONObject param) throws Exception {
		return sqlSession.selectList( "BucketMapper.selectStoryItems", param );
	}

	*//* 버킷 등록 *//*
	public long regBucket(Map<String, Object> paramMap) throws Exception {
		return sqlSession.insert( "BucketMapper.insertBucket", paramMap);
	}

	*//* 스토리 등록 *//*
	public long regStory(Map<String, Object> paramMap) throws Exception {
		return sqlSession.insert( "BucketMapper.insertStory", paramMap);
	}

	*//* 버킷 상세정보 조회 *//*
	public int delBucket(JSONObject param) throws Exception {
		return sqlSession.update( "BucketMapper.delBucket", param );
	}*/


}
