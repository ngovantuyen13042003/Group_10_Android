package com.example.medicine.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import retrofit2.converter.gson.GsonConverterFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.medicine.R;
import com.example.medicine.cart;
import com.example.medicine.object.Product;
import com.example.medicine.product_detail;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductAdapter extends ArrayAdapter<Product> {
    private Context ct;
    private ArrayList<Product> arr;
    public ProductAdapter( Context context, int resource, List<Product> objects) {
        super(context, resource, objects);
        this.ct=context;
        this.arr = new ArrayList<>(objects);
    }
    public void sortProduct(String s){
        s= s.toUpperCase();
        int k=0;
        for(int i=0; i< arr.size();i++){
            Product p = arr.get(i);
            String ten  = p.getName().toUpperCase();
            if(ten.indexOf(s)>= 0){
                arr.set(i,arr.get(k));
                arr.set(k,p);
                k++;
            }

        }
        notifyDataSetChanged(); // ham load lai list sp sau khi sap xep
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if ((convertView == null)) {

            LayoutInflater inflater=(LayoutInflater)ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_product,null);
        }
        if (arr.size()>0){
            Product product =this.arr.get(position);
            ImageView productImg = convertView.findViewById(R.id.productImage);
            TextView productname = convertView.findViewById(R.id.productname);
            TextView productDescription = convertView.findViewById(R.id.desscription);
            TextView productprice = convertView.findViewById(R.id.productprice);
            TextView cart = convertView.findViewById(R.id.cart);

            Glide.with(this.ct).load(product.getImage()).into(productImg);
            productname.setText(product.getName());
            productDescription.setText(product.getDescription());

            String pricetext = String.valueOf(product.getPrice());
            productprice.setText(pricetext);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Lấy sản phẩm được click
                    Product clickedProduct = arr.get(position);

                    // Chuyển sang trang product_detail và truyền thông tin sản phẩm
                    Intent intent = new Intent(ct, product_detail.class);
                    intent.putExtra("productName", clickedProduct.getName());
                    intent.putExtra("price",clickedProduct.getPrice());
                    intent.putExtra("description", clickedProduct.getDescription());
                    intent.putExtra("img",clickedProduct.getImage());
                    intent.putExtra("danhmuc",clickedProduct.getCategoryId());
                    // Thêm các thông tin sản phẩm khác cần thiết vào Intent nếu cần

                    ct.startActivity(intent);
                }
            });
            cart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Product product1 = arr.get(position);

                    // gui  product qua cart
//                    Intent intent = new Intent(ct,com.example.medicine.cart.class);
//                    intent.putExtra("name",product1.getName());
//                    intent.putExtra("price",product1.getPrice());
//                    intent.putExtra("dm",product1.getCategoryId());
//                    intent.putExtra("img",product1.getImage());
//                    ct.startActivity(intent);
                    SharedPreferences sharedPreferences = ct.getSharedPreferences("product_data", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    Set<String> productSet = sharedPreferences.getStringSet("product_set", new HashSet<>());
                    Gson gson = new Gson();
// Chuyển đổi sản phẩm thành chuỗi JSON và thêm vào danh sách
                    String productJson = gson.toJson(product1);
                    productSet.add(productJson);
// Lưu danh sách sản phẩm mới vào SharedPreferences
                    editor.putStringSet("product_set", productSet);
                    editor.apply();
                    Toast.makeText(ct, "Đã thêm " + product.getName() + " vào giỏ hàng", Toast.LENGTH_SHORT).show();
                }
            });

        }
        return convertView;
    }
}
