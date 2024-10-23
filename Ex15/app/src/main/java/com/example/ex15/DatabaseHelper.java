package com.example.ex15;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Tên cơ sở dữ liệu
    private static final String DATABASE_NAME = "qlsinhvien.db";
    // Phiên bản cơ sở dữ liệu
    private static final int DATABASE_VERSION = 1;

    // Tạo bảng
    private static final String CREATE_TABLE_LOP = "CREATE TABLE tbllop ("
            + "malop TEXT PRIMARY KEY, "
            + "tenlop TEXT, "
            + "siso INTEGER)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Gọi câu lệnh tạo bảng
        db.execSQL(CREATE_TABLE_LOP);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Xóa bảng cũ và tạo bảng mới khi phiên bản cơ sở dữ liệu thay đổi
        db.execSQL("DROP TABLE IF EXISTS tbllop");
        onCreate(db);
    }
}
