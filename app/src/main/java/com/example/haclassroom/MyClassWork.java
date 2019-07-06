package com.example.haclassroom;

public class MyClassWork {

    //////give info from server

    private String MyClassWork_List_Name;
    private String MyClassWork_List_Mood;

    public MyClassWork(){

    }
    public MyClassWork(String nameOFClassWork,String MoodOfClassWork){
        this.MyClassWork_List_Mood = MoodOfClassWork;
        this.MyClassWork_List_Name = nameOFClassWork;
        MyClassWork_List_Mood.toString();
        MyClassWork_List_Name.toString();
    }

    public String getMyClassWork_List_Name() {
        return MyClassWork_List_Name;
    }

    public void setMyClassWork_List_Name(String myClassWork_List_Name) {
        MyClassWork_List_Name = myClassWork_List_Name;
    }

    public String getMyClassWork_List_Mood() {
        return MyClassWork_List_Mood;
    }

    public void setMyClassWork_List_Mood(String myClassWork_List_Mood) {
        MyClassWork_List_Mood = myClassWork_List_Mood;
    }

    @Override
    public String toString() {

        return super.toString();
    }
}
