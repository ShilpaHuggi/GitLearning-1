package com.apex.customer.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
// order of the fields in XML
// @XmlType(propOrder = {"price", "name"})
@XmlAccessorType(XmlAccessType.FIELD)
public  class CustomerPost {
	
	/*


	    @XmlAttribute
	    int id;

	  
	 

*/
	@XmlElement(name = "n")
	String name;
	String job;

	public CustomerPost(String name, String job) {
		super();
		this.name = name;
		this.job = job;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	@Override
	public String toString() {
		return "CustomerPost [name=" + name + ", job=" + job + "]";
	}
	public CustomerPost() {
		super();
		// TODO Auto-generated constructor stub
	}


}
