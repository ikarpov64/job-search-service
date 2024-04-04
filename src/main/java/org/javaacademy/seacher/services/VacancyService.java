package org.javaacademy.seacher.services;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.javaacademy.seacher.entity.Company;
import org.javaacademy.seacher.entity.Vacancy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VacancyService {
    @Value("${currency}")
    private String currency;

    public Company createCompany(@NonNull String companyName) {
        return new Company(companyName);
    }

    public void addVacancyToCompany(@NonNull Company company, String jobTitle, String jobDescription, BigDecimal salary) {
        company.getVacancies().add(new Vacancy(jobTitle, jobDescription, salary, currency));
    }

    public List<Vacancy> vacancyList(@NonNull Company company) {
        return company.getVacancies();
    }
}
