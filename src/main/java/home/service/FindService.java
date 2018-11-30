package home.service;

import home.domain.Testing;
import home.repos.TestingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindService {

    private Iterable<Testing> testings;

    @Autowired
    private TestingRepo testingRepo;

    public Iterable find() {
        testings = testingRepo.findAll();
        return testings;
    }

    public Iterable<Testing> getTestings() {
        return testings;
    }

}
