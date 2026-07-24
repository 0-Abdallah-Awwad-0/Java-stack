package com.axsosacademy.exam.repositories;

import com.axsosacademy.exam.models.Blog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BlogRepositiry extends CrudRepository <Blog,Long> {
    List<Blog> findAll() ;
}
