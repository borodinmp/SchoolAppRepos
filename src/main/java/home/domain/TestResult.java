package home.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class TestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Установите значение поля")
    private boolean answer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    private long question_id;

    private String quest;

    private boolean checkQuest;

    public TestResult() {

    }

    public TestResult(boolean answer, User author, long question_id, String quest, boolean checkQuest) {
        this.answer = answer;
        this.author = author;
        this.question_id = question_id;
        this.quest = quest;
        this.checkQuest = checkQuest;
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

    public long getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(long question_id) {
        this.question_id = question_id;
    }

    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";

    }

    public String getQuest() {
        return quest;
    }

    public void setQuest(String quest) {
        this.quest = quest;
    }

    public boolean isCheckQuest() {
        return checkQuest;
    }

    public void setCheckQuest(boolean checkQuest) {
        this.checkQuest = checkQuest;
    }


}

