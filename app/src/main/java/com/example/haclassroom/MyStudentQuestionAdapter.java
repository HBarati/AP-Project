package com.example.haclassroom;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class MyStudentQuestionAdapter extends ArrayAdapter {
    private List<MyStudentQuestion> objects ;

    public MyStudentQuestionAdapter(Context context, List<MyStudentQuestion> objects) {
        super(context, R.layout.mystudentquestion_list_item, objects);
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyStudentQuestion question = objects.get(position);
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.mystudentquestion_list_item , parent ,false);
        TextView SQName = view.findViewById(R.id.Student_Question_name);
        TextView SQInfo = view.findViewById(R.id.Student_question_info);

        SQName.setText(question.getQuestion_List_Name());
        SQInfo.setText(question.getQuestion_List_Mood());

        return view;
    }

}
