package com.example.butter.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.butter.blog.entity.BlogEntity;

public interface JpaBlogRepository extends CrudRepository<BlogEntity, Integer>{

	List<BlogEntity> findAllByOrderByBlogIdxDesc();
	
	// @Query("SELECT file FROM BlogFileEntity file WHERE blog_idx = :blogIdx AND idx = :idx")
	// BlogFileEntity findBlogFile(@Param("blogIdx") int blogIdx, @Param("idx") int idx);
}
