package br.com.alura.checklist;

import android.widget.EditText;
import android.widget.RatingBar;


import br.com.alura.checklist.model.Tarefa;

/**
 * Created by cleyton on 20/09/17.
 */

public class FormularioHelper {

    private final EditText campoNome;
    private final EditText campoTarefa;
    private final EditText campoData;


    public FormularioHelper(Formulario actvity){
        campoNome = (EditText) actvity.findViewById(R.id.formulario_nome);
        campoTarefa = (EditText) actvity.findViewById(R.id.formulario_tarefa);
        campoData = (EditText) actvity.findViewById(R.id.formulario_data);

    }

    public Tarefa pegaTarefa() {
        Tarefa tarefa = new Tarefa();
        tarefa.setNome(campoNome.getText().toString());
        tarefa.setTarefa(campoTarefa.getText().toString());
        tarefa.setData(campoData.getText().toString());


        return tarefa;
    }
}
