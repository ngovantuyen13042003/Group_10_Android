package com.example.medicine.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;import retrofit2.Callback;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.medicine.R;
import com.example.medicine.api.AppApi;
import com.example.medicine.api.CartAPI;
import com.example.medicine.model.MyCartModel;
import com.example.medicine.model.Product;
import com.example.medicine.model.User;
import com.example.medicine.product_detail;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
        if (arr.size()>0) {
            Product product = this.arr.get(position);
            ImageView productImg = convertView.findViewById(R.id.productImage);
            TextView productname = convertView.findViewById(R.id.productname);
            TextView productDescription = convertView.findViewById(R.id.desscription);
            TextView productprice = convertView.findViewById(R.id.productprice);
            TextView cart = convertView.findViewById(R.id.cart);
            Button xoa = convertView.findViewById(R.id.btnDecrease1);

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
                    intent.putExtra("price", clickedProduct.getPrice());
                    intent.putExtra("description", clickedProduct.getDescription());
                    intent.putExtra("img", clickedProduct.getImage());
                    intent.putExtra("danhmuc", clickedProduct.getCategoryId());
                    // Thêm các thông tin sản phẩm khác cần thiết vào Intent nếu cần

                    ct.startActivity(intent);
                }
            });
            SharedPreferences sharedPreferences = ct.getSharedPreferences("product_data", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            Set<String> productSet = sharedPreferences.getStringSet("product_set", new HashSet<>());
            cart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(AppApi.BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(new OkHttpClient.Builder().build())
                            .build();

                    CartAPI categoryAPI = retrofit.create(CartAPI.class);
                    Product product1 = arr.get(position);
                    MyCartModel myCartModel = new MyCartModel();
                    myCartModel.setIdProduct(product1.getId());
                    myCartModel.setName(product1.getName());
                    myCartModel.setImgurl(product1.getImage());
                    myCartModel.setPrice(product1.getPrice());
                    myCartModel.setQuantity(1);
                    myCartModel.setTotalPrice(product1.getPrice());

                    SharedPreferences sharedPreferences = ct.getSharedPreferences("user_data", Context.MODE_PRIVATE);
                    String userJson = sharedPreferences.getString("user_object", "");
                    Gson gson = new Gson();
                    User user = gson.fromJson(userJson, User.class);

                    Log.i("product id: ", product1.getId() + "");
                    Log.i("User id: ", user.getId() + "");

                    myCartModel.setIdUser(user.getId());


                    Call<MyCartModel> call = categoryAPI.addToCart(myCartModel);
                    call.enqueue(new Callback<MyCartModel>() {
                        @Override
                        public void onResponse(Call<MyCartModel> call, Response<MyCartModel> response) {
                            if(response.isSuccessful()) {
                                MyCartModel data = response.body();
                                Toast.makeText(ct, "Đã thêm " + product.getName() + " vào giỏ hàng", Toast.LENGTH_SHORT).show();
                            }else {
                                Log.e("API ERROR", "goi failed");
                                Toast.makeText(ct, "them failed " + product.getName() + " vào giỏ hàng", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<MyCartModel> call, Throwable t) {
                            Log.e("API Error", "Failed to fetch data: " + t.getMessage());
                            Toast.makeText(ct, "goi failed " + product.getName() + " vào giỏ hàng", Toast.LENGTH_SHORT).show();
                        }
                    });

//                    Product product1 = arr.get(position);
//                    Gson gson = new Gson();
//// Chuyển đổi sản phẩm thành chuỗi JSON và thêm vào danh sách
//                    String productJson = gson.toJson(product1);
//                    productSet.add(productJson);
//// Lưu danh sách sản phẩm mới vào SharedPreferences
//                    editor.clear();
//                    editor.putStringSet("product_set", productSet);
//                    editor.apply();

                }
            });
        }



        return convertView;
    }
}
