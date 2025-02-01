package com.example.butter.blog.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.butter.blog.entity.BlogEntity;

public interface JpaBlogService {

	List<BlogEntity> selectBlogList() throws Exception;

	void saveBlog(BlogEntity blog) throws Exception;
	
	BlogEntity selectBlogDetail(int blogIdx) throws Exception;

	void deleteBlog(int blogIdx);
}
