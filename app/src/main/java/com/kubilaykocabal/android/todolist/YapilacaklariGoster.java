package com.kubilaykocabal.android.todolist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class YapilacaklariGoster extends Activity {


    private RecyclerView mRecyclerView;
    private Adapter mAdapter;
    List<ToDo> mToDoList;
    private RecyclerView.LayoutManager mLayoutManager;
    private Database db;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yapilacaklari_goster);



        mRecyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        mToDoList=new ArrayList<ToDo>();
        db = new Database(this);
        mToDoList=db.todo_liste();
        mAdapter = new Adapter(mToDoList,getApplicationContext());
        mLayoutManager=new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

}
