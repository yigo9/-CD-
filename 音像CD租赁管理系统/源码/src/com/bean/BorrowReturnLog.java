package com.bean;

import java.io.Serializable;

public class BorrowReturnLog implements Serializable{
	
	private Integer vipNo;
	private String cdNo;
	private String borrowDate;
	private String backDate;
	private Integer renew;
	
	private String vipName;
	private Integer vipAge;
	private String vipSex;
	private String vipTelephone;
	private String vipMajor;

	private Double fineMoney;
	
	private Integer cdNum;
	private String cdName;
	private String cdAuthor;
	private Double cdPrice;
	private String cdType;
	private String cdLocation;
	


	
	public BorrowReturnLog(Integer vipNo, String cdNo, String borrowDate, Integer renew) {
		
		this.vipNo = vipNo;
		this.cdNo = cdNo;
		this.borrowDate = borrowDate;
		this.renew = renew;
	}
	
	public BorrowReturnLog(String cdNo, String cdName,String cdAuthor,Double cdPrice,String borrowDate,String backDate,String cdType,String cdLocation,Integer renew) {
		
		this.cdNo = cdNo;
		this.cdName = cdName;
		this.cdAuthor = cdAuthor;
		this.cdPrice = cdPrice;
		this.borrowDate = borrowDate;
		this.backDate = backDate;
		this.cdType = cdType;
		this.cdLocation = cdLocation;
		this.renew = renew;
	}
	
	

	public BorrowReturnLog(String cdNo, Integer cdNum, String cdName, String cdAuthor, Double cdPrice,String cdType, String cdLocation) {
		this.cdNo = cdNo;
		this.cdNum = cdNum;
		this.cdName = cdName;
		this.cdAuthor = cdAuthor;
		this.cdPrice = cdPrice;
		this.cdType = cdType;
		this.cdLocation = cdLocation;
	}
	
	
	
	

	public BorrowReturnLog(Integer vipNo, String vipName, Integer vipAge, String vipSex,String vipTelephone, String vipMajor, Double fineMoney) {
		
		this.vipNo = vipNo;
		this.vipName = vipName;
		this.vipAge = vipAge;
		this.vipSex = vipSex;
		this.vipTelephone = vipTelephone;
		this.vipMajor = vipMajor;
		this.fineMoney = fineMoney;
	}


	public String getVipName() {return vipName;}

	public void setVipName(String vipName) {this.vipName = vipName;}

	public Integer getVipAge() {return vipAge;}

	public void setStudentAge(Integer vipAge) {this.vipAge = vipAge;}

	public String getVipSex() {return vipSex;}

	public void setVipSex(String vipSex) {this.vipSex = vipSex;}

	public String getVipTelephone() {return vipTelephone;}

	public void setVipTelephone(String vipTelephone) {this.vipTelephone = vipTelephone;}

	public String getVipMajor() {return vipMajor;}

	public void setVipMajor(String vipMajor) {this.vipMajor = vipMajor;}

	public Double getFineMoney() {return fineMoney;}

	public void setFineMoney(Double fineMoney) {this.fineMoney = fineMoney;}

	public Integer getCdNum() {return cdNum;}

	public void setCdNum(Integer cdNum) {this.cdNum = cdNum;}

	public Integer getVipNo() {return vipNo;}

	public void setVipNo(Integer vipNo) {this.vipNo = vipNo;}

	public String getCdNo() {return cdNo;}

	public void setCdNo(String cdNo) {this.cdNo= cdNo;}

	public String getBorrowDate() {return borrowDate;}

	public void setBorrowDate(String borrowDate) {this.borrowDate = borrowDate;}

	public String getBackDate() {return backDate;}

	public void setBackDate(String backDate) {this.backDate = backDate;}

	public Integer getRenew() {return renew;}

	public void setRenew(Integer renew) {this.renew = renew;}

	public String getCdName() {return cdName;}

	public void setCdName(String cdName) {	this.cdName = cdName;}

	public String getCdAuthor() {return cdAuthor;}

	public void setCdAuthor(String cdAuthor) {this.cdAuthor = cdAuthor;}

	public Double getCdPrice() {return cdPrice;}

	public void setCdPrice(Double cdPrice) {this.cdPrice = cdPrice;}

	public String getCdType() {return cdType;}

	public void setCdType(String cdType) {this.cdType = cdType;}

	public String getCdLocation() {return cdLocation;}

	public void setCdLocation(String cdLocation) {this.cdLocation = cdLocation;}
	
	
	
}
