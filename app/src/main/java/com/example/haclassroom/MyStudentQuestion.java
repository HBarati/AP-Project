package com.example.haclassroom;

public class MyStudentQuestion {

    private String Question_List_Name;
    private String Question_List_Mood;

    public MyStudentQuestion(){

    }

    public MyStudentQuestion(String nameOfQuestion,String MoodOfQuestion){
        this.Question_List_Name = nameOfQuestion;
        this.Question_List_Mood = MoodOfQuestion;
        Question_List_Mood.toString();
        Question_List_Name.toString();
    }

    public String getQuestion_List_Name() {
        return Question_List_Name;
    }

    public void setQuestion_List_Name(String question_List_Name) {
        Question_List_Name = question_List_Name;
    }

    public String getQuestion_List_Mood() {
        return Question_List_Mood;
    }

    public void setQuestion_List_Mood(String question_List_Mood) {
        Question_List_Mood = question_List_Mood;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
