package com.jk.saraApi.main;

import com.jk.saraApi.common.CommonController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
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
    @PostMapping( value = "/regBucket" )
    public Map<String, Object> regBucket(HttpServletRequest request, @RequestParam( required=false, value="file" ) MultipartFile file, @RequestParam Map<String, Object> paramMap) throws Exception {
        Map<String, Object> rsMap = new HashMap<String, Object>();

        String bucketSeqNo = mainService.regBucket(paramMap, file);

        rsMap.put("bucketSeqNo", bucketSeqNo);

        return super.getResponse(rsMap);
    }



}
