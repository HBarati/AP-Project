package com.example.haclassroom;

import java.lang.ref.SoftReference;

public class MyClasses {

    //give the name & Mood & InfoShow from server

    private String Class_List_Name;
    private String Class_List_Mood;
    private String Class_List_InfoShow;

    public MyClasses(String nameOFClass,String MoodOfClass, String InformationToShow){
        this.Class_List_Name = nameOFClass;
        this.Class_List_Mood = MoodOfClass;
        this.Class_List_InfoShow = InformationToShow;
    }

    public String getClass_List_Name() {
        return Class_List_Name;
    }

    public String getClass_List_Mood() {
        return Class_List_Mood;
    }

    public String getClass_List_InfoShow() {
        return Class_List_InfoShow;
    }

    public void setClass_List_Name(String class_List_Name) {
        Class_List_Name = class_List_Name;
    }

    public void setClass_List_Mood(String class_List_Mood) {
        Class_List_Mood = class_List_Mood;
    }

    public void setClass_List_InfoShow(String class_List_InfoShow) {
        Class_List_InfoShow = class_List_InfoShow;
    }

    @Override
    public String toString() {
        return Class_List_Name;
    }
}
