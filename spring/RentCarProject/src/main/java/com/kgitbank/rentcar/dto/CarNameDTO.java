package com.kgitbank.rentcar.dto;

public class CarNameDTO {
	private int num;					//등록순서
	private String carCode;		//차량코드
	private String carName;		//차량명
	private String carType;		//차량타입(경차, 소형, 중형, 대형, SUV, 승합, 외제)
	private String carFuel;			//연료타입(휘발류, LPG, 경유, hibrid, 전기, 수소)
	private String carInfo;			//차량정보
	private String carCompany;	//제조사
	private String carImage;		//차량이미지
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getCarCode() {
		return carCode;
	}
	public void setCarCode(String carCode) {
		this.carCode = carCode;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getCarFuel() {
		return carFuel;
	}
	public void setCarFuel(String carFuel) {
		this.carFuel = carFuel;
	}
	public String getCarInfo() {
		return carInfo;
	}
	public void setCarInfo(String carInfo) {
		this.carInfo = carInfo;
	}
	public String getCarCompany() {
		return carCompany;
	}
	public void setCarCompany(String carCompany) {
		this.carCompany = carCompany;
	}
	public String getCarImage() {
		return carImage;
	}
	public void setCarImage(String carImage) {
		this.carImage = carImage;
	}
}	
