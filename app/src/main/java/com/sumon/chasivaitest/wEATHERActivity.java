package com.sumon.chasivaitest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class wEATHERActivity extends AppCompatActivity {

    TextView maxText,minText,statText;
    DatabaseReference wref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_w_eather);

        //To change ActionBar title
        getSupportActionBar().setTitle("আবহাওয়া");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        maxText=(TextView)findViewById(R.id.wmax_id);
        minText=(TextView)findViewById(R.id.wmin_id);
        statText=(TextView)findViewById(R.id.wstatus_id);

        wref= FirebaseDatabase.getInstance().getReference("weather").child("1");

        wref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String str1=dataSnapshot.child("max").getValue().toString();
                String str2=dataSnapshot.child("min").getValue().toString();
                String str3=dataSnapshot.child("pred").getValue().toString();

                maxText.setText(str1);
                minText.setText(str2);
                statText.setText(str3);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

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
