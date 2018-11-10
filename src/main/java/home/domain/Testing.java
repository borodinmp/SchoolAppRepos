package home.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

@Entity
public class Testing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Please fill the text")
    @Length(max = 255, message = "Text is to long")
    private String question;

    @ManyToMany
    @JoinTable(
            name = "question_answer",
            joinColumns = {@JoinColumn(name = "test_result_id")},
            inverseJoinColumns = {@JoinColumn(name = "testing_id")}
    )
    private Set<Testing> testingSet;

    public Testing() {
    }

    public Testing(String question) {
        this.question = question;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

}