package com.example.test26_04.utils;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.test26_04.models.Order;
import com.example.test26_04.models.Product;

public class ProductItemViewModel extends ViewModel {
    private final MutableLiveData<Product> addedProduct =  new MutableLiveData<Product>();
    private final MutableLiveData<Product> deletedProduct =  new MutableLiveData<Product>();

    public void setAddedProduct (Product product){
        addedProduct.setValue(product);
    }

    public void setDeletedProduct(Product product){
        deletedProduct.setValue(product);
    }

    public LiveData<Product> getAddedProduct(){
        return addedProduct;
    }

    public LiveData<Product> getDeletedProduct(){
        return deletedProduct;
    }
}