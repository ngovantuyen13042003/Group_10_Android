package com.example.medicine.api;

import android.os.AsyncTask;
import android.util.Log;

import com.example.medicine.interfaces.LaySPVe;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

public class ApiLaySp extends AsyncTask<Void,Void,Void> {
    String data;
    LaySPVe LaySPVe;
    public  ApiLaySp(LaySPVe laySPVe){
        this.LaySPVe= laySPVe;
        this.LaySPVe.BatDau();
    }
    @Override
    protected Void doInBackground(Void... voids) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://medicine-w344.onrender.com/api/product") //http://192.168.56.1:8080/api/product   https://medicine-w344.onrender.com/api/product
                .build();
        data = null;
        try {
            Response response = client.newCall(request).execute();
            ResponseBody body = response.body();
            data=body.string();
        }catch (IOException e){
            Log.e("AsyncTaskError", "Lỗi xảy ra: " + e.getMessage(), e);
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void Void) {
        if (data == null){
            this.LaySPVe.BiLoi();
        }else {
            this.LaySPVe.KetThuc(data);
        }
    }
}
