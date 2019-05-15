package com.jk.xinx.pojo.car;

public class cityweather {

	private String date;
	private String ymd;
	private String week;
	private String type;
	private String high;
	private String low;
	private String fx;
	private String fl;
	private String sunrise;
	private String sunset;
	private String notice;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getYmd() {
		return ymd;
	}
	public void setYmd(String ymd) {
		this.ymd = ymd;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getHigh() {
		return high;
	}
	public void setHigh(String high) {
		this.high = high;
	}
	public String getLow() {
		return low;
	}
	public void setLow(String low) {
		this.low = low;
	}
	public String getFx() {
		return fx;
	}
	public void setFx(String fx) {
		this.fx = fx;
	}
	public String getFl() {
		return fl;
	}
	public void setFl(String fl) {
		this.fl = fl;
	}
	public String getSunrise() {
		return sunrise;
	}
	public void setSunrise(String sunrise) {
		this.sunrise = sunrise;
	}
	public String getSunset() {
		return sunset;
	}
	public void setSunset(String sunset) {
		this.sunset = sunset;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	@Override
	public String toString() {
		return "cityweather [date=" + date + ", ymd=" + ymd + ", week=" + week + ", type=" + type + ", high=" + high
				+ ", low=" + low + ", fx=" + fx + ", fl=" + fl + ", sunrise=" + sunrise + ", sunset=" + sunset
				+ ", notice=" + notice + "]";
	}
	
}
