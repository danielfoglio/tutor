package edu.uncc.service.register;

import edu.uncc.domain.Registration;
import edu.uncc.domain.Student;
import edu.uncc.domain.Tutor;

/**
 * @author daniel_foglio@premierinc.com
 */
public interface RegistrationService {

    Registration registerStudentWithTutor(Student student, Tutor tutor);
}
