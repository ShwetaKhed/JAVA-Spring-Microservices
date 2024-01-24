package com.jpa.demo.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJDBCRepo repo;

    @Autowired
    private CourseJPARepo jpaRepo;

    @Autowired
    private CourseSpringDataJpa courseSpringDataJpa;
    @Override
    public void run(String... args) throws Exception {
        //jpaRepo.insert(new Course(1, "Demo2", "Test2"));
        //jpaRepo.insert(new Course(2, "Demo2", "Test2"));
        //jpaRepo.insert(new Course(3, "Demo2", "Test2"));
        //jpaRepo.deleteByID(1L);
        //System.out.println(jpaRepo.findByID(2L));
        courseSpringDataJpa.save(new Course(1, "Demo2", "Test2"));
        courseSpringDataJpa.save(new Course(2, "Demo2", "Test2"));
        courseSpringDataJpa.save(new Course(3, "Demo2", "Test2"));
        courseSpringDataJpa.deleteById(1L);

        //System.out.println(courseSpringDataJpa.findById(2L));
        System.out.println(courseSpringDataJpa.findAll());
        System.out.println(courseSpringDataJpa.count());
        System.out.println(courseSpringDataJpa.findByAuthor("Test22"));

    }
}
