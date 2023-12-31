package com.jk.saraApi.common;

public class CommonException extends Exception {
	private static final long serialVersionUID = 4591787143939012258L;

	private String errCode;
	private String errMsg;

	public CommonException(String errCode, String errMsg ) {
		super( errMsg );
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public String getErrCode() {
		return errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}
}
