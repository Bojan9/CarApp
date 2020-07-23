package com.example.carapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnNew;
    private ListView listView;
    private CarAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNew = (Button) findViewById(R.id.btnNew);
        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNewCarActivity();
            }
        });

        listView = (ListView)findViewById(R.id.listOfCars);
        ArrayList<Car> carArrayList = new ArrayList<>();

//        carArrayList.add(new Car("sd"));

        DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);
        Cursor cursor = databaseHelper.getAllData();

        if(!cursor.moveToNext()){
            Toast.makeText(
                    MainActivity.this, "There are no contacts to show", Toast.LENGTH_SHORT).show();
        }

        while (cursor.moveToNext()){
            carArrayList.add(new Car(
                    cursor.getString(1)
            ));
        }

        mAdapter = new CarAdapter(this,carArrayList);
        listView.setAdapter(mAdapter);
    }

    public void openNewCarActivity(){
        Intent intent = new Intent(this, NewCarActivity.class);
        startActivity(intent);
    }
}
