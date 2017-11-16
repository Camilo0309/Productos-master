package com.example.jonmid.productos.Views;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jonmid.productos.Helpers.SqliteHelper;
import com.example.jonmid.productos.IndexActivity;
import com.example.jonmid.productos.R;

public class EditProductActivity extends AppCompatActivity {

    TextView textViewId;
    TextInputEditText textInputEditTextName;
    TextInputEditText textInputEditTextDescription;
    TextInputEditText textInputEditTextPrice;
    TextInputEditText textInputEditTextImage;
    SqliteHelper sqliteHelper;
    Integer id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_product);

        textViewId = (TextView) findViewById(R.id.id_tv_edit_idproduc);
        textInputEditTextName = (TextInputEditText) findViewById(R.id.id_tiet_edit_name);
        textInputEditTextDescription = (TextInputEditText) findViewById(R.id.id_tiet_edit_description);
        textInputEditTextPrice = (TextInputEditText) findViewById(R.id.id_tiet_edit_price);
        textInputEditTextImage = (TextInputEditText) findViewById(R.id.id_tiet_edit_image);

        sqliteHelper = new SqliteHelper(this, "bd_products", null, 1);

        id = Integer.parseInt(getIntent().getExtras().getString("id"));

        textInputEditTextName.setText( getIntent().getExtras().getString("name") );
        textInputEditTextDescription.setText( getIntent().getExtras().getString("description") );
        textInputEditTextPrice.setText( getIntent().getExtras().getString("price") );
        textInputEditTextImage.setText( getIntent().getExtras().getString("image") );
        textViewId.setText(getIntent().getExtras().getString("id"));

    }

    public void editProduct(View view){
        //
        SQLiteDatabase db = sqliteHelper.getWritableDatabase();
        db.execSQL("update products set name = '"+textInputEditTextName.getText().toString()+"', "
                + "description = '"+textInputEditTextDescription.getText().toString()+"', " +
                "" + "price = '"+textInputEditTextPrice.getText().toString()+"',"+
                "image='"+textInputEditTextImage.getText().toString()+"' where id = "+id);
        Toast.makeText(this, "Contacto fue actualizado correctamente", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, IndexActivity.class);
        startActivity(intent);

    }
}
