package com.example.medicine.model;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class MyCartModel {
    Integer idCart;
    Integer idUser;
    Integer idProduct;
    String name;
    Integer price;
    Integer quantity;
    Integer totalPrice;
    String imgurl;

    Boolean checked;

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public String formatCurrency(int amount) {
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        currencyVN.setCurrency(Currency.getInstance("VND"));

        return currencyVN.format(amount);
    }

    public Integer getIdCart() {
        return idCart;
    }

    public void setIdCart(Integer idCart) {
        this.idCart = idCart;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public String getPriceCart() {
        return formatCurrency(price);
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    public String getTotalPrice() {
        return formatCurrency(price * quantity);
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    @Override
    public String toString() {
        return "MyCartModel{" +
                "idCart=" + idCart +
                ", idUser=" + idUser +
                ", idProduct=" + idProduct +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", imgurl='" + imgurl + '\'' +
                '}';
    }
}
