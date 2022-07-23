package be.bf.android.demoapp.persistence.dal;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import be.bf.android.demoapp.persistence.entities.User;


public class UserDAO implements Closeable {

    public static final String CREATE_QUERY = "CREATE TABLE user(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, username VARCHAR(50) NOT NULL, password VARCHAR(50));";
    public static final String UPGRADE_QUERY = "DROP TABLE user;";


    private DBHelper helper;
    private SQLiteDatabase database;

    public UserDAO(Context context) {
        //helper = new DBHelper(context);
    }

    public SQLiteDatabase openWritable() {
        return this.database = helper.getWritableDatabase();
    }

    public SQLiteDatabase openReadable() {
        return this.database = helper.getReadableDatabase();
    }

    @SuppressLint("Range")
    public User fromCursor(Cursor cursor) {
        User user = new User();
        user.setUsername(  cursor.getString(cursor.getColumnIndex("username")) );
        user.setPassword(  cursor.getString(cursor.getColumnIndex("password")) );
        return user;
    }


    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        //"SELECT username+ ' '+ password, username, password FROM user"
        Cursor cursor = this.database.query("user",null,null,null,null,null,null);
        cursor.moveToFirst();
        do {
            users.add(this.fromCursor(cursor));
        }while (cursor.moveToNext());
        return users;
    }

    public long insert(User user) {
        ContentValues cv = new ContentValues();
        cv.put("username",user.getUsername());
        cv.put("password",user.getPassword());

        return this.database.insert("user",null,cv);
    }

    public int update(int id,User user) {
        ContentValues cv = new ContentValues();
        cv.put("username",user.getUsername());
        cv.put("password",user.getPassword());

        return this.database.update("user",cv,"id = ?",new String[] {String.valueOf(id)});
    }

    //    public int updateAll(User user) {
//        ContentValues cv = new ContentValues();
//        cv.put("ssin", user.getSsin());
//
//
//        return this.database.update("user", cv, null, null);
//    }


    public int delete(int id) {
        return this.database.delete("user","id = ?",new String[] {String.valueOf(id)});
    }

    @Override
    public void close() throws IOException {
        database.close();
    }

}
