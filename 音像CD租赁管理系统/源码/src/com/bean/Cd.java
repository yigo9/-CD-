package com.bean;

import java.io.Serializable;

public class Cd implements Serializable {
	
    private Integer id;
    private String no;
    private String name;
    private String author;
    private Double price;
    private Integer num;
    private String shelf;
    private String remark;
    
    
    private String cdType;
    private String cdLocation;
    
    

    public Cd(String no, String name, String author, Double price, Integer num, String shelf,String remark)  {
    	
		this.no = no;
		this.name = name;
		this.author = author;
		this.price = price;
		this.num = num;
		this.shelf = shelf;
		this.remark = remark;
	}
    
    

	public Cd(String no, String name, String author, Double price, String shelf, String cdType,String cdLocation) {
		
		this.no = no;
		this.name = name;
		this.author = author;
		this.price = price;
		this.shelf = shelf;
		this.cdType = cdType;
		this.cdLocation = cdLocation;
	}


	public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getNo() { return no; }

    public void setNo(String no) { this.no = no; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getAuthor() { return author; }

    public void setAuthor(String author) { this.author = author; }

    public Double getPrice() { return price; }

    public void setPrice(Double price) { this.price = price; }

    public Integer getNum() { return num; }

    public void setNum(Integer num) { this.num = num; }

    public String getShelf() { return shelf; }

    public void setShelf(String shelf) { this.shelf = shelf; }

    public String getRemark() { return remark; }

    public void setRemark(String remark) { this.remark = remark; }
    
	public String getCdType() {return cdType;}

	public void setCdType(String cdType) {this.cdType = cdType;}

	public String getCdLocation() {return cdLocation;}

	public void setCdLocation(String cdLocation) {this.cdLocation = cdLocation;}


    @Override
    public String toString() {
        return "Cd{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", shelf='" + shelf + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}

