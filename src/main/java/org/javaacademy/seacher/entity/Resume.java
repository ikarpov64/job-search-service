package org.javaacademy.seacher.entity;

import java.math.BigDecimal;
import lombok.Data;
import lombok.NonNull;

@Data
public class Resume {
    @NonNull
    private BigDecimal wantedSalary;
    @NonNull
    private String skills;
}
