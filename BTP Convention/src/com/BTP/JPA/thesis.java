package com.BTP.JPA;

import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

import javax.persistence.Id;

@Entity
public class thesis {
	
	
	public static final String THESIS_SEQUENCE_NAME = "THESIS_SEQUENCE_ID";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int thesis_id;
	
	private String thesis_name;
	
	@Temporal(TemporalType.DATE)
	private Date submitted_date;
	private String status;
	private byte[] thesis_data;
	
	public int getThesis_id() {
		return thesis_id;
	}
	public void setThesis_id(int thesis_id) {
		this.thesis_id = thesis_id;
	}
	public String getThesis_name() {
		return thesis_name;
	}
	public void setThesis_name(String thesis_name) {
		this.thesis_name = thesis_name;
	}
	public Date getSubmitted_date() {
		return submitted_date;
	}
	public void setSubmitted_date(Date submitted_date) {
		this.submitted_date = submitted_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public byte[] getThesis_data() {
		return thesis_data;
	}
	public void setThesis_data(byte[] thesis_data) {
		this.thesis_data = thesis_data;
	}
	
	public static String getThesisSequenceName() {
		return THESIS_SEQUENCE_NAME;
	}
	
	
	
	
}
