package com.bean;

import java.io.Serializable;

public class Department implements Serializable
{
    private Integer id;
    private String no;
    private String name;
    
    

    public Department(String no, String name)  {
		this.no = no;
		this.name = name;
	}

	public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getNo() { return no; }

    public void setNo(String no) { this.no = no; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "Department{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
