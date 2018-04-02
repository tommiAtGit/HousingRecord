package com.myProjects.HousingRecord.Domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UserInformation") 
public class UserInformation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id = 0;
	private String UserName;
	private String UserPwd;
	private int messageNotice;
	//private CustomerLevel customerLevel;
	
	
	public UserInformation(){
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name="UserName")  
	public String getUserName() {
		return UserName;
	}
	
	
	public void setUserName(String userName) {
		this.UserName = userName;
	}

	@Column(name="UserPwd")  
	public String getPassWord() {
		return UserPwd;
	}

	public void setPassWord(String passWord) {
		this.UserPwd = passWord;
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
