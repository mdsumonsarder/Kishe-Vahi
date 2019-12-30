package com.sumon.chasivaitest;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class RainyActivity extends AppCompatActivity {

    ListView summerList;
    CustomListView summerAdapter;
    int[] summImg={R.drawable.deros,R.drawable.tomato,R.drawable.gajor,R.drawable.beans,
            R.drawable.mula,R.drawable.alu,R.drawable.kolanut,
            R.drawable.tormuj,R.drawable.chili,R.drawable.fulkopi};
    String[] sumName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rainy);


        //To change ActionBar title
        getSupportActionBar().setTitle("তালিকা");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        summerList=(ListView)findViewById(R.id.listview_summer_id);
        //String Array;
        sumName=getResources().getStringArray(R.array.rainy_item);
        summerAdapter=new CustomListView(this,summImg,sumName);
        summerList.setAdapter(summerAdapter);

        summerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(RainyActivity.this,ItemDetails1Activity.class);
                if(position==0)
                {
                    intent.putExtra("data","0");
                    startActivity(intent);
                }
                else if(position==1)
                {
                    intent.putExtra("data","1");
                    startActivity(intent);
                }
                else if(position==2)
                {
                    intent.putExtra("data","2");
                    startActivity(intent);
                }
                else if(position==3)
                {
                    intent.putExtra("data","3");
                    startActivity(intent);
                }
                else if(position==4)
                {
                    intent.putExtra("data","4");
                    startActivity(intent);
                }
                else if(position==5)
                {
                    intent.putExtra("data","5");
                    startActivity(intent);
                }
                else if(position==6)
                {
                    intent.putExtra("data","6");
                    startActivity(intent);
                }
                else if(position==7)
                {
                    intent.putExtra("data","7");
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home){
            //Ends the activity
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}

