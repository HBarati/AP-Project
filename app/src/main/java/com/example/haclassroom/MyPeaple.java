package com.example.haclassroom;

public class MyPeaple {
    /////////give info from server

    private String Peaple_List_Name;
    private String Peaple_List_Mood;

    public MyPeaple(){

    }

    public MyPeaple(String nameOfPeaple,String MoodOfPeaple){
        this.Peaple_List_Name = nameOfPeaple;
        this.Peaple_List_Mood = MoodOfPeaple;
        Peaple_List_Mood.toString();
        Peaple_List_Name.toString();
    }

    public String getPeaple_List_Name() {
        return Peaple_List_Name;
    }

    public void setPeaple_List_Name(String peaple_List_Name) {
        Peaple_List_Name = peaple_List_Name;
    }

    public String getPeaple_List_Mood() {
        return Peaple_List_Mood;
    }

    public void setPeaple_List_Mood(String peaple_List_Mood) {
        Peaple_List_Mood = peaple_List_Mood;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
