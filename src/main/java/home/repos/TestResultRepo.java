package home.repos;


import home.domain.TestResult;
import home.domain.Testing;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface TestResultRepo extends CrudRepository<TestResult, Long> {

    List<TestResult> findById(long id);


}


