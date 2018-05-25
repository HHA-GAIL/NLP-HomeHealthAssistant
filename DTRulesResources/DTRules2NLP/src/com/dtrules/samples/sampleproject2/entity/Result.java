package com.dtrules.samples.sampleproject2.entity;

public class Result {

	public static int id_counter = 1;
	public int id;
	
	public int resultCode;
	public String resultMessage;
	
	public Result(){
		this.id = id_counter++;
		this.resultCode = 0;
		this.resultMessage = "None";
	}

	public int getId() {
		return id;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
	
	
	
}
