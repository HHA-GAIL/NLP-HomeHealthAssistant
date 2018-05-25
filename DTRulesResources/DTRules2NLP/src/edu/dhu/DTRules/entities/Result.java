package edu.dhu.DTRules.entities;

public class Result extends baseEntity {

	public int ResultCode;
	public String ResultMessage;
	public Object EX1;
	public Object Ex2;
	
	public int getResultCode() {
		return ResultCode;
	}
	public void setResultCode(int resultCode) {
		ResultCode = resultCode;
	}
	public String getResultMessage() {
		return ResultMessage;
	}
	public void setResultMessage(String resultMessage) {
		ResultMessage = resultMessage;
	}
	public Object getEX1() {
		return EX1;
	}
	public void setEX1(Object eX1) {
		EX1 = eX1;
	}
	public Object getEx2() {
		return Ex2;
	}
	public void setEx2(Object ex2) {
		Ex2 = ex2;
	}
	
	
	
	
}
