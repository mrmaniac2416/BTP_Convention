package com.BTP.JPA;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class student {
	
	@Id
	private String student_id;
	private String research_area;
	private String supervisor_id;
	private byte[] synopsis;
	@Temporal(TemporalType.DATE)
	private Date synopsis_date;
	private int thesis_id;
	
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getResearch_area() {
		return research_area;
	}
	public void setResearch_area(String research_area) {
		this.research_area = research_area;
	}
	public String getSupervisor_id() {
		return supervisor_id;
	}
	public void setSupervisor_id(String supervisor_id) {
		this.supervisor_id = supervisor_id;
	}
	
	public Date getSynopsis_date() {
		return synopsis_date;
	}
	public void setSynopsis_date(Date synopsis_date) {
		this.synopsis_date = synopsis_date;
	}
	public int getThesis_id() {
		return thesis_id;
	}
	public void setThesis_id(int thesis_id) {
		this.thesis_id = thesis_id;
	}
	
	public void setSynopsis(byte[] synopsis) {
		this.synopsis = synopsis;
	}
	
	public byte[] getSynopsis() {
		return synopsis;
	}
}
