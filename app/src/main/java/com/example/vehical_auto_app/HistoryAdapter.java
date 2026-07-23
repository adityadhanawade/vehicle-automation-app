package com.example.vehical_auto_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class HistoryAdapter  extends RecyclerView.Adapter<HistoryAdapter.ViewHolder>{


    ArrayList<User> mList;
    Context context;

    public HistoryAdapter(ArrayList<User> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.historylist, parent, false);
        return new HistoryAdapter.ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        User vacancy1 = mList.get(position);
        holder.txtbname.setText("Name -"+vacancy1.getGname());
        holder.txtaddress.setText("Number -"+vacancy1.getGnumber());
        holder.txttype.setText("Address-"+vacancy1.getGaddress());
        holder.txtitem4.setText("Problem-"+vacancy1.getProblem());


        Glide.with(holder.img1.getContext()).load(vacancy1.getImageurl()).into(holder.img1);
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
            txtitem4 = itemView.findViewById(R.id.carno);


            img1 = itemView.findViewById(R.id.img1);





        }
    }
}
