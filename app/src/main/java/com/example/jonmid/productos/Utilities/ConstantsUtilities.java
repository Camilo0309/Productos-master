package com.example.jonmid.productos.Utilities;

/**
 * Created by jonmid on 16/11/17.
 */

public class ConstantsUtilities {

    public static final String TABLE_NAME_PRODUCTS = "products";
    public static final String TABLE_FIELD_PRODUCTS_ID = "id";
    public static final String TABLE_FIELD_PRODUCTS_NAME = "name";
    public static final String TABLE_FIELD_PRODUCTS_DESCRIPTION = "description";
    public static final String TABLE_FIELD_PRODUCTS_PRICE = "price";
    public static final String TABLE_FIELD_PRODUCTS_IMAGE = "image";
    public static final String CREATE_TABLE_PRODUCTS =
            "CREATE TABLE "+ TABLE_NAME_PRODUCTS+" ("+
                    TABLE_FIELD_PRODUCTS_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    TABLE_FIELD_PRODUCTS_NAME+" TEXT, "+
                    TABLE_FIELD_PRODUCTS_DESCRIPTION+" TEXT, "+
                    TABLE_FIELD_PRODUCTS_PRICE+" TEXT, "+
                    TABLE_FIELD_PRODUCTS_IMAGE+" TEXT)";

}
