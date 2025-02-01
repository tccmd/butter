package com.example.butter.blog.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="t_jpa_blog")
@NoArgsConstructor
@Data
public class BlogEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int blogIdx;

	@Column(nullable=false)
	private String title;
	
	@Column(nullable=false)
	private String contents;
	
	@Column(nullable=false)
	private int hitCnt = 0;
	
	@Column(nullable=false)
	private String creatorId;
	
	@Column(nullable=false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private LocalDateTime createdDatetime = LocalDateTime.now();
	
	private String updaterId;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private LocalDateTime updatedDatetime;

	@Transient  // DB에 저장되지 않도록 설정
    private String formattedCreatedDatetime;  // 포맷된 날짜를 저장할 필드

	@Transient  // DB에 저장되지 않도록 설정
	private int randomImageIndex; // 랜덤 이미지 인덱스 추가
}
