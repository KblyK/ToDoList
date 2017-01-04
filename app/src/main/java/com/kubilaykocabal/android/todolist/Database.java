package com.kubilaykocabal.android.todolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Database {

    private static final int DATABASE_VERSİON=1;
    private static final String DATABASE_NAME="sqlite_database.db";
   //private static final String TABLE_NAME="todo_listesi";
    //private static String TODO_ID="id";
    //private static String TODO_BASLIK="baslik";
   // private static String TODO_ICERIK="icerik";
    //private static Date TODO_TARİH="12/11/1995";
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;
    private Context context;


    public Database(Context contextt){
        //super(context,DATABASE_NAME,null,DATABASE_VERSİON);
        context = contextt;
        dbHelper=new DatabaseHelper(contextt);

    }
    public class DatabaseHelper extends SQLiteOpenHelper {

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSİON);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE [todo_listesi] (\n" +
            "[id] INTEGER PRIMARY KEY AUTOINCREMENT, \n" +
            "[baslik] TEXT, \n" +
            "[icerik] TEXT);\n");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }



    }
    public void todoEkle(String baslik,String icerik){
        db=dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("baslik",baslik);
        values.put("icerik",icerik);
        db.insert("todo_listesi",null,values);
        db.close();
    }
    public List<ToDo> todo_liste(){
        db=dbHelper.getWritableDatabase();
        List<ToDo> toDoList = new ArrayList<>();
        String selectQuery = "SELECT * FROM todo_listesi";
        Cursor cursor = db.rawQuery(selectQuery,null);
        if (cursor != null && !cursor.isClosed()){
            while(cursor.moveToNext()){
                ToDo todo = new ToDo();
                todo.setTodo_id(cursor.getInt(cursor.getColumnIndex("id")));
                todo.setBaslik(cursor.getString(cursor.getColumnIndex("baslik")));
                todo.setIcerik(cursor.getString(cursor.getColumnIndex("icerik")));
                toDoList.add(todo);
            }
            cursor.close();
        }
        db.close();
        return toDoList;
    }}





