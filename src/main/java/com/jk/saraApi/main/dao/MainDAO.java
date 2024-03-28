package com.jk.saraApi.main.dao;

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

	// 즐겨찾기 조회
	public List<Map<String, Object>> selectBookmarkList(Map<String, Object> paramMap) throws Exception {
		return sqlSession.selectList("MainMapper.selectBookmarkList", paramMap);
	}

	/* 버킷 등록 */
	public int insertBucket(Map<String, Object> paramMap) throws Exception {
		return sqlSession.insert( "MainMapper.insertBucket", paramMap);
	}

	public int insertAlarm(Map<String, Object> paramMap) throws Exception {
		return sqlSession.insert( "MainMapper.insertAlarm", paramMap);
	}

	public int insertStory(Map<String, Object> paramMap) throws Exception {
		return sqlSession.insert( "MainMapper.insertStory", paramMap);
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

	public int insertStoryReply(Map<String, Object> paramMap) throws Exception {
		return sqlSession.insert( "MainMapper.insertStoryReply", paramMap);
	}

	public int insertBookmark(Map<String, Object> paramMap) throws Exception {
		return sqlSession.insert( "MainMapper.insertBookmark", paramMap);
	}

	public int deleteBookmark(Map<String, Object> paramMap) throws Exception {
		return sqlSession.delete( "MainMapper.deleteBookmark", paramMap);
	}

	public List<Map<String, Object>> selectSuggestReplyList(Map<String, Object> paramMap) throws Exception {
		return sqlSession.selectList("MainMapper.selectSuggestReplyList", paramMap);
	}

	public List<Map<String, Object>> selectStoryReplyList(Map<String, Object> paramMap) throws Exception {
		return sqlSession.selectList("MainMapper.selectStoryReplyList", paramMap);
	}

	public int deleteSuggestReply(Map<String, Object> paramMap) throws Exception {
		return sqlSession.delete("MainMapper.deleteSuggestReply", paramMap);
	}

	public int deleteStoryReply(Map<String, Object> paramMap) throws Exception {
		return sqlSession.delete("MainMapper.deleteStoryReply", paramMap);
	}

	public List<Map<String, Object>> selectRandomImgList() throws Exception {
		return sqlSession.selectList("MainMapper.selectRandomImgList");
	}

	// 추천버킷 댓글 건수 구하기
	public Map<String, Object> selectSuggestReplyCnt(Map<String, Object> paramMap) throws Exception {
		return sqlSession.selectOne("MainMapper.selectSuggestReplyCnt", paramMap);
	}

	public int updateUserInfo(Map<String, Object> paramMap) throws Exception {
		return sqlSession.delete("MainMapper.updateUserInfo", paramMap);
	}

	public int insertFollow(Map<String, Object> paramMap) throws Exception {
		return sqlSession.insert( "MainMapper.insertFollow", paramMap);
	}

	public int deleteFollow(Map<String, Object> paramMap) throws Exception {
		return sqlSession.delete( "MainMapper.deleteFollow", paramMap);
	}

	public int updateSuccessYn(Map<String, Object> paramMap) throws Exception {
		return sqlSession.update("MainMapper.updateSuccessYn", paramMap);
	}

	public int deleteBucket(Map<String, Object> paramMap) throws Exception {
		return sqlSession.insert( "MainMapper.deleteBucket", paramMap);
	}

	public int deleteStory(Map<String, Object> paramMap) throws Exception {
		return sqlSession.insert( "MainMapper.deleteStory", paramMap);
	}

	public Map<String, Object> selectMyCnt(Map<String, Object> paramMap) throws Exception {
		return sqlSession.selectOne("MainMapper.selectMyCnt", paramMap);
	}

	public String loginCheckByTocken(Map<String, Object> paramMap) throws Exception {
		return sqlSession.selectOne( "MainMapper.loginCheckByTocken", paramMap );
	}

}
