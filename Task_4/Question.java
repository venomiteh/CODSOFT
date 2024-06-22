package Task_4;

import java.util.List;

public class Question {
    private String Question;
    private List<String> Options;
    private String CorrectAnswer;

public Question(String question,List<String> options,String correctAnswer){
    this.CorrectAnswer=correctAnswer;
    this.Options=options;
    this.Question=question;
}

public String getQuestion(){
    return Question;
}

public List<String> getOptions(){
    return Options;
}
public String getCorrectAnswer(){
    return CorrectAnswer;
}




























}
