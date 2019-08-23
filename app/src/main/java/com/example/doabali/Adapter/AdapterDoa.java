package com.example.doabali.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doabali.DetailDoaActivity;
import com.example.doabali.R;

import java.util.ArrayList;

public class AdapterDoa extends RecyclerView.Adapter<AdapterDoa.ViewHolder>  {
    private ArrayList<String> title;
    private ArrayList<String> subtitle;

    Context ctx;

    public AdapterDoa (Context context, ArrayList<String> Title, ArrayList<String> Subtitle){
        ctx = context;
        title = Title;
        subtitle = Subtitle;

    }


    @NonNull
    @Override
    public AdapterDoa.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // membuat view baru
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_rv_doa, parent, false);
        // mengeset ukuran view, margin, padding, dan parameter layout lainnya
        AdapterDoa.ViewHolder vh = new AdapterDoa.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterDoa.ViewHolder holder, final int position) {
        holder.tvtitle.setText(title.get(position));
        holder.cvMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ctx, DetailDoaActivity.class);
                intent.putExtra("title", title.get(position));
                intent.putExtra("isi", subtitle.get(position));
                ctx.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return title.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvtitle;
        public CardView cvMain;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvtitle = (TextView) itemView.findViewById(R.id.txt_title);
            cvMain = (CardView) itemView.findViewById(R.id.cv_main);
        }
    }
}
