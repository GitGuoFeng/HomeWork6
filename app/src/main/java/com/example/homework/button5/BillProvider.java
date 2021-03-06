package com.example.homework.button5;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class BillProvider extends ContentProvider {
    private static final UriMatcher MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
    private static String authority = "com.example.homenwork.button5.billProvider";
    private static final int USER_CODE = 1;
    private DBManager myDataBase;
    private SQLiteDatabase db;
    static {
        MATCHER.addURI(authority, null, USER_CODE);
    }
    @Override
    public boolean onCreate() {
        myDataBase = new DBManager(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        db = myDataBase.getWritableDatabase();
        return db.query("tallylaydb ", new String[]{"name","money"}, null, null, null, null, sortOrder);
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        db = myDataBase.getWritableDatabase();
        db.insert("tallylaydb ",null,values);
        db.close();
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
