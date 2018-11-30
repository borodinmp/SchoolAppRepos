package home.repos;


import home.domain.Testing;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TestingRepo extends CrudRepository<Testing, Long> {

    List<Testing> findByQuestion(String filter);

    List<Testing> getById(Long id);

    @Query(value = "SELECT question FROM TESTING where id = :idx", nativeQuery = true)
    String findQuest(@Param("idx") int index);

    @Query(value = "SELECT checking FROM TESTING where id = :idx", nativeQuery = true)
    boolean findChckQuest(@Param("idx") int index);
}


