package com.example.haclassroom;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ClassWorkAdapter extends ArrayAdapter {
    private List<MyClassWork> objects ;

    public ClassWorkAdapter(Context context, List<MyClassWork> objects) {
        super(context, R.layout.myclasswork_list_item, objects);
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyClassWork ClassWork = objects.get(position);
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.myclasswork_list_item , parent ,false);
        TextView CWName = view.findViewById(R.id.ClassWork_name);
        TextView CWInfo = view.findViewById(R.id.ClassWork_info);

        CWName.setText(ClassWork.getMyClassWork_List_Name());
        CWInfo.setText(ClassWork.getMyClassWork_List_Mood());

        return view;
    }
}
