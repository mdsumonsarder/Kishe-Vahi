package com.sumon.chasivaitest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class ItemDetails7Activity extends AppCompatActivity {

    TextView detText_1,detText_2;
    ImageView detImg;
    DatabaseReference dfr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details7);

        //To change ActionBar title
        getSupportActionBar().setTitle("বিস্তারিত");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        detText_1=(TextView)findViewById(R.id.details_text_1);
        detText_2=(TextView)findViewById(R.id.details_text_2);
        detImg=(ImageView)findViewById(R.id.details_img_id);

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            String str=(String)bundle.get("data");

            dfr= FirebaseDatabase.getInstance().getReference("fish").child("1");
            dfr.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String str1=dataSnapshot.child("descr1").getValue().toString();
                    String str2=dataSnapshot.child("descr2").getValue().toString();
                    String str3=dataSnapshot.child("img").getValue().toString();
                    detText_1.setText(str1);
                    detText_2.setText(str2);
                    Picasso.get().load(str3).into(detImg);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        }
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

