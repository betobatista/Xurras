package com.betobatista.xurras.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.betobatista.xurras.entities.AmigoEntities;

import java.util.ArrayList;
import java.util.List;

import static com.betobatista.xurras.constants.DatabaseConstants.TABLES.AMIGOS.KEY_CASH;
import static com.betobatista.xurras.constants.DatabaseConstants.TABLES.AMIGOS.KEY_NAME;
import static com.betobatista.xurras.constants.DatabaseConstants.TABLES.AMIGOS.KEY_SEX;
import static com.betobatista.xurras.constants.DatabaseConstants.TABLES.AMIGOS.TABLE_NAME;

public class AmigoRepository {

    private Context context;
    private DAOLite lite;

    public AmigoRepository(Context context) {
        this.context = context;
    }

    public List<AmigoEntities> loadList(){
        List<AmigoEntities> list = new ArrayList<>();
        lite = new DAOLite(context);
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = lite.dbSelect(query);
        if (cursor.moveToFirst()) {
            do {
                list.add(new AmigoEntities(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getDouble(3)));
            } while (cursor.moveToNext());
        }
        return list;
    }

    public boolean insert(String nmAmigo, String sxAmigo, double vlAmigo){
        try{
            lite = new DAOLite(context);
            ContentValues values = new ContentValues();
            values.put(KEY_NAME, nmAmigo);
            values.put(KEY_SEX, sxAmigo);
            values.put(KEY_CASH, vlAmigo);
            lite.dbInsert(TABLE_NAME, values);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
