package home.repos;


import home.domain.TestResult;
import home.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TestResultRepo extends CrudRepository<TestResult, Long> {

    List<TestResult> findById(long id);

    List<TestResult> deleteAllByAuthor(User author);



}


