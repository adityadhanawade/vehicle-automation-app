package com.example.vehical_auto_app;

import android.content.Context;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    ArrayList<User> mList;
    Context context;


    public MyAdapter(ArrayList<User> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.ouritem, parent, false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        User vacancy1 = mList.get(position);
        holder.txtbname.setText("User Name -"+vacancy1.getUsername());
        holder.txtaddress.setText("User no -"+vacancy1.getNumber());
        holder.txttype.setText("Vehicle Problem-"+vacancy1.getProblem());
        holder.txtitem4.setText("Model no -"+vacancy1.getModelno());
        holder.txtitem5.setText("Fuel Type -"+vacancy1.getType());

        Glide.with(holder.img1.getContext()).load(vacancy1.getImageurl()).into(holder.img1);


        holder.send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage("+91"+vacancy1.getNumber(), null, "Booking Confirm", null, null);


            }
        });
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
            txtitem5 = itemView.findViewById(R.id.carname);

            img1 = itemView.findViewById(R.id.img1);

            send = itemView.findViewById(R.id.send);



        }
    }
}
