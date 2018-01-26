package android.example.com.ratescurrencyapp;

/**
 * Created by Abbie on 24/01/2018.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class RatesAdapter extends RecyclerView.Adapter<RatesAdapter.ViewHolder>{
    private ArrayList mDataSet;
    private Context mContext;

    public RatesAdapter(Context context, ArrayList<Rate> DataSet){
        mDataSet = DataSet;
        mContext = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextView;
        public LinearLayout mLinearLayout;
        public ViewHolder(View v){
            super(v);
            mTextView = (TextView) v.findViewById(R.id.tv);
            mLinearLayout = (LinearLayout) v.findViewById(R.id.ll);
        }
    }

    @Override
    public RatesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        // Create a new View
        View v = LayoutInflater.from(mContext).inflate(R.layout.custom_view,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        holder.mTextView.setText((Integer) mDataSet.get(position));
    }

    @Override
    public int getItemCount(){
        return mDataSet.size();
    }



}