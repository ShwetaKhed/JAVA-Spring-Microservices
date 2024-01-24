package com.jpa.demo.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseSpringDataJpa extends JpaRepository<Course, Long> {

    List<Course> findByAuthor(String author);


}
