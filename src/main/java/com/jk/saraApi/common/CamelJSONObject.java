package com.jk.saraApi.common;

import com.google.common.base.CaseFormat;
import org.json.simple.JSONObject;

public class CamelJSONObject extends JSONObject{

	private static final long serialVersionUID = 1L;

	public Object put(Object key, Object value) {
		return super.put(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, (String) key), value);
	}
}
