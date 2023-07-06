package com.sourabh.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainGame extends AppCompatActivity {
    TextView txtusersymbol,txtresult;
    ImageButton imgbtn1,imgbtn2,imgbtn3,imgbtn4,imgbtn5,imgbtn6,imgbtn7,imgbtn8,imgbtn9;
    int img1,img2,img3,img4,img5,img6,img7,img8,img9;
    Button btngame;
    String player;
    LinearLayout body;
    boolean isGameOn;
    int count;
    boolean player1_2=true;
    final static String turn_2 = "Player 2 Turn";
    final static String turn_1 = "Player 1 Turn";
    final static String sing = "single";
    final static String mul = "multi";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);

        Intent fromintent = getIntent();

        txtusersymbol= findViewById(R.id.txtusersymbol);
        txtresult= findViewById(R.id.txtresult);
        imgbtn1= findViewById(R.id.imgbtn1);
        imgbtn2= findViewById(R.id.imgbtn2);
        imgbtn3= findViewById(R.id.imgbtn3);
        imgbtn4= findViewById(R.id.imgbtn4);
        imgbtn5= findViewById(R.id.imgbtn5);
        imgbtn6= findViewById(R.id.imgbtn6);
        imgbtn7= findViewById(R.id.imgbtn7);
        imgbtn8= findViewById(R.id.imgbtn8);
        imgbtn9= findViewById(R.id.imgbtn9);
        btngame= findViewById(R.id.btngame);
        body= findViewById(R.id.body);

        player=fromintent.getStringExtra("player");
        setGame();
        btngame.setOnClickListener(view -> newGame());
    }

    private void newGame() {
        Intent intent = new Intent(this,MainGame.class);
        intent.putExtra("player",player);
        finish();
        startActivity(intent);
    }
    @SuppressLint("SetTextI18n")
    private void setGame(){
        if(player.equals(sing)){
            txtusersymbol.setText("YOU X");
        }
        else{
            txtusersymbol.setText(turn_1);
        }
        img1=img2=img3=img4=img5=img6=img7=img8=img9=-1;
        count=0;
        isGameOn=true;
    }
    private int randomIfX(){
        if(img1==1) {
            if (img2 == 1 && img3 == -1) {
                return  3;
            } else if (img3 == 1 && img2 == -1) {
                return  2;
            } else if (img4 == 1 && img7 == -1) {
                return   7;
            } else if (img5 == 1 && img9 == -1) {
                return   9;
            } else if (img7 == 1 && img4 == -1) {
                return   4;
            } else if (img9 == 1 && img5 == -1) {
                return 5;
            }
        }
        if(img2==1) {
            if(img3==1 && img1==-1){
                return 1;
            }
            else if (img5 == 1 && img8==-1) {
                return  8;
            }
            else if (img8 == 1 && img5 == -1) {
                return  5;
            }
        }
        if(img3==1){
            if(img6==1 && img9==-1){
                return 9;
            }
            else if(img9==1 && img6==-1){
                return 6;
            }
            else if(img5==1 && img7==-1){
                return 7;
            }
            else if(img7==1 && img5==-1){
                return 5;
            }
        }
        if(img4==1){
            if(img5==1 && img6==-1){
                return 6;
            }
            else if(img6==1 && img5==-1){
                return 5;
            }
            else if(img7==1 && img1==-1){
                return 1;
            }
        }
        if(img5==1){
            if(img6==1 && img4==-1){
                return 4;
            }
            else if(img7==1 && img3==-1){
                return 3;
            }
            else if(img8==1 && img2==-1){
                return 2;
            }
            else if(img9==1 && img1==-1){
                return 1;
            }
        }
        if(img6==1){
            if(img9==1 && img3==-1){
                return 3;
            }
        }
        if(img7==1){
            if(img8==1 && img9==-1){
                return 9;
            }
            else if (img9==1 && img8==-1){
                return 8;
            }
        }
        if (img8==1 && img9==1 && img7==-1){
            return 7;
        }
        return  0;
    }
    private int randomIfO(){
        if(img1==0) {
            if (img2 == 0 && img3 == -1) {
                return   3;
            } else if (img3 == 0 && img2 == -1) {
                return  2;
            } else if (img4 == 0 && img7 == -1) {
                return  7;
            } else if (img5 == 0 && img9 == -1) {
                return  9;
            } else if (img7 == 0 && img4 == -1) {
                return  4;
            } else if (img9 == 0 && img5 == -1) {
                return  5;
            }
        }
        if(img2==0){
            if(img3==0 && img1==-1){
                return 1;
            }
            else if(img5==0 && img8==-1){
                return 8;
            }
            else if(img8==0 && img5==-1){
                return 5;
            }
        }
        if(img3==0){
            if(img6==0 && img9==-1){
                return 9;
            }
            else if(img9==0 && img6==-1){
                return 6;
            }
            else if(img5==0 && img7==-1){
                return 7;
            }
            else if(img7==0 && img5==-1){
                return 5;
            }
        }
        if(img4==0){
            if(img5==0 && img6==-1){
                return 6;
            }
            else if(img6==0 && img5==-1){
                return 5;
            }
            else if(img7==0 && img1==-1){
                return 1;
            }
        }
        if (img5==0){
            if(img6==0 && img4==-1){
                return 4;
            }
            else if(img7==0 && img3==-1){
                return 3;
            }
            else if(img8==0 && img2==-1){
                return 2;
            }
            else if(img9==0 && img1==-1){
                return 1;
            }
        }
        if(img6==0){
            if(img9==0 && img3==-1){
                return 3;
            }
        }
        if(img7==0){
            if(img8==0 && img9==-1){
                return 9;
            }
            else if (img9==0 && img8==-1){
                return 8;
            }
        }
        if (img8==0 && img9==0 && img7==-1){
            return 7;
        }
        return 0;
    }
    private  void computerTurn(){
        Random random = new Random();
        boolean set=true;
        while(set){
            int random_number=0;
            if(count>=5){
                random_number=randomIfO();
            }
            if(count>=3 && random_number==0) {
                random_number=randomIfX();
            }
            if(random_number==0){
                random_number=random.nextInt(9)+1;
            }
            if(random_number==1 &&img1==-1 ){
                set_O(imgbtn1);
                img1=0;
                set=false;
                count++;
                if(count>4){winner();}
            }
            if(random_number==2 &&img2==-1 ){
                set_O(imgbtn2);
                img2=0;
                set=false;
                count++;
                if(count>4){winner();}
            }
            if(random_number==3 &&img3==-1 ){
                set_O(imgbtn3);
                img3=0;
                set=false;
                count++;
                if(count>4){winner();}
            }
            if(random_number==4 &&img4==-1 ){
                set_O(imgbtn4);
                img4=0;
                set=false;
                count++;
                if(count>4){winner();}
            }
            if(random_number==5 &&img5==-1 ){
                set_O(imgbtn5);
                img5=0;
                set=false;
                count++;
                if(count>4){winner();}
            }
            if(random_number==6 &&img6==-1 ){
                set_O(imgbtn6);
                img6=0;
                set=false;
                count++;
                if(count>4){winner();}
            }
            if(random_number==7 &&img7==-1 ){
                set_O(imgbtn7);
                img7=0;
                set=false;
                count++;
                if(count>4){winner();}
            }
            if(random_number==8 &&img8==-1 ){
                set_O(imgbtn8);
                img8=0;
                set=false;
                count++;
                if(count>4){winner();}
            }
            if(random_number==9 &&img9==-1 ){
                set_O(imgbtn9);
                img9=0;
                set=false;
                count++;
                if(count>4){winner();}
            }
        }
    }
    @SuppressLint("UseCompatLoadingForDrawables")
    private void set_O(ImageButton imgbtn){
        imgbtn.setImageDrawable(getDrawable(R.drawable.o_image));
    }
    @SuppressLint("UseCompatLoadingForDrawables")
    private void set_X(ImageButton imgbtn){
        imgbtn.setImageDrawable(getDrawable(R.drawable.x_image));
    }
    @SuppressLint("SetTextI18n")
    private void win(){
        txtresult.setText("YOU WIN");
        body.setBackgroundColor(getColor(R.color.green));
        body.removeView(txtusersymbol);
        btngame.setHeight(500);
        btngame.setWidth(1000);
        btngame.setTextSize(50);
    }
    @SuppressLint("SetTextI18n")
    private void lose(){
        txtresult.setText("YOU LOSE");
        body.setBackgroundColor(getColor(R.color.red));
        body.removeView(txtusersymbol);
        btngame.setHeight(500);
        btngame.setWidth(1000);
        btngame.setTextSize(50);
    }
    @SuppressLint("SetTextI18n")
    private void tie() {
        txtresult.setText("GAME TIE");
        body.setBackgroundColor(getColor(R.color.yellow));
        body.removeView(txtusersymbol);
        btngame.setHeight(500);
        btngame.setWidth(1000);
        btngame.setTextSize(50);
    }
    @SuppressLint({"SetTextI18n", "UseCompatLoadingForDrawables"})
    private void player1_win() {
        txtresult.setText("Player 1 WIN");
        body.setBackground(getDrawable(R.drawable.playerwinbackground));
        body.removeView(txtusersymbol);
        btngame.setHeight(500);
        btngame.setWidth(1000);
        btngame.setTextSize(50);
    }
    @SuppressLint({"SetTextI18n", "UseCompatLoadingForDrawables"})
    private void player2_win() {
        txtresult.setText("Player 2 WIN");
        body.setBackground(getDrawable(R.drawable.playerwinbackground));
        body.removeView(txtusersymbol);
        btngame.setHeight(500);
        btngame.setWidth(1000);
        btngame.setTextSize(50);
    }

    private void winner(){
        if(img1==img2 && img2==img3 && img1!=-1){
            isGameOn=false;
            if(player.equals(sing) && img1==1 ){
                win();
            }
            else if(player.equals(mul) && img1==1){
                player1_win();
            }
            else if(player.equals(mul) && img1==0){
                player2_win();
            }
            else{
                lose();
            }
        }
        else if(img4==img5 && img5==img6 && img5!=-1){
            isGameOn=false;
            if(player.equals(sing) && img5==1 ){
                win();
            }
            else if(player.equals(mul) && img5==1){
                player1_win();
            }
            else if(player.equals(mul) && img5==0){
                player2_win();
            }
            else{
                lose();
            }
        }
        else if(img7==img8 && img8==img9 && img9!=-1) {
            isGameOn=false;
            if(player.equals(sing) && img9==1 ){
                win();
            }
            else if(player.equals(mul) && img9==1){
                player1_win();
            }
            else if(player.equals(mul) && img9==0){
                player2_win();
            }
            else{
                lose();
            }
        }
        else if(img1==img4 && img4==img7 && img1!=-1){
            isGameOn=false;
            if(player.equals(sing) && img1==1 ){
                win();
            }
            else if(player.equals(mul) && img1==1){
                player1_win();
            }
            else if(player.equals(mul) && img1==0){
                player2_win();
            }
            else{
                lose();
            }
        }
        else if(img2==img5 && img5==img8 && img5!=-1){
            isGameOn=false;
            if(player.equals(sing) && img5==1 ){
                win();
            }
            else if(player.equals(mul) && img5==1){
                player1_win();
            }
            else if(player.equals(mul) && img5==0){
                player2_win();
            }
            else{
                lose();
            }
        }
        else if(img3==img6 && img6==img9 && img9!=-1){
            isGameOn=false;
            if(player.equals(sing) && img9==1 ){
                win();
            }
            else if(player.equals(mul) && img9==1){
                player1_win();
            }
            else if(player.equals(mul) && img9==0){
                player2_win();
            }
            else{
                lose();
            }
        }
        else if(img1==img5 && img5==img9 && img1!=-1){
            isGameOn=false;
            if(player.equals(sing) && img5==1 ){
                win();
            }
            else if(player.equals(mul) && img5==1){
                player1_win();
            }
            else if(player.equals(mul) && img5==0){
                player2_win();
            }
            else{
                lose();
            }
        }
        else if(img3==img5 && img5==img7 && img5!=-1){
            isGameOn=false;
            if(player.equals(sing) && img5==1 ){
                win();
            }
            else if(player.equals(mul) && img5==1){
                player1_win();
            }
            else if(player.equals(mul) && img5==0){
                player2_win();
            }
            else{
                lose();
            }
        }
    }


    @SuppressLint("SetTextI18n")
    public void setXO1(View view) {
        if(img1==-1 && isGameOn) {
            if (player.equals(sing)) {
                set_X(imgbtn1);
                img1=1;
                button();
            }
            if (player.equals(mul)) {
                if(player1_2){
                    set_X(imgbtn1);
                    img1=1;
                    player1_2=false;
                    txtusersymbol.setText(turn_2);
                    buttonply2();
                }
                else{
                    set_O(imgbtn1);
                    img1=0;
                    player1_2=true;
                    txtusersymbol.setText(turn_1);
                    buttonply2();
                }
            }
        }
    }
    @SuppressLint("SetTextI18n")
    public void setXO2(View view) {
        if(img2==-1 && isGameOn) {
            if (player.equals(sing)) {
                set_X(imgbtn2);
                img2=1;
                button();
            }
            if (player.equals(mul)) {
                if(player1_2){
                    set_X(imgbtn2);
                    img2=1;
                    player1_2=false;
                    txtusersymbol.setText(turn_2);
                    buttonply2();
                }
                else{
                    set_O(imgbtn2);
                    img2=0;
                    player1_2=true;
                    txtusersymbol.setText(turn_1);
                    buttonply2();
                }
            }
        }
    }
    @SuppressLint("SetTextI18n")
    public void setXO3(View view) {
        if(img3==-1 && isGameOn) {
            if (player.equals(sing)) {
                set_X(imgbtn3);
                img3=1;
                button();
            }
            if (player.equals(mul)) {
                if(player1_2){
                    set_X(imgbtn3);
                    img3=1;
                    player1_2=false;
                    txtusersymbol.setText(turn_2);
                    buttonply2();
                }
                else{
                    set_O(imgbtn3);
                    img3=0;
                    player1_2=true;
                    txtusersymbol.setText(turn_1);
                    buttonply2();
                }
            }
        }
    }
    @SuppressLint("SetTextI18n")
    public void setXO4(View view) {
        if (img4 == -1 && isGameOn) {
            if (player.equals(sing)) {
                set_X(imgbtn4);
                img4=1;
                button();
            }
            if (player.equals(mul)) {
                if(player1_2){
                    set_X(imgbtn4);
                    img4=1;
                    player1_2=false;
                    txtusersymbol.setText(turn_2);
                    buttonply2();
                }
                else{
                    set_O(imgbtn4);
                    img4=0;
                    player1_2=true;
                    txtusersymbol.setText(turn_1);
                    buttonply2();
                }
            }
        }
    }
    @SuppressLint("SetTextI18n")
    public void setXO5(View view) {
        if(img5==-1 && isGameOn) {
            if (player.equals(sing)) {
                set_X(imgbtn5);
                img5=1;
                button();
            }
            if (player.equals(mul)) {
                if(player1_2){
                    set_X(imgbtn5);
                    img5=1;
                    player1_2=false;
                    txtusersymbol.setText(turn_2);
                    buttonply2();
                }
                else{
                    set_O(imgbtn5);
                    img5=0;
                    player1_2=true;
                    txtusersymbol.setText(turn_1);
                    buttonply2();
                }
            }
        }
    }
    @SuppressLint("SetTextI18n")
    public void setXO6(View view) {
        if(img6==-1 && isGameOn) {
            if (player.equals(sing)) {
                set_X(imgbtn6);
                img6=1;
                button();
            }
            if (player.equals(mul)) {
                if(player1_2){
                    set_X(imgbtn6);
                    img6=1;
                    player1_2=false;
                    txtusersymbol.setText(turn_2);
                    buttonply2();
                }
                else{
                    set_O(imgbtn6);
                    img6=0;
                    player1_2=true;
                    txtusersymbol.setText(turn_1);
                    buttonply2();
                }
            }
        }
    }
    @SuppressLint("SetTextI18n")
    public void setXO7(View view) {
        if(img7==-1 && isGameOn) {
            if (player.equals(sing)) {
                set_X(imgbtn7);
                img7=1;
                button();
            }
            if (player.equals(mul)) {
                if(player1_2){
                    set_X(imgbtn7);
                    img7=1;
                    player1_2=false;
                    txtusersymbol.setText(turn_2);
                    buttonply2();
                }
                else{
                    set_O(imgbtn7);
                    img7=0;
                    player1_2=true;
                    txtusersymbol.setText(turn_1);
                    buttonply2();
                }
            }
        }
    }
    @SuppressLint("SetTextI18n")
    public void setXO8(View view) {
        if(img8==-1 && isGameOn) {
            if (player.equals(sing)) {
                set_X(imgbtn8);
                img8=1;
                button();
            }
            if (player.equals(mul)) {
                if(player1_2){
                    set_X(imgbtn8);
                    img8=1;
                    player1_2=false;
                    txtusersymbol.setText(turn_2);
                    buttonply2();
                }
                else{
                    set_O(imgbtn8);
                    img8=0;
                    player1_2=true;
                    txtusersymbol.setText(turn_1);
                    buttonply2();
                }
            }
        }
    }
    @SuppressLint("SetTextI18n")
    public void setXO9(View view) {
        if(img9==-1 && isGameOn) {
            if (player.equals(sing)) {
                set_X(imgbtn9);
                img9=1;
                button();
            }
            if (player.equals(mul)) {
                if(player1_2){
                    set_X(imgbtn9);
                    img9=1;
                    player1_2=false;
                    txtusersymbol.setText(turn_2);
                    buttonply2();
                }
                else{
                    set_O(imgbtn9);
                    img9=0;
                    player1_2=true;
                    txtusersymbol.setText(turn_1);
                    buttonply2();
                }
            }
        }
    }

    private void button(){
        count++;
        if(count>4){winner();}
        if(count<9 && isGameOn) {
            computerTurn();
        }
        else if(isGameOn){
            tie();
        }
    }
    private void buttonply2(){
        count++;
        if(count>4){winner();}
        if(count>=9 && isGameOn){
            tie();
        }
    }
}