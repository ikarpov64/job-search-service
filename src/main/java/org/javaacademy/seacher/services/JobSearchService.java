package org.javaacademy.seacher.services;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.javaacademy.seacher.entity.Company;
import org.javaacademy.seacher.entity.Resume;
import org.javaacademy.seacher.entity.User;
import org.javaacademy.seacher.entity.Vacancy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class JobSearchService {
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private VacancyService vacancyService;

    public void createCompany(String name) {
        vacancyService.createCompany(name);
    }

    public void addVacancyToCompany(Company company, String jobTitle, String jobDescription, BigDecimal salary) {
        vacancyService.addVacancyToCompany(company, jobTitle, jobDescription, salary);
    }

    public List<Vacancy> vacancyList(Company company) {
        return vacancyService.vacancyList(company);
    }

    public User createUser(@NonNull String name, @NonNull String email) {
        return resumeService.createUser(name, email);
    }

    public void createResume(@NonNull User user,
                             @NonNull BigDecimal wantedSalary,
                             @NonNull String skills) {
        resumeService.createResume(user, wantedSalary, skills);
    }

    public List<Resume> resumeList(@NonNull List<User> users) {
        return resumeService.resumeList(users);
    }
}
