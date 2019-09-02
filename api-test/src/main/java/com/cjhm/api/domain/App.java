package com.cjhm.api.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name = "APP")

public class App {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long appId;

	@Column
	private String title;

	@Column
	private String content;

	@OneToOne
	@JoinColumn(name = "userId")
	private User user;

	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime created;
	
	@Column(updatable=true)
	@UpdateTimestamp
	private LocalDateTime updated;

	public App() {
		super();
	}

	@Builder
	public App(Long appId, String title, String content, User user) {
		super();
		this.appId = appId;
		this.title = title;
		this.content = content;
		this.user = user;
	}

}
