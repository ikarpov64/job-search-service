package org.javaacademy.seacher.services;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.javaacademy.seacher.entity.Resume;
import org.javaacademy.seacher.entity.User;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ResumeService {
    public User createUser(@NonNull String name, @NonNull String email) {
        return new User(name, email);
    }

    public void createResume(@NonNull User user,
                             @NonNull BigDecimal wantedSalary,
                             @NonNull String skills) {
        user.setResume(new Resume(wantedSalary, skills));
    }

    public List<Resume> resumeList(@NonNull List<User> users) {
        return users.stream().map(User::getResume).collect(Collectors.toList());
    }
}
