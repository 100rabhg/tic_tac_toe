package com.sourabh.tictactoe;

import static com.sourabh.tictactoe.R.color.black;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button btnsingle,btnmulti;
    ConstraintLayout lmain;
    LinearLayout lsun ,lmoon;
    @SuppressLint({"MissingInflatedId", "ResourceAsColor"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnsingle= findViewById(R.id.btnsingle);
        btnmulti= findViewById(R.id.btnmulti);
        lmain= findViewById(R.id.lmain);
        lsun=findViewById(R.id.lsun);
        lmoon=findViewById(R.id.lmoon);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf =  new SimpleDateFormat("HH");
        String currentTimeinHH = sdf.format(new Date());
        int time=Integer.parseInt(currentTimeinHH);
        if(time>=6 && time<12){
//            morning
            lmain.setBackground(getDrawable(R.drawable.morning));
        }
        else if(time>=12 && time<17){
//            afternoon
            lmain.setBackground(getDrawable(R.drawable.afternoon));
        }
        else if(time>=17 && time<19){
//            evening
            lmain.setBackground(getDrawable(R.drawable.evening));
            lsun.setBackground(getDrawable(R.drawable.sun));
        }
        else{
//            night
            lmain.setBackgroundColor(black);
            lmoon.setBackground(getDrawable(R.drawable.moon));
        }
        Intent intent = new Intent(this,MainGame.class);
        btnsingle.setOnClickListener(view -> {
            intent.putExtra("player","single");
            startActivity(intent);

        });
        btnmulti.setOnClickListener(view -> { {
                intent.putExtra("player","multi");
                startActivity(intent);
            }
        });

    }
}