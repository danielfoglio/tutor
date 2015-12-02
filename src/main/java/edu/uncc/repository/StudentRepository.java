package edu.uncc.repository;

import edu.uncc.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author daniel_foglio@premierinc.com
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student getOneBySid(String login);

}