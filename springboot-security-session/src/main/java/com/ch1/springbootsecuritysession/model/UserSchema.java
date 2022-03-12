package com.ch1.springbootsecuritysession.model;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name="tb_user")
public class UserSchema {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seq;
	
	@Column(unique = true , length=100)
	private String username;
	
	@Column(length=100)
	private String password;
	
	@Column(nullable = false, length = 100)
	private String email;
	
	@Column(nullable = false, length = 20)
	private String role; //ROLE_USER, ROLE_ADMIN
	
	@CreationTimestamp
	@Column(name="reg_dttm" , insertable = true)
	private Timestamp regDttm;
	
	@Column(name="reg_user_seq" , insertable = true)
	private int regUserSeq;
	
	@CreationTimestamp
	@Column(name="mod_dttm" , updatable = true)
	private Timestamp modDttm;
	
	@Column(name="mod_user_seq" , updatable = true)
	private int modUserSeq;

	
	
	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Timestamp getRegDttm() {
		return regDttm;
	}

	public void setRegDttm(Timestamp regDttm) {
		this.regDttm = regDttm;
	}

	public int getRegUserSeq() {
		return regUserSeq;
	}

	public void setRegUserSeq(int regUserSeq) {
		this.regUserSeq = regUserSeq;
	}

	public Timestamp getModDttm() {
		return modDttm;
	}

	public void setModDttm(Timestamp modDttm) {
		this.modDttm = modDttm;
	}

	public int getModUserSeq() {
		return modUserSeq;
	}

	public void setModUserSeq(int modUserSeq) {
		this.modUserSeq = modUserSeq;
	}	

}