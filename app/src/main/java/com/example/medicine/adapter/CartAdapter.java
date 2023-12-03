package com.example.medicine.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.medicine.R;
import com.example.medicine.object.Product;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends ArrayAdapter {
    private Context mcontext;
    ArrayList<Product> listcartProduct;


    public CartAdapter(@NonNull Context context, int resource, List<Product> objects) {
        super(context, resource, objects);
        this.mcontext =context;
        this.listcartProduct = new ArrayList<>(objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater=(LayoutInflater)mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_cart,null);
        }
        if (listcartProduct.size() > 0){
            Product cartProduct = this.listcartProduct.get(position);
            // Anh xa giao dien item
            ImageView imvAnhpro = convertView.findViewById(R.id.imvProductCart);
            TextView txtName = convertView.findViewById(R.id.txtNameProductCart);
            TextView txtDanhMuc = convertView.findViewById((R.id.txtDMcart));
            TextView txtPrice = convertView.findViewById(R.id.txtPrice);
            CheckBox productCheckbox = convertView.findViewById(R.id.checkBox);
            productCheckbox.setChecked(cartProduct.isChecked());

            Glide.with(this.mcontext).load(cartProduct.getImage()).into(imvAnhpro);
            txtName.setText(cartProduct.getName());
            String id = String.valueOf(cartProduct.getCategoryId());
            String price = String.valueOf(cartProduct.getPrice());
            txtDanhMuc.setText("Thuốc Tây");
            txtPrice.setText(price + " vnd");

            // su kien khi checkbox thay doi
            productCheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
                cartProduct.setChecked(isChecked);
            });
        }
        return convertView;
    }

}
