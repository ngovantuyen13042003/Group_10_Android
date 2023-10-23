package com.example.medicine;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class customAdapterAddress extends ArrayAdapter<address_item> {
    public customAdapterAddress(Context context, List<address_item> contacts) {
        super(context, 0, contacts);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        address_item address_i = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_itemaddress, parent, false);
        }

        // Lookup view for data population
        TextView txtaddress = convertView.findViewById(R.id.tvaddress);


        // Populate the data into the template view using the data object
        txtaddress.setText(address_i.getDiachi());
        // Return the completed view to render on screen
        return convertView;
    }
}