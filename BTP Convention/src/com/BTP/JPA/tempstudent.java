package com.BTP.JPA;


import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class tempstudent {
	
	@Id
	private String email;
	private String password;
	private String supervisor_id;
	private String research_area;
	private String name;
	private String token;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSupervisor_id() {
		return supervisor_id;
	}
	public void setSupervisor_id(String supervisor_id) {
		this.supervisor_id = supervisor_id;
	}
	public String getResearch_area() {
		return research_area;
	}
	public void setResearch_area(String research_area) {
		this.research_area = research_area;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

}
