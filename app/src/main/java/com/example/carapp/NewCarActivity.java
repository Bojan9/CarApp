package com.example.carapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class NewCarActivity extends AppCompatActivity {

    DatabaseHelper mDatabaseHelper;
    private Switch btnSwitch;
    private Button btnGasType, btnDistance, btnFuel, btnCons, btnGas1, btnGas2, btnSave, btnBack;
    private ImageButton btnImg;
    private TextView tVGasType;
    private EditText editTextNAME, editTextDESC;
    private static final String TAG = "ChangePhotoDialog";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.car_new);

        btnSave = (Button)findViewById(R.id.btnSave);
        btnBack = (Button)findViewById(R.id.btnBack);
        btnImg = (ImageButton)findViewById(R.id.imageButton);
        mDatabaseHelper = new DatabaseHelper(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newEntry = editTextNAME.getText().toString();
                if (editTextNAME.length() != 0){
                    AddData(newEntry);
                }else {
                    toastMessage("You must set the name to your car");
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewCarActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btnImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangePhotoDialog dialog = new ChangePhotoDialog();
                dialog.show(getSupportFragmentManager(), getString(R.string.change_photo_dialog));
            }
        });

        editTextNAME = findViewById(R.id.editTextName);
        editTextDESC = findViewById(R.id.editTextDesc);

        btnSwitch = (Switch)findViewById(R.id.switchGasType);
        btnGasType = (Button)findViewById(R.id.btnGasType2);
        tVGasType = (TextView)findViewById(R.id.textViewGasType2);

        btnSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnSwitch.isChecked()){
                    btnGasType.setVisibility(View.VISIBLE);
                    tVGasType.setVisibility(View.VISIBLE);
                }else{
                    btnGasType.setVisibility(View.GONE);
                    tVGasType.setVisibility(View.GONE);
                }
            }
        });
        btnDistance = (Button) findViewById(R.id.buttonDistance);
        btnFuel = (Button) findViewById(R.id.buttonFuel);
        btnCons = (Button) findViewById(R.id.buttonConsumption);
        btnGas1 = (Button) findViewById(R.id.btnGasType1);
        btnGas2 = (Button) findViewById(R.id.btnGasType2);

        btnDistance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(NewCarActivity.this, btnDistance);

                popup.getMenuInflater().inflate(R.menu.popup_menu_distance, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Toast.makeText(
                                NewCarActivity.this, "You clicked: " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popup.show();
            }
        });

        btnFuel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(NewCarActivity.this, btnFuel);

                popup.getMenuInflater().inflate(R.menu.popup_menu_fuel, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Toast.makeText(
                                NewCarActivity.this, "You clicked: " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popup.show();
            }
        });

        btnCons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(NewCarActivity.this, btnCons);

                popup.getMenuInflater().inflate(R.menu.popup_menu_consumption, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Toast.makeText(
                                NewCarActivity.this, "You clicked: " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popup.show();
            }
        });

        btnGas1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(NewCarActivity.this, btnGas1);

                popup.getMenuInflater().inflate(R.menu.popup_menu_gastype, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Toast.makeText(
                                NewCarActivity.this, "You clicked: " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popup.show();
            }
        });

        btnGas2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(NewCarActivity.this, btnGas2);

                popup.getMenuInflater().inflate(R.menu.popup_menu_gastype, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Toast.makeText(
                                NewCarActivity.this, "You clicked: " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popup.show();
            }
        });
    }

    public void AddData(String newEntry){
        boolean insertData = mDatabaseHelper.addData(newEntry);

        if (insertData){
            toastMessage("Data Successfully Inserted");
        } else {
            toastMessage("Something went wrong");
        }
    }

    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}
