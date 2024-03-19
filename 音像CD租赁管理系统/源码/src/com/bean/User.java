package com.bean;

import java.io.Serializable;

public class User implements Serializable
{
    private Integer id;
    private Integer vipNo;
    private String username;
    private String password;
    
    

    public User(Integer vipNo, String username, String password) {
		this.vipNo = vipNo;
		this.username = username;
		this.password = password;
	}

	public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Integer getVipNo() { return vipNo; }

    public void setVipNo(Integer vipNo) { this.vipNo = vipNo; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return "User{" +
                "studentNo=" + vipNo +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
