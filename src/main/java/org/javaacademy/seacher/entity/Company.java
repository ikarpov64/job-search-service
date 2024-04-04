package org.javaacademy.seacher.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
public class Company {
    private final String name;
    @Setter
    private List<Vacancy> vacancies = new ArrayList<>();
}
