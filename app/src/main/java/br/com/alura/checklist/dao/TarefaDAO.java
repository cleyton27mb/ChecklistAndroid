package br.com.alura.checklist.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by cleyton on 20/09/17.
 */

public class TarefaDAO extends SQLiteOpenHelper {

    public TarefaDAO(Context context) {
        super(context, "Checklist", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String sql = "CREATE TABLE Tarefas (id INTEGER PRIMARY KEY, nome TEXT, tarefa TEXT, data TEXT);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    String sql ="DROP TABLE IF EXISTS Tarefas";
    db.execSQL(sql);
    onCreate(db);
    }
}
