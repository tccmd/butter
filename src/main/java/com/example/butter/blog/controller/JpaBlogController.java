package com.example.butter.blog.controller;

import java.io.File;
import java.net.URLEncoder;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.example.butter.blog.entity.BlogEntity;
import com.example.butter.blog.service.JpaBlogService;

@Controller
public class JpaBlogController {
	
	@Autowired
	private JpaBlogService jpaBlogService;
	
	@RequestMapping(value="/blog", method=RequestMethod.GET)
	public ModelAndView openBlogList(ModelMap model) throws Exception{
		ModelAndView mv = new ModelAndView("blog");
		
		List<BlogEntity> list = jpaBlogService.selectBlogList();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd", Locale.ENGLISH); 
		list.forEach(blog -> {
			blog.setFormattedCreatedDatetime(blog.getCreatedDatetime().format(formatter));
			
			// blogIdx 값을 기반으로 1~6까지 랜덤 숫자 생성
			int randomImageIndex = (blog.getBlogIdx() % 6) + 1; // 1~6 사이의 숫자
			blog.setRandomImageIndex(randomImageIndex); // BlogEntity에 랜덤 이미지 인덱스 추가
		});

		mv.addObject("list", list);
		
		return mv;
	}
	
	@RequestMapping(value="/blog-write", method=RequestMethod.GET)
	public String openBlogWrite() throws Exception{
		return "blog-write";
	}
	
	@RequestMapping(value="/blog-write", method=RequestMethod.POST)
	public String writeBlog(BlogEntity blog) throws Exception{
		jpaBlogService.saveBlog(blog);
		return "redirect:/blog";
	}
	
	@RequestMapping(value="/blog-details/{blogIdx}", method=RequestMethod.GET)
	public ModelAndView openBlogDetail(@PathVariable("blogIdx") int blogIdx) throws Exception{
		ModelAndView mv = new ModelAndView("blog-details");
		
		BlogEntity blog = jpaBlogService.selectBlogDetail(blogIdx);
		mv.addObject("blog", blog);
		
		return mv;
	}
	
	@RequestMapping(value="/blog/{blogIdx}", method={RequestMethod.PUT, RequestMethod.POST})
	public String updateBlog(BlogEntity blog) throws Exception{
		jpaBlogService.saveBlog(blog);
		return "redirect:/blog";
	}
	
	@RequestMapping(value="/blog/{blogIdx}/delete", method=RequestMethod.POST)
	public String deleteBlog(@PathVariable("blogIdx") int blogIdx) throws Exception{
		jpaBlogService.deleteBlog(blogIdx);
		return "redirect:/blog";
	}
	
	// @RequestMapping(value="/jpa/blog/file", method=RequestMethod.GET)
	// public void downloadBlogFile(int blogIdx, int idx, HttpServletResponse response) throws Exception{
	// 	// BlogFileEntity file = jpaBlogService.selectBlogFileInformation(blogIdx, idx); 
		
	// 	byte[] files = FileUtils.readFileToByteArray(new File(file.getStoredFilePath()));
		
	// 	response.setContentType("application/octet-stream");
	// 	response.setContentLength(files.length);
	// 	response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(file.getOriginalFileName(),"UTF-8")+"\";");
	// 	response.setHeader("Content-Transfer-Encoding", "binary");
		
	// 	response.getOutputStream().write(files);
	// 	response.getOutputStream().flush();
	// 	response.getOutputStream().close();
	// }
}
