package edu.uncc.repository;

import edu.uncc.domain.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author daniel_foglio@premierinc.com
 */

public interface TutorRepository extends JpaRepository<Tutor, Long> {

    Tutor getOneByTid(String tid);

}
