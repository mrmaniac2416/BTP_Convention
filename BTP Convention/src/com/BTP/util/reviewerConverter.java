package com.BTP.util;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.BTP.JPA.reviewer;
import com.BTP.JPA.reviewerPK;

public class reviewerConverter extends StrutsTypeConverter{

	

@Override
public Object convertFromString(Map context, String[] values, Class toClass) {
	// TODO Auto-generated method stub
	reviewer reviewer=new reviewer();
	System.out.println("in convert from string");
	for(String value:values)
		System.out.println(value);
	reviewerPK reviewerPK=new reviewerPK();
	reviewerPK.setEmail(values[0]);
	reviewerPK.setSupervisor_id(values[1]);
	reviewer.setReviewerId(reviewerPK);
	reviewer.setAddress(values[2]);
	reviewer.setAffiliation(values[3]);
	reviewer.setContact(values[4]);
	reviewer.setDesignation(values[5]);
	reviewer.setName(values[6]);
	reviewer.setReviewerType(values[7]);
	System.out.println("calleddd convert from string");
	
	return reviewer;
}


@Override
public String convertToString(Map context, Object o) {
	// TODO Auto-generated method stub
	String result="";
	System.out.println("in convert to string");
	reviewer reviewer=(reviewer)o;
	
	result+=reviewer.getName()+" ";
	result+=reviewer.getAddress()+" ";
	result+=reviewer.getAffiliation()+" ";
	
	return result;
	
	
}
	
}
