package com.example.vehical_auto_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class OurAdapter extends RecyclerView.Adapter<OurAdapter.ViewHolder> {


    ArrayList<my> mList;
    private final OurAdapter.RecyclerViewClickListener listener;

    public OurAdapter(ArrayList<my> mList, OurAdapter.RecyclerViewClickListener listener) {
        this.mList = mList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        my vacancy1 = mList.get(position);
        holder.txtbname.setText("Shop Name -"+vacancy1.getGaregename());
        holder.txtaddress.setText("Address -"+vacancy1.getAddress());
        holder.txttype.setText("Services -"+vacancy1.getService());
        Glide.with(holder.img1.getContext()).load(vacancy1.getImageurl()).into(holder.img1);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    TextView txtbname,txtaddress,txttype,txtitem4,txtitem5;
    ImageView img1;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        txtbname = itemView.findViewById(R.id.nametext);
        txtaddress = itemView.findViewById(R.id.coursetext);
        txttype = itemView.findViewById(R.id.emailtext);
        img1 = itemView.findViewById(R.id.img1);
        itemView.setOnClickListener(this);
    }

        @Override
        public void onClick(View view) {
            listener.onClick(view,getAdapterPosition());
        }
    }
}
