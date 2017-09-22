package br.com.alura.checklist.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.checklist.model.Tarefa;

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

    public void insere(Tarefa tarefa) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put("nome", tarefa.getNome());
        dados.put("tarefa", tarefa.getTarefa());
        dados.put("data", tarefa.getData());


        db.insert("Tarefas", null, dados);
    }

    public List<Tarefa> buscaTarefas() {
        String sql = "SELECT * FROM Tarefas;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);

        List<Tarefa> tarefas = new ArrayList<Tarefa>();
        while (c.moveToNext()){
            Tarefa tarefa = new Tarefa();
            tarefa.setId(c.getLong(c.getColumnIndex("id")));
            tarefa.setNome(c.getString(c.getColumnIndex("nome")));
            tarefa.setTarefa(c.getString(c.getColumnIndex("tarefa")));
            tarefa.setData(c.getString(c.getColumnIndex("data")));
            tarefas.add(tarefa);
        }

        c.close();

        return tarefas;
    }

    public void deleta(Tarefa tarefa) {
        SQLiteDatabase db = getWritableDatabase();
        String[] params = {tarefa.getId().toString()};
        db.delete("Tarefas", "id = ?", params);
    }
}
