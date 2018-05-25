package com.dtrules.samples.sampleproject2.entity;

public class CalculateSLD {

	public static int id_counter = 1;
	public int id;
	
	public SleepDev latestSLD;
	public SleepDev latest10SLD;
	public int counterSLD;
	
	public CalculateSLD(){
		this.id = id_counter++;
		this.latestSLD = null;
		this.latest10SLD = null;
		this.counterSLD = 0;
	}

	public int getId() {
		return id;
	}

	public SleepDev getLatestSLD() {
		return latestSLD;
	}

	public void setLatestSLD(SleepDev latestSLD) {
		this.latestSLD = latestSLD;
	}

	public SleepDev getLatest10SLD() {
		return latest10SLD;
	}

	public void setLatest10SLD(SleepDev latest10sld) {
		latest10SLD = latest10sld;
	}

	public int getCounterSLD() {
		return counterSLD;
	}

	public void setCounterSLD(int counterSLD) {
		this.counterSLD = counterSLD;
	}
	
	
	
}
