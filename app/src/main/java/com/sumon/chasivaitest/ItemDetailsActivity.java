package com.sumon.chasivaitest;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class ItemDetailsActivity extends AppCompatActivity {

    TextView detText_1,detText_2;
    ImageView detImg;
    DatabaseReference dfr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

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
            if(str.matches("0"))
            {
                dfr= FirebaseDatabase.getInstance().getReference("summer").child("1");
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
            else if(str.matches("1"))
            {
                dfr= FirebaseDatabase.getInstance().getReference("summer").child("2");
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
            else if(str.matches("2"))
            {
                dfr= FirebaseDatabase.getInstance().getReference("summer").child("3");
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
            else if(str.matches("3"))
            {
                dfr= FirebaseDatabase.getInstance().getReference("summer").child("4");
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
            else if(str.matches("4"))
            {
                dfr= FirebaseDatabase.getInstance().getReference("summer").child("5");
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
            else if(str.matches("5"))
            {
                dfr= FirebaseDatabase.getInstance().getReference("summer").child("6");
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
            else if(str.matches("6"))
            {
                dfr= FirebaseDatabase.getInstance().getReference("summer").child("7");
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
            else if(str.matches("7"))
            {
                dfr= FirebaseDatabase.getInstance().getReference("summer").child("8");
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
