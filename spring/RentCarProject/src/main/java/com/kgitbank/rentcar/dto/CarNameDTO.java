package com.kgitbank.rentcar.dto;

public class CarNameDTO {
	private int num;					//��ϼ���
	private String carCode;		//�����ڵ�
	private String carName;		//������
	private String carType;		//����Ÿ��(����, ����, ����, ����, SUV, ����, ����)
	private String carFuel;			//����Ÿ��(�ֹ߷�, LPG, ����, hibrid, ����, ����)
	private String carInfo;			//��������
	private String carCompany;	//������
	private String carImage;		//�����̹���
	
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
