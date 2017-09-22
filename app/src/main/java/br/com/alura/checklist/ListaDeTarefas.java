    package br.com.alura.checklist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.com.alura.checklist.dao.TarefaDAO;
import br.com.alura.checklist.model.Tarefa;

public class ListaDeTarefas extends AppCompatActivity {

    private ListView listaDeTarefas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_tarefas);

         listaDeTarefas = (ListView) findViewById(R.id.lista_tarefas);

        Button novaTarefa = (Button) findViewById(R.id.nova_tarefa);
        novaTarefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentVaiProFormulario = new Intent(ListaDeTarefas.this, Formulario.class);
                startActivity(intentVaiProFormulario);
             }
        });

        registerForContextMenu(listaDeTarefas);
    }

    private void carregaLista() {
        TarefaDAO dao = new TarefaDAO(this);
        List<Tarefa> tarefas= dao.buscaTarefas();
        dao.close();


        ArrayAdapter<Tarefa> adapter = new ArrayAdapter<Tarefa> (this,android.R.layout.simple_list_item_1, tarefas);
        listaDeTarefas.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaLista();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem deletar =  menu.add("Deletar");
        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                AdapterView.AdapterContextMenuInfo info =(AdapterView.AdapterContextMenuInfo) menuInfo;
                Tarefa tarefa = (Tarefa) listaDeTarefas.getItemAtPosition(info.position);

                TarefaDAO dao = new TarefaDAO(ListaDeTarefas.this);
                dao.deleta(tarefa);
                dao.close();

                Toast.makeText(ListaDeTarefas.this, "Deletar a tarefa" + tarefa.getTarefa(), Toast.LENGTH_SHORT).show();
                carregaLista();
                return false;
            }
        });
    }
}
