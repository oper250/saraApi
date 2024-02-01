package com.jk.saraApi.main;

import com.jk.saraApi.common.CommonController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping( value = "/main" )
public class MainController extends CommonController {

    @Autowired
    private MainService mainService;

    public MainController() {
        super(MainController.class);
    }

    @ResponseBody
    @SuppressWarnings("unchecked")
    @PostMapping( value = "/login" )
    public Map<String, Object> login(@RequestBody Map<String, Object> paramMap, HttpServletRequest request) throws Exception {
        Map<String, Object> rsMap = new HashMap<String, Object>();

        // 로그인 프로세스
        String userSeq = mainService.login(paramMap);       // 사용자 시퀀스

        // 세션 SET
        request.getSession().setAttribute("userSeq", userSeq);

        rsMap.put("userSeq", userSeq);
        log.info(">>> 로그인 성공 <<<");

        return super.getResponse(rsMap);
    }

    /* 로그인 */
    @ResponseBody
    @PostMapping( value = "/getBucketList" )
    public Map<String, Object> getBucketList(@RequestBody Map<String, Object> paramMap, HttpServletRequest request) throws Exception {
        Map<String, Object> rsMap;

        rsMap = mainService.getBucketList(paramMap);

        rsMap.put("rsList", rsMap.get("rsList"));
        rsMap.put("moreYn", rsMap.get("moreYn"));
        rsMap.put("nextStNo", rsMap.get("nextStNo"));

        return super.getResponse(rsMap);
    }

    @ResponseBody
    @PostMapping( value = "/getBookmarkList" )
    public Map<String, Object> getBookmarkList(@RequestBody Map<String, Object> paramMap, HttpServletRequest request) throws Exception {
        Map<String, Object> rsMap;

        rsMap = mainService.getBookmarkList(paramMap);

        rsMap.put("rsList", rsMap.get("rsList"));
        rsMap.put("moreYn", rsMap.get("moreYn"));
        rsMap.put("nextStNo", rsMap.get("nextStNo"));

        return super.getResponse(rsMap);
    }

    @ResponseBody
    @PostMapping( value = "/regBucket" )
    public Map<String, Object> regBucket(HttpServletRequest request, @RequestParam( required=false, value="file" ) MultipartFile file, @RequestParam Map<String, Object> paramMap) throws Exception {
        Map<String, Object> rsMap = new HashMap<String, Object>();

        String bucketSeq = mainService.regBucket(paramMap, file);

        rsMap.put("bucketSeq", bucketSeq);

        return super.getResponse(rsMap);
    }

    @ResponseBody
    @PostMapping( value = "/regAlarm" )
    public Map<String, Object> regAlarm(HttpServletRequest request, @RequestParam( required=false, value="file" ) MultipartFile file, @RequestParam Map<String, Object> paramMap) throws Exception {
        Map<String, Object> rsMap = new HashMap<String, Object>();

        mainService.regAlarm(paramMap);

        return super.getResponse(rsMap);
    }

    @ResponseBody
    @PostMapping( value = "/regStory" )
    public Map<String, Object> regStory(HttpServletRequest request, @RequestParam( required=false, value="file" ) MultipartFile file, @RequestParam Map<String, Object> paramMap) throws Exception {
        Map<String, Object> rsMap = new HashMap<String, Object>();

        mainService.regStory(paramMap, file);

        return super.getResponse(rsMap);
    }

    @ResponseBody
    @PostMapping( value = "/getStoryList" )
    public Map<String, Object> getStoryList(@RequestBody Map<String, Object> paramMap, HttpServletRequest request) throws Exception {
        Map<String, Object> rsMap;

        rsMap = mainService.getStoryList(paramMap);

        rsMap.put("rsList", rsMap.get("rsList"));
        rsMap.put("moreYn", rsMap.get("moreYn"));
        rsMap.put("nextStNo", rsMap.get("nextStNo"));

        return super.getResponse(rsMap);
    }
    @ResponseBody
    @PostMapping( value = "/getAlarmList" )
    public Map<String, Object> getAlarmList(@RequestBody Map<String, Object> paramMap, HttpServletRequest request) throws Exception {
        Map<String, Object> rsMap = mainService.getAlarmList(paramMap);

        rsMap.put("rsList", rsMap.get("rsList"));

        return super.getResponse(rsMap);
    }

    @ResponseBody
    @PostMapping( value = "/getUserList" )
    public Map<String, Object> getUserList(@RequestBody Map<String, Object> paramMap, HttpServletRequest request) throws Exception {
        log.info(">>> parameter" + paramMap.get("searchText"));
        Map<String, Object> rsMap = mainService.getUserList(paramMap);

        rsMap.put("rsList", rsMap.get("rsList"));

        return super.getResponse(rsMap);
    }

    @ResponseBody
    @PostMapping( value = "/getSuggestList" )
    public Map<String, Object> getSuggestList(@RequestBody Map<String, Object> paramMap, HttpServletRequest request) throws Exception {
        Map<String, Object> rsMap = new HashMap<String, Object>();

        rsMap = mainService.getSuggestList(paramMap);

        return super.getResponse(rsMap);
    }

    @ResponseBody
    @PostMapping( value = "/regSuggestBucket" )
    // 추천 버킷리스트 등록 (관리자용)
    public Map<String, Object> regSuggestBucket(HttpServletRequest request, @RequestParam( required=false, value="file" ) MultipartFile file, @RequestParam Map<String, Object> paramMap) throws Exception {
        Map<String, Object> rsMap = new HashMap<String, Object>();

        String suggestBucketSeq = mainService.regSuggestBucket(paramMap, file);

        rsMap.put("suggestBucketSeq", suggestBucketSeq);

        return super.getResponse(rsMap);
    }

    @ResponseBody
    @PostMapping( value = "/getUserInfo" )
    public Map<String, Object> getUserInfo(HttpServletRequest request, @RequestBody Map<String, Object> paramMap) throws Exception {
        Map<String, Object> rsMap = mainService.getUserInfo(paramMap);

        return super.getResponse(rsMap);
    }

    @ResponseBody
    @PostMapping( value = "/getBucketDetail" )
    public Map<String, Object> getBucketDetail(@RequestBody Map<String, Object> paramMap, HttpServletRequest request) throws Exception {
        Map<String, Object> rsMap = mainService.getBucketDetail(paramMap);

        return super.getResponse(rsMap);
    }

    @ResponseBody
    @PostMapping( value = "/regBucketFromSuggest" )
    public Map<String, Object> regBucketFromSuggest(HttpServletRequest request, @RequestParam Map<String, Object> paramMap) throws Exception {
        Map<String, Object> rsMap = new HashMap<String, Object>();

        String bucketSeq = mainService.regBucketFromSuggest(paramMap);

        rsMap.put("bucketSeq", bucketSeq);

        return super.getResponse(rsMap);
    }

    @ResponseBody
    @PostMapping( value = "/regSuggestReply" )
    public Map<String, Object> regSuggestReply(HttpServletRequest request, @RequestParam Map<String, Object> paramMap) throws Exception {
        Map<String, Object> rsMap = new HashMap<String, Object>();

        int rsCnt = mainService.regSuggestReply(paramMap);

        return super.getResponse(rsMap);
    }

    // 버킷리스트 즐겨찾기 추가
    @ResponseBody
    @PostMapping( value = "/saveBookmark" )
    public Map<String, Object> saveBookmark(HttpServletRequest request, @RequestParam Map<String, Object> paramMap) throws Exception {
        Map<String, Object> rsMap = new HashMap<String, Object>();

        int rsCnt = mainService.saveBookmark(paramMap);

        return super.getResponse(rsMap);
    }

    @ResponseBody
    @PostMapping( value = "/getSuggestReplyList" )
    public Map<String, Object> getSuggestReplyList(@RequestBody Map<String, Object> paramMap, HttpServletRequest request) throws Exception {
        Map<String, Object> rsMap = mainService.getSuggestReplyList(paramMap);

        rsMap.put("rsList", rsMap.get("rsList"));

        return super.getResponse(rsMap);
    }

    @ResponseBody
    @PostMapping( value = "/deleteSuggestReply" )
    public Map<String, Object> deleteSuggestReply(HttpServletRequest request, @RequestParam Map<String, Object> paramMap) throws Exception {
        Map<String, Object> rsMap = new HashMap<String, Object>();

        int rsCnt = mainService.deleteSuggestReply(paramMap);

        return super.getResponse(rsMap);
    }

    @ResponseBody
    @PostMapping( value = "/getRandomImgList" )
    public Map<String, Object> getRandomImgList(@RequestBody Map<String, Object> paramMap, HttpServletRequest request) throws Exception {
        Map<String, Object> rsMap = mainService.getRandomImgList();

        rsMap.put("rsList", rsMap.get("rsList"));

        return super.getResponse(rsMap);
    }

    @ResponseBody
    @PostMapping( value = "/getSuggestReplyCnt" )
    public Map<String, Object> getSuggestReplyCnt(@RequestBody Map<String, Object> paramMap, HttpServletRequest request) throws Exception {
        Map<String, Object> rsMap = mainService.getSuggestReplyCnt(paramMap);

        return super.getResponse(rsMap);
    }

    @ResponseBody
    @PostMapping( value = "/saveUserInfo" )
    public Map<String, Object> saveUserInfo(HttpServletRequest request, @RequestParam( required=false, value="file" ) MultipartFile file, @RequestParam Map<String, Object> paramMap) throws Exception {
        Map<String, Object> rsMap = new HashMap<String, Object>();

        rsMap.put("profileUrl", mainService.saveUserInfo(paramMap, file));

        return super.getResponse(rsMap);
    }

    @ResponseBody
    @PostMapping( value = "/regFollow" )
    public Map<String, Object> regFollow(HttpServletRequest request, @RequestParam( required=false, value="file" ) MultipartFile file, @RequestParam Map<String, Object> paramMap) throws Exception {
        Map<String, Object> rsMap = new HashMap<String, Object>();

        mainService.regFollow(paramMap);

        return super.getResponse(rsMap);
    }

    @ResponseBody
    @PostMapping( value = "/delFollow" )
    public Map<String, Object> delFollow(HttpServletRequest request, @RequestParam( required=false, value="file" ) MultipartFile file, @RequestParam Map<String, Object> paramMap) throws Exception {
        Map<String, Object> rsMap = new HashMap<String, Object>();

        mainService.delFollow(paramMap);

        return super.getResponse(rsMap);
    }


}
