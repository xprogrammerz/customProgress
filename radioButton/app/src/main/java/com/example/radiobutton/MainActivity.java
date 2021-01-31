package com.example.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.github.ybq.android.spinkit.style.Wave;

public class MainActivity extends AppCompatActivity {
private CheckBox cbFootball,cbSquash,cbCricket;
private RadioGroup rgGender;
private ProgressBar progressBar,secondBar,customBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cbCricket=findViewById(R.id.cbCricket);
        cbFootball=findViewById(R.id.cbFootball);
        cbSquash=findViewById(R.id.cbSquash);
        rgGender=findViewById(R.id.rgGender);
progressBar=findViewById(R.id.progressBar);
secondBar=findViewById(R.id.secondBar);

        customBar = (ProgressBar)findViewById(R.id.spin_kit);
        Sprite doubleBounce = new DoubleBounce();
        progressBar.setIndeterminateDrawable(doubleBounce);


Thread thread=new Thread(new Runnable() {
    @Override
    public void run() {
        for(int i=0;i<10;i++){
        secondBar.incrementProgressBy(10);
            SystemClock.sleep(500);
    }
    }
});
thread.start();


        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rbMale:
                        Toast.makeText(MainActivity.this, "Male is selected in Gender", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                        break;
                    case R.id.rbFemale:
                        Toast.makeText(MainActivity.this, "Female is selected in Gender", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                        break;
                    case R.id.rbOther:
                        Toast.makeText(MainActivity.this, "Others is selected in Gender", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.VISIBLE);
                    default:
                        break;
                }
            }
        });

        cbCricket.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "Cricket is Selectd in Sports", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cbSquash.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    Toast.makeText(MainActivity.this, "Squash is selected in sports", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cbFootball.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    Toast.makeText(MainActivity.this, "Football is selected in sports", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}