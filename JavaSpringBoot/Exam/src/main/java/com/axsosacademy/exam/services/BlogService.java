package com.axsosacademy.exam.services;

import java.util.List;
import com.axsosacademy.exam.models.Blog;
import org.springframework.stereotype.Service;
import com.axsosacademy.exam.repositories.BlogRepositiry;
@Service
public class BlogService {
    private final BlogRepositiry blogRepository;
    public BlogService(BlogRepositiry blogRepository) {
        this.blogRepository = blogRepository;
    }
    public List<Blog> allBlogs() {
        return blogRepository.findAll();
    }

    public Blog createBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    public Blog findBlog(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    public Blog updateBlog(Blog blog) {return blogRepository.save(blog);}

    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }

}
