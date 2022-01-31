package com.metin.medium.contractbasedtesting.provider.controller;

import com.metin.medium.contractbasedtesting.provider.model.Course;
import com.metin.medium.contractbasedtesting.provider.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping(value = "/{courseId}")
    public ResponseEntity<?> getCourse(@PathVariable Long courseId) {
        Course course = courseService.getCourseById(courseId);

        if (Objects.isNull(course)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(course);
    }
}
