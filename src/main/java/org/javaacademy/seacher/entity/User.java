package org.javaacademy.seacher.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
public class User {
    private final String name;
    private final String email;
    @Setter
    private Resume resume;
}
