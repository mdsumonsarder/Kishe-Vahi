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

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    ViewFlipper viewFlipper;
    int[] vFlip={R.drawable.p1,R.drawable.p4,R.drawable.p2,R.drawable.banner_6,
            R.drawable.banner_7};

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
        viewFlipper=(ViewFlipper)findViewById(R.id.viewFlipper_id);
        for(int passImg: vFlip)
        {
            recvFlipImg(passImg);
        }

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
    public void recvFlipImg(int rcvImg)
    {
        ImageView imageView=new ImageView(this);
        imageView.setImageResource(rcvImg);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(2000);
        viewFlipper.setAutoStart(true);
        viewFlipper.setInAnimation(this,android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this,android.R.anim.slide_out_right);
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

      else   if (item.getItemId()==R.id.about)
        {

            Intent intent = new Intent(MainActivity.this,About.class);
            startActivity(intent);
        }


      else   if (item.getItemId()==R.id.weather)
        {

            Intent intent = new Intent(MainActivity.this,wEATHERActivity.class);
            startActivity(intent);


        }

      else   if (item.getItemId()==R.id.hoteline)
        {

            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:16123"));

            if (ActivityCompat.checkSelfPermission(MainActivity.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            }
            startActivity(callIntent);
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

       else if (item.getItemId()==R.id.support)
        {

            //Intent intent = new Intent(MainActivity.this,About.class);
            //startActivity(intent);

            Toast.makeText(this, "Support", Toast.LENGTH_SHORT).show();
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
