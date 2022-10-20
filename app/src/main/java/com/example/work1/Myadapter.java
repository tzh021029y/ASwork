package com.example.work1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Myadapter extends RecyclerView.Adapter<Myadapter.Myholder> {

    private View view;
    private Context context;
    private List<String> list;

    public Myadapter(Context context,List<String> list) {
        this.context = context;
        this.list=list;
    }

    public Myadapter() {
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view= LayoutInflater.from(context).inflate(R.layout.item,null,false);
        Myholder holder;
        holder = new Myholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, @SuppressLint("RecyclerView") int position) {
        holder.textView5.setText(list.get(position));
        holder.textView6.setText(position+"号");
        holder.LL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,MainActivity2.class);
                intent.putExtra("bbb",position);
                context.startActivity(intent);
            }
        });

    }



    @Override
    public int getItemCount() {
        return list.size();

    }
    public class Myholder extends RecyclerView.ViewHolder{
        private final TextView textView5;
        private final TextView textView6;
        private LinearLayout LL;
        public Myholder(@NonNull View itemView) {
            super(itemView);
            textView5=itemView.findViewById(R.id.textView5);
            textView6=itemView.findViewById(R.id.textView6);
            LL=itemView.findViewById(R.id.LinearLayout_1);

        }
    }
}
