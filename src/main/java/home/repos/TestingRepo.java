package home.repos;


import home.domain.Testing;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TestingRepo extends CrudRepository<Testing, Long>{

    List<Testing> findByQuestion(String filter);


    List<Testing> getById(Long id);
}


