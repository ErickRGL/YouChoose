package com.example.mega5.youchoose;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    public void changeRandom(View v){
        Intent intent = new Intent(FirstActivity.this, RandomMapsActivity.class);
        startActivity(intent);

    }

    public void changeFoodSettings(View v){
        Intent intent = new Intent(FirstActivity.this, FoodSettingsActivity.class);
        startActivity(intent);

    }

    public void changeEntertainmentSettings(View v){
        Intent intent = new Intent(FirstActivity.this, EntertainmentSettingsActivity.class);
        startActivity(intent);

    }
}
