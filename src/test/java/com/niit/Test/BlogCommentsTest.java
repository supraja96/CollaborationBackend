package com.niit.Test;
/*
package com.niit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.BlogCommentsDAO;

import com.niit.model.BlogComments;

public class BlogCommentsTest {
	static BlogCommentsDAO blogCommentsDAO;
	@BeforeClass
	public static void initialize(){
	@SuppressWarnings("resource")
	AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
	annotationConfigApplicationContext.scan("com.niit");
	annotationConfigApplicationContext.refresh();
	blogCommentsDAO=(BlogCommentsDAO) annotationConfigApplicationContext.getBean("blogCommentsDAO");
	}
	
	@Test
	public void saveBlogCommentstest() {
		BlogComments blogComments=new BlogComments();
		blogComments.setBlogCommentsId(101);
		blogComments.setBlogId(101);
		blogComments.setComment("good");
		blogComments.setUserId(1);
		blogComments.setUsername("comments");
		
		assertTrue("problem occured",blogCommentsDAO.saveBlogComments(blogComments));
	}
	@Ignore
	@Test
	public void deleteBlogComments(){
		BlogComments blogComments=(BlogComments)blogCommentsDAO.getBlogComments(1);
		assertTrue("",blogCommentsDAO.deleteBlogComments(blogComments));
		
	}
	@Ignore
	@Test
	public void updateCommentsBlog()
	{
		BlogComments blogComments=(BlogComments)blogCommentsDAO.getBlogComments(2);
		blogComments.setComment("nice");
		blogComments.setUserId(501);
		assertTrue("forum is updated",blogCommentsDAO.updateBlogComments(blogComments));
	}
	@Ignore
	@Test
	public void getAllBlogComments(){
		List<BlogComments>blogCommentsList=(List<BlogComments>)blogCommentsDAO.getAllBlogComments();
		assertNotNull("",blogCommentsList.get(0));
		for(BlogComments blogComments:blogCommentsList)
		{
			System.out.println("blogcomment:::="+blogComments.getComment());
	}
	}
	@Ignore
	@Test
	public void getBlogComments(){
		BlogComments blogComments=(BlogComments)blogCommentsDAO.getBlogComments(2);
		assertNotNull("error",blogComments);
		System.out.println("jobs desc is "+blogComments.getBlogCommentsId());
		System.out.println("jobs profile"+blogComments.getComment());
	}
}
*/