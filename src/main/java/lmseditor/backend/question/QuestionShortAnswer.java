package lmseditor.backend.question;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

import lmseditor.backend.question.component.Answer;
import lmseditor.backend.question.component.TextWithImages;

@XmlAccessorType(XmlAccessType.FIELD)
public class QuestionShortAnswer extends Question{

    @XmlAttribute(name = "type")
    public static final String TYPE = "shortanswer";

    @XmlElement(name = "answer")
    private List<Answer> answers;

    public QuestionShortAnswer() {
        super();
        this.answers = new ArrayList<>();
    }

    public QuestionShortAnswer(String name, TextWithImages textWithImages, List<Answer> answers) {
        super(name, textWithImages);
        this.answers = answers;
    }

    public List<Answer> getAnswers() {
        return this.answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

}