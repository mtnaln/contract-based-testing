package com.metin.medium.contractbasedtesting.provider.service;

import com.metin.medium.contractbasedtesting.provider.model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private List<Course> courses = new ArrayList<>();

    public CourseService() {
        courses.add(new Course(1L, "Java", true));
        courses.add(new Course(2L, "C#", false));
        courses.add(new Course(3L, "Python", false));
    }

    public Course getCourseById(Long id) {
        Optional<Course> result = courses.stream().filter(course -> course.getId() == id).findFirst();
        return result.isPresent() ? result.get() : null;
    }
}
