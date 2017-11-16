package com.example.jonmid.productos;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.jonmid.productos.Adapters.ProductAdapter;
import com.example.jonmid.productos.Helpers.SqliteHelper;
import com.example.jonmid.productos.Models.Product;
import com.example.jonmid.productos.Views.CreateProductActivity;

import java.util.ArrayList;
import java.util.List;

public class IndexActivity extends AppCompatActivity {

    RecyclerView recyclerViewProduct;
    ProductAdapter productAdapter;
    List<Product> productList = new ArrayList<>();
    SqliteHelper sqliteHelper;
    FloatingActionButton floatingActionButtonCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        recyclerViewProduct = (RecyclerView) findViewById(R.id.id_rv_products);
        floatingActionButtonCreate = (FloatingActionButton) findViewById(R.id.id_fab_create);
        sqliteHelper = new SqliteHelper(this, "bd_products", null, 1);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewProduct.setLayoutManager(linearLayoutManager);

        floatingActionButtonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IndexActivity.this, CreateProductActivity.class);
                startActivity(intent);
            }
        });

        listProducts();
    }

    public void listProducts(){
        SQLiteDatabase db = sqliteHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select id,name,description,price,image from products order by id desc", null);

        while (cursor.moveToNext()){
            Product product = new Product();
            product.setId(cursor.getInt(0));
            product.setName(cursor.getString(1));
            product.setDescription(cursor.getString(2));
            product.setPrice(cursor.getString(3));
            product.setImage(cursor.getString(4));
            productList.add(product);
        }

        cursor.close();

        processData();
    }

    public void processData(){
        if (productList.size() != 0){
            productAdapter = new ProductAdapter(productList, getApplicationContext());
            recyclerViewProduct.setAdapter(productAdapter);
        }else{
            Toast.makeText(this, "No hay productos registrados", Toast.LENGTH_SHORT).show();
        }
    }
}
