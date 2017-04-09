package entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jerieshasmith on 4/2/17.
 */
@Transactional
public interface PersonDao extends CrudRepository<Person, Long> {

    public Person findByEmail(String email);

}
