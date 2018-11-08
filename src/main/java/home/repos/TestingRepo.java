package home.repos;


import home.domain.Testing;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TestingRepo extends CrudRepository<Testing, Long>{

    List<Testing> findByQuestion(String question);

    List<Testing> findById(long id);

    List<Testing> deleteById(long id);
}


