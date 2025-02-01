package com.example.butter.blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.butter.blog.entity.BlogEntity;
import com.example.butter.blog.repository.JpaBlogRepository;

@Service
public class JpaBlogServiceImpl implements JpaBlogService{
	
	@Autowired
	JpaBlogRepository jpaBlogRepository;
	

	@Override
	public List<BlogEntity> selectBlogList() throws Exception {
		return jpaBlogRepository.findAllByOrderByBlogIdxDesc();
	}

	@Override
	public void saveBlog(BlogEntity blog) throws Exception {
		// blog.setCreatorId("admin");
		jpaBlogRepository.save(blog);
	}
	
	@Override
	public BlogEntity selectBlogDetail(int blogIdx) throws Exception{
		Optional<BlogEntity> optional = jpaBlogRepository.findById(blogIdx);
		if(optional.isPresent()){
			BlogEntity blog = optional.get();
			blog.setHitCnt(blog.getHitCnt() + 1);
			jpaBlogRepository.save(blog);
			
			return blog;
		}
		else {
			throw new NullPointerException();
		}
	}

	@Override
	public void deleteBlog(int blogIdx) {
		jpaBlogRepository.deleteById(blogIdx);
	}
}
