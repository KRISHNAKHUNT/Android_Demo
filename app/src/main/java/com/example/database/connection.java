package com.example.database;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import androidx.annotation.Nullable;

public class connection extends SQLiteOpenHelper {
    public static String DATABASE="sample1";
    public static String TABLE="splendor";
    public static String COL_1="id";
    public static String COL_2="name";
    public static String COL_3="city";
    public static String COL_4="marks";

    public connection(@Nullable Context context){
        super(context,DATABASE,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        String sql="create table "+TABLE+" (id integer primary key autoincrement ,name text ,city text ,marks integer)";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i,int i1){
        db.execSQL("drop table "+TABLE);
        onCreate(db);
    }
    public boolean storedata(String s1, String s2, Integer m){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues c1= new ContentValues();
        c1.put(COL_2,s1);
        c1.put(COL_3,s2);
        c1.put(COL_4,m);
        long res=db.insert(TABLE,null,c1);
        return(res==1)?false:true;

    }
    public Cursor fetchData(){
        SQLiteDatabase db=getReadableDatabase();
        return db.query(TABLE,null,null,null,null,null,null);
    }
}
