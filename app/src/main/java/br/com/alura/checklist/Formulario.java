package br.com.alura.checklist;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.alura.checklist.dao.TarefaDAO;
import br.com.alura.checklist.model.Tarefa;

public class Formulario extends AppCompatActivity {

    private FormularioHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        helper = new FormularioHelper(this);
         Intent intent = getIntent();
        Tarefa tarefa = (Tarefa) intent.getSerializableExtra("tarefa");
        if (tarefa != null){
            helper.preencheFormulario(tarefa);
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_menu_formulario, menu);


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_formulario_ok:

            Tarefa tarefa = helper.pegaTarefa();
                TarefaDAO dao = new TarefaDAO(this);
                dao.insere(tarefa);
                dao.close();


                Toast.makeText(Formulario.this, "Tarefa "+ tarefa.getNome() + "salva!", Toast.LENGTH_SHORT).show();

            finish();
             break;
        }

        return super.onOptionsItemSelected(item);
    }
}
