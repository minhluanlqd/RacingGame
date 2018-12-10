package com.ht.minhluan.racinggame;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView txtPoint;
    CheckBox cbOne, cbTwo, cbThree, cbFour;
    SeekBar sbOne, sbTwo, sbThree, sbFour;
    ImageButton btnPlay;
    int score = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fucn();

// OPEN THIS WHEN HAVE IMAGE
//        sbOne.setEnabled(false);
//        sbTwo.setEnabled(false);
//        sbThree.setEnabled(false);
//        sbFour.setEnabled(false);

        final CountDownTimer countDownTimer = new CountDownTimer(60000, 400) {
            @Override
            public void onTick(long l) {
                int number = 5;
                Random random = new Random();
                int one = random.nextInt(number);
                int two = random.nextInt(number);
                int three = random.nextInt(number);
                int four = random.nextInt(number);
                txtPoint.setText(String.valueOf(score));
                //Check if winning
                if (sbOne.getProgress() >= sbOne.getMax()){
                    this.cancel();
                    Toast.makeText(MainActivity.this,"One Wins",Toast.LENGTH_SHORT).show();
                    if (cbOne.isChecked()){
                        score += 10;
                        Toast.makeText(MainActivity.this,"YOU WIN",Toast.LENGTH_SHORT).show();
                    }else {
                        score -= 10;
                        Toast.makeText(MainActivity.this,"YOU LOSE!!!",Toast.LENGTH_SHORT).show();
                    }
                    txtPoint.setText(String.valueOf(score));
                    btnPlay.setVisibility(View.VISIBLE);

                    enableCheckBox();
                }

                if (sbTwo.getProgress() >= sbTwo.getMax()){
                    this.cancel();
                    Toast.makeText(MainActivity.this,"Two Wins",Toast.LENGTH_SHORT).show();
                    if (cbTwo.isChecked()){
                        score += 10;
                        Toast.makeText(MainActivity.this,"YOU WIN",Toast.LENGTH_SHORT).show();
                    }else {
                        score -= 10;
                        Toast.makeText(MainActivity.this,"YOU LOSE!!!",Toast.LENGTH_SHORT).show();
                    }
                    txtPoint.setText(String.valueOf(score));
                    btnPlay.setVisibility(View.VISIBLE);

                    enableCheckBox();
                }

                if (sbThree.getProgress() >= sbThree.getMax()){
                    this.cancel();
                    Toast.makeText(MainActivity.this,"Three Wins",Toast.LENGTH_SHORT).show();
                    if (cbThree.isChecked()){
                        score += 10;
                        Toast.makeText(MainActivity.this,"YOU WIN",Toast.LENGTH_SHORT).show();
                    }else {
                        score -= 10;
                        Toast.makeText(MainActivity.this,"YOU LOSE!!!",Toast.LENGTH_SHORT).show();
                    }
                    txtPoint.setText(String.valueOf(score));
                    btnPlay.setVisibility(View.VISIBLE);

                    enableCheckBox();
                }

                if (sbFour.getProgress() >= sbFour.getMax()){
                    this.cancel();
                    Toast.makeText(MainActivity.this,"Four Wins",Toast.LENGTH_SHORT).show();
                    if (cbFour.isChecked()){
                        score += 10;
                        Toast.makeText(MainActivity.this,"YOU WIN",Toast.LENGTH_SHORT).show();
                    }else {
                        score -= 10;
                        Toast.makeText(MainActivity.this,"YOU LOSE!!!",Toast.LENGTH_SHORT).show();
                    }
                    txtPoint.setText(String.valueOf(score));
                    btnPlay.setVisibility(View.VISIBLE);

                    enableCheckBox();
                }

                sbOne.setProgress(sbOne.getProgress() + one);
                sbTwo.setProgress(sbTwo.getProgress() + two);
                sbThree.setProgress(sbThree.getProgress() + three);
                sbFour.setProgress(sbFour.getProgress() + four);
            }

            @Override
            public void onFinish() {

            }
        };

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cbOne.isChecked() || cbTwo.isChecked() || cbThree.isChecked() || cbFour.isChecked()){
                    sbOne.setProgress(0);
                    sbTwo.setProgress(0);
                    sbThree.setProgress(0);
                    sbFour.setProgress(0);

                    btnPlay.setVisibility(View.INVISIBLE);
                    countDownTimer.start();

                    disabledCheckBox();
                }else {
                    Toast.makeText(MainActivity.this,"Please choose your monster",Toast.LENGTH_SHORT).show();
                }

            }
        });
        cbOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    cbTwo.setChecked(false);
                    cbThree.setChecked(false);
                    cbFour.setChecked(false);
                }
            }
        });
        cbTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    cbOne.setChecked(false);
                    cbThree.setChecked(false);
                    cbFour.setChecked(false);
                }
            }
        });
        cbThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    cbTwo.setChecked(false);
                    cbOne.setChecked(false);
                    cbFour.setChecked(false);
                }
            }
        });
        cbFour.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    cbTwo.setChecked(false);
                    cbThree.setChecked(false);
                    cbOne.setChecked(false);
                }
            }
        });

    }
    private void Fucn(){
        txtPoint = findViewById(R.id.point);
        cbOne    = findViewById(R.id.pikachu);
        cbTwo    = findViewById(R.id.minion);
        cbThree  = findViewById(R.id.doraemon);
        cbFour   = findViewById(R.id.nemo);
        sbOne    = findViewById(R.id.seekBarPikachu);
        sbTwo    = findViewById(R.id.seekBarMinion);
        sbThree  = findViewById(R.id.seekBarDoraemon);
        sbFour   = findViewById(R.id.seekBarNemo);
        btnPlay  = findViewById(R.id.buttonPlay);
    }
    private void enableCheckBox(){
        cbOne.setEnabled(true);
        cbTwo.setEnabled(true);
        cbThree.setEnabled(true);
        cbFour.setEnabled(true);
    }
    private void disabledCheckBox(){
        cbOne.setEnabled(false);
        cbTwo.setEnabled(false);
        cbThree.setEnabled(false);
        cbFour.setEnabled(false);
    }
}
