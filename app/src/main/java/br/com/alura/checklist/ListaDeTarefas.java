package br.com.alura.checklist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListaDeTarefas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_tarefas);

        String[] tarefas = {"Lavar louça", "Limpar a casa", "Alimentar o cachorro","Lavar louça", "Limpar a casa", "Alimentar o cachorro"
        ,"Lavar louça", "Limpar a casa", "Alimentar o cachorro","Lavar louça", "Limpar a casa", "Alimentar o cachorro"};
        ListView listaDeTarefas = (ListView) findViewById(R.id.lista_tarefas);
        ArrayAdapter<String> adapter = new ArrayAdapter (this,android.R.layout.simple_list_item_1, tarefas);
        listaDeTarefas.setAdapter(adapter);
    }
}
