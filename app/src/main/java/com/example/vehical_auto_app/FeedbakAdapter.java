package com.example.vehical_auto_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FeedbakAdapter extends RecyclerView.Adapter<FeedbakAdapter.ViewHolder>  {


    ArrayList<Feedback> mList;
    Context context;

    public FeedbakAdapter(ArrayList<Feedback> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.useritem, parent, false);
        return new FeedbakAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        Feedback vacancy1 = mList.get(position);
        holder.txtbname.setText("User Name -"+vacancy1.getName());
        holder.txtaddress.setText("Feedback -"+vacancy1.getFeedback());
        holder.txttype.setText("Rating-"+vacancy1.getRating());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtbname,txtaddress,txttype,txtitem4,txtitem5;
        ImageView img1,send;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtbname = itemView.findViewById(R.id.nametext);
            txtaddress = itemView.findViewById(R.id.coursetext);
            txttype = itemView.findViewById(R.id.emailtext);




        }
    }
}
