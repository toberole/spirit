package com.zhouwei.anything.xxorm;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by zhouwei on 2017/12/22.
 */

public class DBConfigHelper extends SQLiteOpenHelper {

    public DBConfigHelper(Context context) {
        super(context, "config.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS T_ConfigDb (version TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(int version) {
        String sql = "insert into T_ConfigDb values(" + version + ")";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
        db.close();
    }

    public int get() {
        int version = 0;
        String sql = "select * from T_ConfigDb";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (null != cursor) {
            while (cursor.moveToNext()) {
                version = cursor.getInt(0);
            }
        }
        db.close();
        return version;
    }
}
