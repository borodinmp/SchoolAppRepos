package home.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class TestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long questionId;

    private boolean answer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;


    @ManyToMany
    @JoinTable(
            name = "question_answer",
            joinColumns = {@JoinColumn(name = "testing_id")},
            inverseJoinColumns = {@JoinColumn(name = "test_result_id")}
    )
    private Set<TestResult> testResultSet;

    public TestResult(){

    }
    public TestResult(boolean answer){
    this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Set<TestResult> getTestResultSet() {
        return testResultSet;
    }

    public void setTestResultSet(Set<TestResult> testResultSet) {
        this.testResultSet = testResultSet;
    }
}

