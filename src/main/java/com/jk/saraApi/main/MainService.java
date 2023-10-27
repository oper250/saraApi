package com.jk.saraApi.main;

import com.jk.saraApi.common.CommonException;
import com.jk.saraApi.common.CommonService;
import com.jk.saraApi.common.CommonUtil;
import com.jk.saraApi.common.Encryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor=Exception.class)
public class MainService extends CommonService {

	@Autowired
	private MainDAO mainDAO;

	public MainService() {
		super(MainService.class);
	}

	private static final int GET_BUCKET_ITEMS_SEARCH_COUNT = 30;		// 버킷리스트 조회건수
	private static final int GET_STORY_ITEMS_SEARCH_COUNT = 30;			// 스토리리스트 조회건수

	/* 로그인 */
	public String login(Map<String, Object> paramMap) throws Exception {
		String[] reqKeys = {"userId", "userPwd"};		// 필수키
		super.checkVal(paramMap, reqKeys);					// 벨리데이션 체크

		System.out.println("!!!!!!!!" + paramMap);

		paramMap.put("userPwd", Encryptor.sha512( (String)paramMap.get("userPwd") ) );

		String userSeq = mainDAO.login(paramMap);

		if("0".equals(userSeq)) {	// 해당 사용자번호가 존재하지 않는 경우
			throw new CommonException( "0001", "아이디 또는 비밀번호를 확인하여 주세요" );
		}

		return userSeq;
	}

	public Map<String, Object> getBucketList(Map<String, Object> paramMap) throws Exception {
		String[] reqKeys = {"stNo"};		// 필수키
		super.checkVal(paramMap, reqKeys);

		Map<String, Object> rsMap = new HashMap<String, Object>();
		String moreYn = "";		// 더보기여부
		int nextStNo = 0;

		paramMap.put("searchCnt", GET_BUCKET_ITEMS_SEARCH_COUNT);

		// 버킷 목록 조회
		List<Map<String, Object>> bucketList = mainDAO.selectBucketList(paramMap);

		if( !CommonUtil.isEmptyList(bucketList) ) {
			moreYn = (String) bucketList.get(0).get("moreYn");		// 더보기여부 SET
			nextStNo = (Integer) paramMap.get("stNo") + GET_BUCKET_ITEMS_SEARCH_COUNT;
		}

		rsMap.put( "rsList", bucketList );
		rsMap.put( "moreYn", moreYn );
		rsMap.put( "nextStNo", nextStNo );

		return rsMap;
	}

	/* 버킷 등록 */
	public String regBucket(Map<String, Object> paramMap, MultipartFile file) throws Exception {
		String[] reqKeys = {"bucketNm"};					// 필수키
		super.checkVal(paramMap, reqKeys);					// 벨리데이션 체크

		// 파일업로드 및 업로드경로 SET
		if ( file != null && !file.isEmpty() ){
			paramMap.put("repImgUrl", imageUtil.uplaodBucketRepImage(file));
			log.info(":::파일 업로드 완료:::");
		}

		mainDAO.insertBucket(paramMap);	// 버킷 등록
		log.info(":::버킷 등록 완료::: bucketSeq : " + (String)paramMap.get("bucketSeq") + ")");

		return (String)paramMap.get("bucketSeq");
	}

	public Map<String, Object> getStoryList(Map<String, Object> paramMap) throws Exception {
		String[] reqKeys = {"stNo", "bucketSeq"};		// 필수키
		super.checkVal(paramMap, reqKeys);

		Map<String, Object> rsMap = new HashMap<String, Object>();
		String moreYn = "";		// 더보기여부
		int nextStNo = 0;

		paramMap.put("searchCnt", GET_STORY_ITEMS_SEARCH_COUNT);

		// 버킷 목록 조회
		List<Map<String, Object>> storyList = mainDAO.selectStoryList(paramMap);

		if( !CommonUtil.isEmptyList(storyList) ) {
			moreYn = (String) storyList.get(0).get("moreYn");		// 더보기여부 SET
			nextStNo = (Integer) paramMap.get("stNo") + GET_STORY_ITEMS_SEARCH_COUNT;
		}

		rsMap.put( "rsList", storyList );
		rsMap.put( "moreYn", moreYn );
		rsMap.put( "nextStNo", nextStNo );

		return rsMap;
	}

	public Map<String, Object> getAlarmList(Map<String, Object> paramMap) throws Exception {
		String[] reqKeys = {"alarmGubun", "userSeq"};		// 필수키
		super.checkVal(paramMap, reqKeys);

		Map<String, Object> rsMap = new HashMap<String, Object>();

		List<Map<String, Object>> alarmList = mainDAO.selectAlarmList(paramMap);

		rsMap.put( "rsList", alarmList );

		return rsMap;
	}

	public Map<String, Object>getUserList(Map<String, Object> paramMap) throws Exception {
		String[] reqKeys = {"searchText"};		// 필수키
		super.checkVal(paramMap, reqKeys);

		Map<String, Object> rsMap = new HashMap<String, Object>();

		List<Map<String, Object>> userList = mainDAO.selectUserList(paramMap);

		rsMap.put( "rsList", userList );

		return rsMap;
	}

	public Map<String, Object>getSuggestBucketList(Map<String, Object> paramMap) throws Exception {
		Map<String, Object> rsMap = new HashMap<String, Object>();

		List<Map<String, Object>> rsList = mainDAO.getSuggestBucketList(paramMap);

		rsMap.put( "rsList", rsList );

		return rsMap;
	}

	public String regSuggestBucket(Map<String, Object> paramMap, MultipartFile file) throws Exception {
		// 파일업로드 및 업로드경로 SET
		if ( file != null && !file.isEmpty() ){
			paramMap.put("repImgUrl", imageUtil.uplaodBucketRepImage(file));
			log.info(":::파일 업로드 완료:::");
		}

		mainDAO.insertSuggestBucket(paramMap);	// 버킷 등록

		return (String)paramMap.get("suggestBucketSeq");
	}

	public Map<String, Object> getUserInfo(Map<String, Object> paramMap) throws Exception {
		System.out.println("!!!!!!!!!!!" + paramMap);

		Map<String, Object> rsMap = mainDAO.selectUserInfo(paramMap);

		System.out.println("~~~~~~~~~" + rsMap);

		rsMap.put( "rsMap", rsMap );

		return rsMap;
	}

}
