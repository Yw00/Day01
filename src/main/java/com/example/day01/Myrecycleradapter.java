package com.example.day01;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class Myrecycleradapter extends RecyclerView.Adapter {
    Context basecontext;

    public Myrecycleradapter(Context basecontext) {
        this.basecontext = basecontext;
    }
    List<RecentBean> recent=new ArrayList<>();
    public void indata(List<RecentBean> recent){
        this.recent.addAll(recent);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(basecontext).inflate(R.layout.activity_item, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        RecentBean recentBean = recent.get(i);
        //((ViewHolder)viewHolder).desc.setText(recentBean.getThumbnail());
        ((ViewHolder)viewHolder).title.setText(recentBean.getTitle());
        Glide.with(basecontext).load(recentBean.getThumbnail()).into( ((ViewHolder)viewHolder).img);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onclickener!=null){
                    onclickener.indatadj(i);
                }
            }
        });
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (onclickener!=null){
                    onclickener.indatadjlong(i);
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return recent.size();
    }
    class  ViewHolder extends  RecyclerView.ViewHolder{
        ImageView img;
        TextView title;
       // TextView desc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img= itemView.findViewById(R.id.img);
            title= itemView.findViewById(R.id.titles);
          //  desc= itemView.findViewById(R.id.desc);
        }
    }
    Onclickener onclickener;

    public void setOnclickener(Onclickener onclickener) {
        this.onclickener = onclickener;
    }

    public interface  Onclickener{
        void indatadj(int i);
        void indatadjlong(int i);
    }
}
