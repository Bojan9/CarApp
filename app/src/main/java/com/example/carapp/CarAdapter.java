package com.example.carapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class CarAdapter extends ArrayAdapter<Car> {

    private Context mContext;
    private List<Car> carList = new ArrayList<>();

    public CarAdapter(Context context, ArrayList<Car> list) {
        super(context, 0, list);
        mContext = context;
        carList = list;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View listItem = convertView;
        if (listItem == null){
            listItem = LayoutInflater.from(mContext).inflate(R.layout.car_card,parent,false);
        }
        Car currentCar = carList.get(position);

//        ImageView image = (ImageView)listItem.findViewById(R.id.carImage);
//        image.setImageResource(currentCar.getmImageDrawable());

        TextView name = (TextView)listItem.findViewById(R.id.carName);
        name.setText(currentCar.getName());

        TextView distance = (TextView)listItem.findViewById(R.id.carDistance);
        name.setText(currentCar.getName());
//
//        TextView fuel = (TextView)listItem.findViewById(R.id.carFuel);
//        name.setText(currentCar.getName());
//
//        TextView consumption = (TextView)listItem.findViewById(R.id.carConsumption);
//        name.setText(currentCar.getName());

        return listItem;
    }

}
