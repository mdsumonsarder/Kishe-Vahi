package com.sumon.chasivaitest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListView extends BaseAdapter {

    LayoutInflater inflater;
    Context context;
    int[] sumImg;
    String[] sumName;

    public CustomListView(Context context, int[] sumImg, String[] sumName) {
        this.context = context;
        this.sumImg = sumImg;
        this.sumName = sumName;
    }

    @Override
    public int getCount() {
        return sumName.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null)
        {
            inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.custom_listview,parent,false);
        }
        ImageView sumImage;
        TextView sumText;

        sumImage=convertView.findViewById(R.id.list_img_id);
        sumText=convertView.findViewById(R.id.list_text_id);

        sumImage.setImageResource(sumImg[position]);
        sumText.setText(sumName[position]);
        return convertView;
    }
}
