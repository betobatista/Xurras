package com.betobatista.xurras.repository;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

import com.betobatista.xurras.constants.DatabaseConstants;

import static com.betobatista.xurras.constants.DatabaseConstants.SQLITE.DATABASE_NAME;
import static com.betobatista.xurras.constants.DatabaseConstants.SQLITE.DATABASE_VER;
import static com.betobatista.xurras.constants.DatabaseConstants.TABLES.AMIGOS.KEY_CASH;
import static com.betobatista.xurras.constants.DatabaseConstants.TABLES.AMIGOS.KEY_ID;
import static com.betobatista.xurras.constants.DatabaseConstants.TABLES.AMIGOS.KEY_NAME;
import static com.betobatista.xurras.constants.DatabaseConstants.TABLES.AMIGOS.KEY_SEX;
import static com.betobatista.xurras.constants.DatabaseConstants.TABLES.AMIGOS.TABLE_NAME;


/**
 * Created by adalberto on 28/02/18.
 */

public class DAOLite extends SQLiteOpenHelper {

    public DAOLite(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VER);
    }

    @Override
    public void onCreate(android.database.sqlite.SQLiteDatabase sqLiteDatabase) {
        String CREATE_CONFIG_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " + KEY_ID + " INTEGER PRIMARY KEY, "
                                                                          + KEY_NAME + " TEXT, "
                                                                          + KEY_SEX + " TEXT, "
                                                                          + KEY_CASH + " REAL)";
        sqLiteDatabase.execSQL(CREATE_CONFIG_TABLE);


    }

    @Override
    public void onUpgrade(android.database.sqlite.SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Derruba tabela existente //
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // Cria a nova tabela //
        onCreate(sqLiteDatabase);

    }
    /*

    public void addConfig(ConfigObjeto objeto){
        android.database.sqlite.SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, objeto.getDbId());
        values.put(KEY_DB, objeto.getDbDesc());
        values.put(KEY_USER, objeto.getDbUser());
        values.put(KEY_PASS, objeto.getDbPass());

        // Inserir linha //
        sqLiteDatabase.insert(TABLE_CONFIG, null, values);
        sqLiteDatabase.close();
    }

    /*public ConfigObjeto getConfig(int id){
        android.database.sqlite.SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query(TABLE_CONFIG, new String[] {KEY_ID, KEY_DB, KEY_USER, KEY_PASS} , KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        ConfigObjeto objeto = new ConfigObjeto(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3));

        return objeto;
    }

    public ConfigObjeto getConfig(int id) {
        android.database.sqlite.SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ConfigObjeto objeto = null;
        String query = "SELECT * FROM " + TABLE_CONFIG + " WHERE " + KEY_ID + " = 1";
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        if(cursor.moveToFirst()){
            objeto = new ConfigObjeto(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3));
        }
        return objeto;
    }

    public int updateConfig(ConfigObjeto objeto){
        android.database.sqlite.SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_DB, objeto.getDbDesc());
        values.put(KEY_USER, objeto.getDbUser());
        values.put(KEY_PASS, objeto.getDbPass());

        return sqLiteDatabase.update(TABLE_CONFIG, values, KEY_ID + " = ?",
                new String[]{String.valueOf(1)});
    }


    // Outros metodos que podem ser utilizado no sqlite //

    /*

    // Lista a tabela inteira //
    public List<Contact> getAllContacts() {
    List<Contact> contactList = new ArrayList<Contact>();
    // Select All Query
    String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

    DAOLite db = this.getWritableDatabase();
    Cursor cursor = db.rawQuery(selectQuery, null);

    // looping through all rows and adding to list
    if (cursor.moveToFirst()) {
        do {
            Contact contact = new Contact();
            contact.setID(Integer.parseInt(cursor.getString(0)));
            contact.setName(cursor.getString(1));
            contact.setPhoneNumber(cursor.getString(2));
            // Adding contact to list
            contactList.add(contact);
        } while (cursor.moveToNext());
    }

    // return contact list
    return contactList;
    }

    // Getting contacts Count
    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
        DAOLite db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

    deleteContact()
    // Deleting single contact
        public void deleteContact(Contact contact) {
        DAOLite db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getID()) });
        db.close();
    }
     */


}
