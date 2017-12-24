package com.myProjects.HousingRecord.Domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UserInformation") 
public class UserInformation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double id = 0;
	private String userName;
	private String passWord;
	private int messageNotice;
	//private CustomerLevel customerLevel;
	
	
	public UserInformation(){
		
	}
	
	@Id
	@GeneratedValue
	@Column(name="id")
	public double getId() {
		return id;
	}

	public void setId(double id) {
		this.id = id;
	}

	@Column(name="UserName")  
	public String getUserName() {
		return userName;
	}
	
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name="PassWord")  
	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	/*@Column(name="CustomerLevel")  
	public CustomerLevel getCutomerLevel() {
		return customerLevel;
	}
	
	public void setCutomerLevel(CustomerLevel cutomerLevel) {
		this.customerLevel = cutomerLevel;
	}*/

	@Column(name="MessageNotice")  
	public int getMessageNotice() {
		return messageNotice;
	}
	
	public void setMessageNotice(int messageNotice) {
		this.messageNotice = messageNotice;
	}
	
}
