package br.com.alura.checklist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import br.com.alura.checklist.dao.TarefaDAO;
import br.com.alura.checklist.model.Tarefa;

public class ListaDeTarefas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_tarefas);

        TarefaDAO dao = new TarefaDAO(this);
        List<Tarefa> tarefas= dao.buscaTarefas();
        dao.close();

        ListView listaDeTarefas = (ListView) findViewById(R.id.lista_tarefas);
        ArrayAdapter<Tarefa> adapter = new ArrayAdapter<Tarefa> (this,android.R.layout.simple_list_item_1, tarefas);
        listaDeTarefas.setAdapter(adapter);

        Button novaTarefa = (Button) findViewById(R.id.nova_tarefa);
        novaTarefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentVaiProFormulario = new Intent(ListaDeTarefas.this, Formulario.class);
                startActivity(intentVaiProFormulario);
            }
        });
    }
}
