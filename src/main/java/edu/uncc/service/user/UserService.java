package edu.uncc.service.user;

import edu.uncc.domain.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> getUserById(long id);

    Optional<User> getUserByLogin(String login);

    Collection<User> getAllUsers();

    Collection<User> getAllUsersByRole(Role role);

    List<Tutor> getAllTutors();

    Tutor getTutorByLogin(String login);

    Student getStudentByLogin(String login);

    User create(UserCreateForm form);

    Tutor createTutor(TutorForm form);

    User update(UserCreateForm form);

    Tutor updateTutor(TutorForm form);

    Student createStudent(StudentForm form);

    Student updateStudent(StudentForm form);

}
