package edu.uncc.repository;

import edu.uncc.domain.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author daniel_foglio@premierinc.com
 */
public interface CourseRepository extends JpaRepository<Courses, String> {
}
