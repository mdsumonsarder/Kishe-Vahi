package com.sumon.chasivaitest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class LateAtomActivity extends AppCompatActivity {


    ListView summerList;
    CustomListView summerAdapter;
    int[] summImg={R.drawable.gajor,R.drawable.fulkopi,R.drawable.patakopi,R.drawable.broccoli,
            R.drawable.brusselsprous,
            R.drawable.pumkin,R.drawable.naspati};
    String[] sumName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_late_atom);


        //To change ActionBar title
        getSupportActionBar().setTitle("তালিকা");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        summerList=(ListView)findViewById(R.id.listview_summer_id);
        //String Array;
        sumName=getResources().getStringArray(R.array.lateatom_item);
        summerAdapter=new CustomListView(this,summImg,sumName);
        summerList.setAdapter(summerAdapter);

        summerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(LateAtomActivity.this,ItemDetails3Activity.class);
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

