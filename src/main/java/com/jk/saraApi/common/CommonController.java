package com.jk.saraApi.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings( "unchecked" )
public class CommonController {

	protected Logger log;

	protected CommonController(Class<?> c ) {
		log = LoggerFactory.getLogger( c );
	}

	protected boolean isLoggedIn( HttpServletRequest request ) {
		HttpSession session = request.getSession();
		long userSeqno = CommonUtil.getLong( session.getAttribute( "USER_SEQNO" ) );
		return !( userSeqno < 1L );
	}

	protected long getUserSeqno( HttpServletRequest request ) {
		HttpSession session = request.getSession();
		return CommonUtil.getLong( session.getAttribute( "USER_SEQNO" ) );
	}

	public JSONObject getErrorResponse( String errCode, String errMsg ) {
		JSONObject resItem = new JSONObject();
		resItem.put( "rsCode", errCode);
		resItem.put( "rsMsg", errMsg);

		return resItem;
	}

	public Map<String, Object> getResponse(Map<String, Object> rsMap) throws Exception {
		if(rsMap != null) {
			rsMap.put("rsCode", "0000");
			rsMap.put("rsMsg", "SUCCESS");
		} else {
			return new HashMap<String, Object>();
		}

		return rsMap;
	}

	public Map<String, Object> getResponse() throws Exception {
		HashMap<String, Object> rsMap = new HashMap<String, Object>();
		rsMap.put("rsCode", "0000");
		rsMap.put("rsMsg", "SUCCESS");

		return rsMap;
	}

}
