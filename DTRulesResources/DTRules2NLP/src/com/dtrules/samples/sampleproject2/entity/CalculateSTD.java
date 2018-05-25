package com.dtrules.samples.sampleproject2.entity;

public class CalculateSTD {

	public static int id_counter = 1;
	public int id;
	
	public SleepDev latestSTD;
	public SleepDev latest10STD;
	public int counterSTD;
	
	public CalculateSTD(){
		this.id = id_counter++;
		this.latestSTD = null;
		this.latest10STD = null;
		this.counterSTD = 0;
	}

	public int getId() {
		return id;
	}
	
	public SleepDev getLatestSTD() {
		return latestSTD;
	}

	public void setLatestSTD(SleepDev latestSTD) {
		this.latestSTD = latestSTD;
	}

	public SleepDev getLatest10STD() {
		return latest10STD;
	}

	public void setLatest10STD(SleepDev latest10std) {
		latest10STD = latest10std;
	}

	public int getCounterSTD() {
		return counterSTD;
	}

	public void setCounterSTD(int counterSTD) {
		this.counterSTD = counterSTD;
	}
	
	
	
}
