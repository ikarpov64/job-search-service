package org.javaacademy.seacher;

import org.javaacademy.seacher.entity.Company;
import org.javaacademy.seacher.entity.User;
import org.javaacademy.seacher.services.JobSearchService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

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
    @DisplayName("Успешное создание резюме для пользователя")
    void createResumeSuccess() {
        User user = jobSearchService.createUser("User", "email@mail.com");
        Assertions.assertDoesNotThrow(() -> jobSearchService.createResume(user, BigDecimal.TEN, "nothing"));
    }

    @Test
    @DisplayName("Успешное получение списка резюме у списка Юзеров")
    void getResumeList() {
        User user1 = jobSearchService.createUser("User1", "email@mail.com");
        User user2 = jobSearchService.createUser("User2", "email@mail.com");
        jobSearchService.createResume(user1, BigDecimal.TEN, "nothing");
        jobSearchService.createResume(user2, BigDecimal.ZERO, "absolutely nothing");

        Assertions.assertDoesNotThrow(() -> jobSearchService.resumeList(List.of(user1, user2)));
        Assertions.assertEquals(2, jobSearchService.resumeList(List.of(user1, user2)).size());
    }

    @Test
    @DisplayName("Корректное создание компании через сервис")
    void createCompanySuccess() {
        Assertions.assertDoesNotThrow(() -> jobSearchService.createCompany(""));
    }

    @Test
    @DisplayName("Успешное добавление вакансии в компанию")
    public void addVacancyToCompanySuccess() {
        Company company = new Company("Test");
        Assertions.assertDoesNotThrow(
                () -> jobSearchService.addVacancyToCompany(company, "", "", BigDecimal.TEN));
    }

    @Test
    @DisplayName("Успешное получение вакансий у компании")
    public void getVacanciesSuccess() {
        Company company = new Company("Test");
        jobSearchService.addVacancyToCompany(company, "v1", "v1", BigDecimal.TEN);
        jobSearchService.addVacancyToCompany(company, "v2", "v2", BigDecimal.TEN);
        jobSearchService.addVacancyToCompany(company, "v3", "v3", BigDecimal.TEN);

        Assertions.assertDoesNotThrow(() -> jobSearchService.vacancyList(company));
        Assertions.assertEquals(3, jobSearchService.vacancyList(company).size());
    }

}
