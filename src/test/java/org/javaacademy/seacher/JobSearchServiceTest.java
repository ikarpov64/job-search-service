package org.javaacademy.seacher;

import jdk.jfr.Name;
import org.javaacademy.seacher.entity.User;
import org.javaacademy.seacher.services.JobSearchService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;

@SpringBootTest
public class JobSearchServiceTest {
    @Autowired
    private JobSearchService jobSearchService;

    @Test
    @DisplayName("Корректное создание пользователя")
    void createUserSuccess() {
        Assertions.assertDoesNotThrow(() -> jobSearchService.createUser("", ""));
        User user = jobSearchService.createUser("User", "email@mail.com");
        Assertions.assertEquals("User", user.getName());
        Assertions.assertEquals("email@mail.com", user.getEmail());
    }

    @Test
    void createResumeSuccess() {
        User user = jobSearchService.createUser("User", "email@mail.com");
        Assertions.assertDoesNotThrow(() -> jobSearchService.createResume(user, BigDecimal.TEN, "nothing"));
    }

    @Test
    void getResumeList() {

    }

}
