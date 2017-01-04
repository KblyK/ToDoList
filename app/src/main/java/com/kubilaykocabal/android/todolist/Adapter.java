package com.kubilaykocabal.android.todolist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.todoHolder> {

    private Context mContext;
    private List<ToDo> items;

    public Adapter(List<ToDo> items,Context context){
        this.items=items;
        this.mContext=context;
    }
    @Override
    public todoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.yapilacaklar,parent,false);
        todoHolder vh = new todoHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(todoHolder holder, int position) {
        Database db = new Database(mContext);
        holder.mBaslikGoster.setText(db.todo_liste().get(position).getBaslik());
        holder.mİcerikGoster.setText(db.todo_liste().get(position).getIcerik());
    }

    @Override
    public int getItemCount() {
        Database db = new Database(mContext);
        return db.todo_liste().size();
    }

    public class todoHolder extends RecyclerView.ViewHolder{

        TextView mBaslikGoster,mİcerikGoster;

        public todoHolder(View itemView) {
            super(itemView);

            mBaslikGoster=(TextView)itemView.findViewById(R.id.baslikGoster);
            mİcerikGoster=(TextView)itemView.findViewById(R.id.icerikGoster);


        }
    }
}
