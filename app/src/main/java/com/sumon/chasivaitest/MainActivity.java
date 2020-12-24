package com.sumon.chasivaitest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    //image slider
    ImageSlider imageSlider;
    int[] gridImg={R.drawable.summer_button,R.drawable.rain_button,R.drawable.autumn_button,R.drawable.late_autumn,
            R.drawable.winter_button,R.drawable.spring_button};
    String[] gridName;
    GridCustomAdapter customAdapter;
    RecyclerView recyclerView;
    CardView card_cow,card_fish;

    //Logout;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        //for image slider.............
        imageSlider = findViewById(R.id.slider1);
        List<SlideModel> slideModels=new ArrayList<>();

        slideModels.add(new SlideModel("https://images.unsplash.com/photo-1557234195-bd9f290f0e4d?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80","1st image for agriculture"));
        slideModels.add(new SlideModel("https://images.unsplash.com/photo-1559884743-74a57598c6c7?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=755&q=80","2nd image for agriculture"));
        slideModels.add(new SlideModel("https://images.unsplash.com/photo-1558289282-647de9fdf608?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=750&q=80","3rd image for agriculture"));
        slideModels.add(new SlideModel("https://images.unsplash.com/photo-1536330256861-f31e792c966d?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80", "4th image for agriculture"));
        slideModels.add(new SlideModel ("https://images.unsplash.com/photo-1593425543621-8f231f558b17?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80", "5th image for agriculture"));
        slideModels.add(new SlideModel ("https://images.unsplash.com/photo-1570528780926-6435330f7eb6?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=802&q=80", "6th image for agriculture"));

        imageSlider.setImageList(slideModels,true);

        //Logout;
        mAuth = FirebaseAuth.getInstance();


        //To change ActionBar title
        getSupportActionBar().setTitle("ঋতু নির্বাচন করুন");


        card_cow=(CardView)findViewById(R.id.cow_btn_id);
        card_fish=(CardView)findViewById(R.id.fish_btn_id);


        card_cow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ItemDetailsActivity.class);
                startActivity(intent);
            }
        });
        card_fish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ItemDetailsActivity.class);
                startActivity(intent);
            }
        });

        gridName=getResources().getStringArray(R.array.season_button);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerview_id);


        customAdapter=new GridCustomAdapter(this,gridImg,gridName);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,2));

        customAdapter.setOnItemClickListener(new GridCustomAdapter.ClickListener() {
            @Override
            public void onItemClickListener(int pos, View v) {
                if(pos==0)
                {
                    Intent intent=new Intent(getApplicationContext(),SummerActivity.class);
                    startActivity(intent);
                }
                else if(pos==1)
                {
                    Intent intent=new Intent(getApplicationContext(),RainyActivity.class);
                    startActivity(intent);
                }
                else if(pos==2)
                {
                    Intent intent=new Intent(getApplicationContext(),AtomActivity.class);
                    startActivity(intent);
                }
                else if(pos==3)
                {
                    Intent intent=new Intent(getApplicationContext(),LateAtomActivity.class);
                    startActivity(intent);
                }
                else if(pos==4)
                {
                    Intent intent=new Intent(getApplicationContext(),WinterActivity.class);
                    startActivity(intent);
                }
                else if(pos==5)
                {
                    Intent intent=new Intent(getApplicationContext(),SpringActivity.class);
                    startActivity(intent);
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.drawermenu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()==R.id.about)
        {

            Intent intent = new Intent(MainActivity.this,About.class);
            startActivity(intent);
        }

        else   if (item.getItemId()==R.id.secvice)
        {

            Intent intent = new Intent(MainActivity.this,AgServiceActivity.class);
            startActivity(intent);
        }


        else   if (item.getItemId()==R.id.weather)
        {

            Intent intent = new Intent(MainActivity.this,wEATHERActivity.class);
            startActivity(intent);


        }

        else   if (item.getItemId()==R.id.help)
        {


            String phone = "27676";
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
            startActivity(intent);
        }


        else if (item.getItemId()==R.id.share)
        {

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");

            String subject = "চাষী ভাই";
            String body = "This App is very helpfull";

            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            intent.putExtra(Intent.EXTRA_TEXT, body);

            startActivity(Intent.createChooser(intent, "Share with"));

        }



        else if (item.getItemId()==R.id.signout)
        {

            //Intent intent = new Intent(MainActivity.this,About.class);
            //startActivity(intent);


            FirebaseAuth.getInstance().signOut();
            finish();

            Intent intent = new Intent(getApplicationContext(),SignInActivity.class);
            startActivity(intent);


            Toast.makeText(this, "Signout", Toast.LENGTH_SHORT).show();
        }




        return super.onOptionsItemSelected(item);
    }
}
