package com.metin.medium.contractbasedtesting.consumer;

import com.metin.medium.contractbasedtesting.consumer.model.Course;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DirtiesContext
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureStubRunner(
        stubsMode = StubRunnerProperties.StubsMode.LOCAL,
        ids = "com.metin.medium.contract-based-testing:provider:+:stubs:9494")
class ConsumerApplicationTests {

    private final String PROVIDER_SERVICE = "http://localhost:9494";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void should_get_course_correctly() {
        Course result = restTemplate.getForObject(PROVIDER_SERVICE + "/courses/1", Course.class);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.getId());
        Assertions.assertEquals("Java", result.getName());
        Assertions.assertEquals(Boolean.TRUE, result.isMust());
    }
}
