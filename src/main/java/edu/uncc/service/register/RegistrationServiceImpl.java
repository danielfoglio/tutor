package edu.uncc.service.register;

import edu.uncc.domain.Registration;
import edu.uncc.domain.Student;
import edu.uncc.domain.Tutor;
import edu.uncc.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author daniel_foglio@premierinc.com
 */
@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired RegistrationRepository registrationRepository;

    @Override
    public Registration registerStudentWithTutor(Student student, Tutor tutor) {
        return registrationRepository.save(new Registration(student, tutor));
    }
}
