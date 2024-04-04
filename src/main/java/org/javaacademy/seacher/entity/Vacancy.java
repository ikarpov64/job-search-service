package org.javaacademy.seacher.entity;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class Vacancy {
    private final String jobTitle;
    private final String jobDescription;
    private final BigDecimal salary;
    private final String currency;
}
