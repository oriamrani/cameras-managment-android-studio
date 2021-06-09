package com.example.tutorial;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String CAMERAS_TABLE = "CAMERAS_TABLE";
    public static final String COLUMN_CAMERA_NAME = "CAMERA_NAME";
    public static final String COLUMN_IP = "IP";
    public static final String COLUMN_PORT = "PORT";
    public static final String COLUMN_USER_NAME = "USER_NAME";
    public static final String COLUMN_PASSWORD = "PASSWORD";
    public static final String COLUMN_ID = "ID";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "camera.db", null, 1);
    }

    // this is called the first time a database is accessed. There should be code in here to create new database.
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableStatement = "CREATE TABLE " + CAMERAS_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_CAMERA_NAME + " TEXT, " + COLUMN_IP + " TEXT, " + COLUMN_PORT + " INT, " + COLUMN_USER_NAME + " TEXT, " + COLUMN_PASSWORD + " TEXT)";

        sqLiteDatabase.execSQL(createTableStatement);
    }


    // this is called if the database version number changes. It prevents previous users apps from breaking when you change the database design.
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addOne(CameraModel cameraModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_CAMERA_NAME,cameraModel.getCameraName());
        cv.put(COLUMN_IP,cameraModel.getIpAddress());
        cv.put(COLUMN_PORT,cameraModel.getPort());
        cv.put(COLUMN_USER_NAME,cameraModel.getUserName());
        cv.put(COLUMN_PASSWORD,cameraModel.getPassword());

        long insert = db.insert(CAMERAS_TABLE, null ,cv);

        if(insert == -1) {
            return false;
        }
        else {
            return true;
        }

    }

    public List<CameraModel> getCameras(){
        List<CameraModel> cameras = new ArrayList<>();
        String queryString = "SELECT * FROM " + CAMERAS_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst()) {
            // loop through the results

            do {
                int cameraID = cursor.getInt(0);
                String cameraName = cursor.getString(1);
                String ip = cursor.getString(2);
                int port = cursor.getInt(3);
                String userName = cursor.getString(4);
                String password = cursor.getString(5);

                CameraModel cameraModel = new CameraModel(cameraName, ip, port,
                        userName, password, cameraID);
                cameras.add(cameraModel);

            } while(cursor.moveToNext());
        }
        else {
        }
        cursor.close();
        db.close();
        return cameras;
    }

    public boolean deleteOne(int cameraID){
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString ="DELETE FROM "+CAMERAS_TABLE+" WHERE "+COLUMN_ID+" = "+cameraID;
        Cursor cursor = db.rawQuery(queryString,null);
        if(cursor.moveToFirst()){
            return true;
        }else{
            return false;
        }
    }
}
