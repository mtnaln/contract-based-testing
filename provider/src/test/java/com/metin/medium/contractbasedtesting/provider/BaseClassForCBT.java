package com.metin.medium.contractbasedtesting.provider;

import com.metin.medium.contractbasedtesting.provider.controller.CourseController;
import com.metin.medium.contractbasedtesting.provider.model.Course;
import com.metin.medium.contractbasedtesting.provider.service.CourseService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(classes = ProviderApplication.class)
public abstract class BaseClassForCBT {

    @Autowired
    private CourseController courseController;

    @MockBean
    private CourseService courseService;

    @BeforeEach
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(courseController);

        Mockito.when(courseService.getCourseById(1L))
                .thenReturn(new Course(1L, "Java", true));
    }
}





