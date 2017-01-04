package com.kubilaykocabal.android.todolist;

public class ToDo {
    public int todo_id;
    public String baslik;
    public String icerik;
    public ToDo(){

    }
    public ToDo(int todo_id,String baslik,String icerik){
        this.todo_id = todo_id;
        this.baslik=baslik;
        this.icerik=icerik;
    }

    public int getTodo_id() {
        return todo_id;
    }

    public void setTodo_id(int todo_id) {
        this.todo_id = todo_id;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }
}
