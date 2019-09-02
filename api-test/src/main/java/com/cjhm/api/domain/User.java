package com.cjhm.api.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	@Column
	private String loginId;

	@Column
//	@JsonIgnore
	private String password;
	
	@Column
	private String username;

	public User() {
		super();
	}

	@Builder
	public User(Long userId, String loginId, String password, String username) {
		super();
		this.userId = userId;
		this.loginId = loginId;
		this.password = password;
		this.username = username;
	}

}
