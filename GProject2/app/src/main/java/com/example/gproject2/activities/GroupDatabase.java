package com.example.gproject2.activities;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import static java.sql.DriverManager.println;

public class GroupDatabase {
    private static final String TAG = "GroupDatabase";

    private static GroupDatabase database;
    public static String TABLE_GROUP = "GROUP";
    public static int DATABASE_VERSION = 1;
    public static String DATABASE_NAME = "group.db";

    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;
    private Context context;

    private GroupDatabase(Context context) {
        this.context = context;
    }

    public static GroupDatabase getInstance(Context context) {
        if (database == null) {
            database = new GroupDatabase(context);
        }

        return database;
    }

    public boolean open() {
        println("opening database [" + DATABASE_NAME + "].");

        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();

        return true;
    }

    public void close() {
        println("closing database [" + DATABASE_NAME + "].");
        db.close();

        database = null;
    }

    public Cursor rawQuery(String SQL) {
        println("\nexecuteQuery called.\n");

        Cursor cursor = null;
        try {
            cursor = db.rawQuery(SQL, null);
            println("cursor count : " + cursor.getCount());
        } catch (Exception ex) {
            Log.e(TAG, "Exception in executeQuery", ex);
        }

        return cursor;
    }

    public boolean execSQL(String SQL) {
        println("\nexecute called.\n");

        try {
            Log.d(TAG, "SQL : " + SQL);
            db.execSQL(SQL);
        } catch (Exception ex) {
            Log.e(TAG, "Exception in executeQuery", ex);
            return false;
        }
        return true;
    }

    private class DatabaseHelper extends SQLiteOpenHelper {

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            println("creating database [" + DATABASE_NAME + "].");
            println("creating table [" + TABLE_GROUP + "].");

            String DROP_SQL = "drop table if exists " + TABLE_GROUP;
            try {
                db.execSQL(DROP_SQL);
            } catch (Exception ex) {
                Log.e(TAG, "Exception in DROP_SQL", ex);
            }

            String CREATE_SQL = "create table " + TABLE_GROUP + "("
                    + " _id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
                    + " IMAGE INTEGER DEFAULT '', "
                    + " TITLE TEXT DEFAULT '장소/그룹 이름', "
                    + " CATEGORY TEXT DEFAULT '종목', "
                    + " ADDRESS TEXT DEFAULT '주소를 입력하세요.', "
                    + " TIME TEXT DEFAULT '시간', "
                    + " DAY TEXT DEFAULT '요일', "
                    + " CREATE_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP, "
                    + " MODIFY_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP "
                    + ")";

            try {
                db.execSQL(CREATE_SQL);
            } catch (Exception ex) {
                Log.e(TAG, "Exception in CREATE_SQL", ex);
            }
        }

        @Override
        public void onOpen(SQLiteDatabase db) {
            println("opened database [" + DATABASE_NAME + "].");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
            println("Upgrading database from version " + oldVersion + "to " + newVersion + ".");
        }

        private void println(String msg) {
            Log.d(TAG, msg);
        }
    }
}
