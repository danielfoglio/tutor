package edu.uncc.repository;

import edu.uncc.domain.Registration;
import edu.uncc.domain.RegistrationPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author daniel_foglio@premierinc.com
 */
public interface RegistrationRepository extends JpaRepository<Registration, RegistrationPK> {
    List<Registration> findAllBySid(String sid);
}