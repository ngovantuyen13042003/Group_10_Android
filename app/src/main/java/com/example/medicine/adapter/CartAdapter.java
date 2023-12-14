package com.example.medicine.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.medicine.R;
import com.example.medicine.model.MyCartModel;
import com.example.medicine.model.Product;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends ArrayAdapter<MyCartModel> {
    private Context mcontext;
    List<MyCartModel> listcartProduct;

    public interface OnDeleteButtonClickListener {
        void onDeleteButtonClick(MyCartModel myCartModel);
    }

    private OnDeleteButtonClickListener deleteButtonClickListener;


    public CartAdapter(@NonNull Context context, int resource, List<MyCartModel> objects) {
        super(context, resource, objects);
        this.mcontext =context;
        this.listcartProduct = new ArrayList<>(objects);
    }
    public void setOnDeleteButtonClickListener(OnDeleteButtonClickListener listener) {
        this.deleteButtonClickListener = listener;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater=(LayoutInflater)mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_cart,null);
        }
        if (listcartProduct.size() > 0){
            MyCartModel cartProduct = this.listcartProduct.get(position);
            // Anh xa giao dien item
            ImageView imvAnhpro = convertView.findViewById(R.id.imvProductCart);
            TextView txtName = convertView.findViewById(R.id.txtNameProductCart);
            TextView txtDanhMuc = convertView.findViewById((R.id.txtDMcart));
            TextView txtPrice = convertView.findViewById(R.id.txtPrice);
            CheckBox productCheckbox = convertView.findViewById(R.id.checkBox);
            ImageView btndelete =convertView.findViewById(R.id.btnxoa);
//            productCheckbox.setChecked(cartProduct.isChecked());

            Glide.with(this.mcontext).load(cartProduct.getImgurl()).into(imvAnhpro);
            txtName.setText(cartProduct.getName());
//            String id = String.valueOf(cartProduct.getCategoryId());
            String price = String.valueOf(cartProduct.getPrice());
            txtDanhMuc.setText("Thuốc tây");
            txtPrice.setText(price + " vnd");

            // su kien khi checkbox thay doi
            productCheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
                cartProduct.setChecked(isChecked);
            });
            btndelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        deleteButtonClickListener.onDeleteButtonClick(listcartProduct.get(position));
                }
            });
        }
        return convertView;
    }

}
