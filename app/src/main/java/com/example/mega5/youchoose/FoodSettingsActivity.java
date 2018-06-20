package com.example.mega5.youchoose;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.nearby.messages.Distance;

import java.util.ArrayList;
import java.util.List;

public class FoodSettingsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    List<Integer> distanceSpinnerArray = new ArrayList<Integer>();
    List<String> priceSpinnerArray = new ArrayList<String>();
    Spinner sItems;
    Spinner pItems;
    private String selectedItem;


    public String getSelectedItem(){
        return selectedItem;
    }

    public void setSelectedItem(String selectedItem){
        this.selectedItem  =  selectedItem;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_settings);

            priceSpinnerArray.add("Barato");
            priceSpinnerArray.add("Medio");
            priceSpinnerArray.add("Elevado");
            distanceSpinnerArray.add(2);
            distanceSpinnerArray.add(5);
            distanceSpinnerArray.add(10);

            ArrayAdapter<Integer> distanceAdapter = new ArrayAdapter<Integer>(
                    this, android.R.layout.simple_spinner_item, distanceSpinnerArray
            );
            ArrayAdapter<String> priceAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, priceSpinnerArray
             );

            distanceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            sItems = (Spinner)findViewById(R.id.spinner4);
            sItems.setAdapter(distanceAdapter);
            sItems.setOnItemSelectedListener(this);

            priceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            pItems = (Spinner)findViewById(R.id.spinner3);
            pItems.setAdapter(priceAdapter);








    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String selectedItem = parent.getItemAtPosition(position).toString();
        setSelectedItem(selectedItem);
        // Showing selected spinner item
        //Toast.makeText(parent.getContext(), "Selected: " + getSelectedItem(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void changeMucha(View v){
        Intent intent = new Intent(FoodSettingsActivity.this, MapsActivity.class);
        //Log.d("Extraaaaaaaaa", selectedItem);

        intent.putExtra("distance", getSelectedItem());
        intent.putExtra("type", "restaurant");
        startActivity(intent);

    }

    public void changePoca(View v){
        Intent intent = new Intent(FoodSettingsActivity.this, MapsActivity.class);
        //Log.d("Extraaaaaaaaa", selectedItem);

        intent.putExtra("distance", getSelectedItem());
        intent.putExtra("type", "cafe");
        startActivity(intent);

    }



}
