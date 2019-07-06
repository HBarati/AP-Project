package com.example.haclassroom;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class PeapleAdapter extends ArrayAdapter {
    private List<MyPeaple> objects ;

    public PeapleAdapter(Context context, List<MyPeaple> objects) {
        super(context, R.layout.mypeaple_list_item, objects);
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyPeaple Peaple = objects.get(position);
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.mypeaple_list_item , parent ,false);
        TextView PName = view.findViewById(R.id.Peaple_name);
        TextView PInfo = view.findViewById(R.id.Peaple_info);

        PName.setText(Peaple.getPeaple_List_Name());
        PInfo.setText(Peaple.getPeaple_List_Mood());

        return view;
    }
}
