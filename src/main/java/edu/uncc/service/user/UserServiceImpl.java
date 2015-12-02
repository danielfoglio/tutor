package edu.uncc.service.user;

import edu.uncc.domain.*;
import edu.uncc.repository.StudentRepository;
import edu.uncc.repository.TutorRepository;
import edu.uncc.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;
    private final TutorRepository tutorRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, TutorRepository tutorRepository, StudentRepository studentRepository) {
        this.userRepository = userRepository;
        this.tutorRepository = tutorRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public Optional<User> getUserById(long id) {
        LOGGER.debug("Getting user={}", id);
        return Optional.ofNullable(userRepository.findOne(id));
    }

    @Override
    public Optional<User> getUserByLogin(String login) {
        LOGGER.debug("Getting user by login={}", login);
        return userRepository.findOneByLogin(login);
    }

    @Override
    public Collection<User> getAllUsers() {
        LOGGER.debug("Getting all users");
        return userRepository.findAll(new Sort("login"));
    }

    @Override
    public Collection<User> getAllUsersByRole(Role role) {
        LOGGER.debug("Getting all "+role +" users");
        return userRepository.findAllByRole(role);
    }

    @Override
    public List<Tutor> getAllTutors() {
        LOGGER.debug("Getting all tutors");
        return tutorRepository.findAll();
    }

    @Override
    public Tutor getTutorByLogin(String login) {
        return tutorRepository.getOneByTid(login);
    }

    @Override
    public Student getStudentByLogin(String login) {
        return studentRepository.getOneBySid(login);
    }

    @Override
    public User create(UserCreateForm form) {
        User user = new User();
        user.setLogin(form.getLogin());
        user.setPasswordHash(new BCryptPasswordEncoder().encode(form.getPassword()));
        user.setRole(form.getRole());
        return userRepository.save(user);
    }


    @Override
    public User update(UserCreateForm form) {
        User user = new User();
        user.setId(form.getId());
        user.setLogin(form.getLogin());
        user.setPasswordHash(new BCryptPasswordEncoder().encode(form.getPassword()));
        user.setRole(form.getRole());
        return userRepository.save(user);
    }

    @Override
    public Tutor createTutor(TutorForm form) {

        Tutor t = tutorRepository.save(new Tutor(form));
        create(form);
        return  t;
    }

    @Override
    public Tutor updateTutor(TutorForm form) {
        Tutor t = tutorRepository.save(new Tutor(form));
        update(form);
        return  t;
    }

    @Override
    public Student createStudent(StudentForm form) {

        Student s = studentRepository.save(new Student(form));
        create(form);
        return s;
    }

    @Override
    public Student updateStudent(StudentForm form) {
        Student s = studentRepository.save(new Student(form));
        update(form);
        return s;
    }

}
