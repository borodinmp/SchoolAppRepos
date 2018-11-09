package home.repos;


import home.domain.Testing;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TestResultgRepo extends CrudRepository<Testing, Long>{

    List<Testing> findById(long id);


}


