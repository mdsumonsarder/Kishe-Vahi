package com.sumon.chasivaitest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class GridCustomAdapter extends RecyclerView.Adapter<GridCustomAdapter.MyAdapter> {

    private static ClickListener clickListener;
    Context context;
    int[] gridImg;
    String[] gridName;
    CardView cardView;


    public GridCustomAdapter(Context context, int[] gridImg, String[] gridName) {
        this.context = context;
        this.gridImg = gridImg;
        this.gridName = gridName;
    }

    @Override
    public MyAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.grid_cardview,parent,false);
        return new MyAdapter(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter holder, int position) {
        holder.imageView.setImageResource(gridImg[position]);
        holder.textView.setText(gridName[position]);
    }

    @Override
    public int getItemCount() {
        return gridName.length;
    }

    class MyAdapter extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imageView;
        TextView textView;

        public MyAdapter(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.grid_image_id);
            textView=itemView.findViewById(R.id.grid_text_id);
            cardView=itemView.findViewById(R.id.grid_cardview_id);

            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClickListener(getAdapterPosition(),v);
        }
    }
    public interface ClickListener{

        void onItemClickListener(int pos, View v);
    }
    public void setOnItemClickListener(ClickListener clickListener)
    {
        GridCustomAdapter.clickListener=clickListener;
    }

}
