package home.service;

import home.domain.Testing;
import home.repos.TestingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FindService {

    private Iterable<Testing> testings;

    @Autowired
    private TestingRepo testingRepo;

    public Iterable find (String filter, String selectFilter) {

        if(filter != null & !filter.isEmpty() & selectFilter.equals("2")) {
            testings = testingRepo.
                    findByQuestion(filter);

        } else testings = testingRepo.findAll();

        return testings;
    }

    public Iterable<Testing> getTestings() {
        return testings;
    }

}
