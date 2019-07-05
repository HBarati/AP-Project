package com.example.haclassroom;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ClassesAdapter extends ArrayAdapter {

    private List<MyClasses> objects ;

    public ClassesAdapter(Context context, List<MyClasses> objects) {
        super(context, R.layout.myclasses_list_item, objects);
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyClasses Class = objects.get(position);
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.myclasses_list_item,parent,false);
        TextView CName = view.findViewById(R.id.Class_name);
        TextView CInfo = view.findViewById(R.id.Class_info);

        CName.setText(Class.getClass_List_Name());
        CInfo.setText(Class.getClass_List_InfoShow());

        return view;
    }
}
