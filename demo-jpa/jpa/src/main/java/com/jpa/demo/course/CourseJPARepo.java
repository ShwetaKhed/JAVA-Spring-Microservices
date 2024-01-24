package com.jpa.demo.course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJPARepo {

    //@Autowired
    // this is a more specific context
    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Course course)
    {
        entityManager.merge(course);
    }

    public Course findByID(long id)
    {
        return entityManager.find(Course.class, id);
    }

    public void deleteByID(long id)
    {
        Course course = findByID(id);
        entityManager.remove(course);
    }

}
