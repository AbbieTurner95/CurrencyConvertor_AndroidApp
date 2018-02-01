package android.example.com.ratescurrencyapp;


import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SpinnerAdapter extends ArrayAdapter<SpinnerData> {

    private int groupid;
    private ArrayList<SpinnerData> list;
    private LayoutInflater inflater;


    public SpinnerAdapter(Activity context, int groupid, int id, ArrayList<SpinnerData> list){
        super(context,id,list);
        this.list = list;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.groupid=groupid;
    }

    public View getView(int position, View convertView, ViewGroup parent ){

        View itemView = inflater.inflate(groupid,parent,false);

        ImageView imageView = itemView.findViewById(R.id.imageView);
        Integer imageId = list.get(position).getImageId();

        if (imageId != null) {
            imageView.setImageResource(imageId);
        }

        TextView textView = itemView.findViewById(R.id.rates_text);
        textView.setText(list.get(position).getText());
        return itemView;
    }

    public View getDropDownView(int position, View convertView, @NonNull ViewGroup parent){
        return getView(position,convertView,parent);

    }
}
