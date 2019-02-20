package com.betobatista.xurras.views;

import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.betobatista.xurras.R;
import com.betobatista.xurras.adapter.AmigoAdapter;
import com.betobatista.xurras.entities.AmigoEntities;
import com.betobatista.xurras.listener.DialogButtonClick;
import com.betobatista.xurras.repository.AmigoRepository;
import com.betobatista.xurras.utilitys.Util;

import java.util.ArrayList;
import java.util.List;

public class AmigoActivity extends AppCompatActivity {

    // Lista //
    private RecyclerView recyclerView;
    private AmigoAdapter adapter;
    private List<AmigoEntities> list = new ArrayList<>();

    private AmigoRepository repository;

    private AlertDialog dialog;

    private FloatingActionButton fabAdd;
    private EditText edtNome;
    private RadioGroup rgSexo;
    private AppCompatButton btnCancel;
    private AppCompatButton btnOk;

    private String nmAmigo;
    private String sxAmigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amigo);
        repository = new AmigoRepository(getApplicationContext());
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadList();
        builderDialog();

        fabAdd = findViewById(R.id.fabAdd);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();

                btnOk.setOnClickListener(new DialogButtonClick(dialog) {
                    @Override
                    protected boolean onClicked() {
                        if(validateForm()){
                            edtNome.setText("");
                            loadList();
                            return true;
                        } else {
                            Util.exibirToast("Falha ao incluir novo amigo");
                            return false;
                        }
                    }
                });
            }
        });
    }

    private boolean validateForm() {

        nmAmigo = null;
        nmAmigo = edtNome.getText().toString();
        if(edtNome.equals("")){
            nmAmigo = null;
            return false;
        } else {
            rgSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    switch (i) {
                        case R.id.rbMasc:
                            sxAmigo = "M";
                            break;
                        case R.id.rbFemi:
                            sxAmigo = "F";
                            break;
                    }
                }
            });

            //boolean aux = true;
            for(int i = 0; i < list.size(); i++){
                if(nmAmigo.equalsIgnoreCase(list.get(i).getNmAmigo())){
                    nmAmigo = null;
                    Util.exibirToast("O corpo informado já foi cadastrado");
                    return false;
                    //aux = false;
                }
            }
            if(repository.insert(nmAmigo, sxAmigo, 0)){
                //txtLayoutCorpo.setErrorEnabled(false);
                return true;
            } else {
                return false;
            }
        }
    }

    private void loadList() {
        list.clear();
        list = repository.loadList();
        if(list != null){
            if (list.size() > 0){
                adapter = new AmigoAdapter(list);
                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);
            }
        }
    }

    private void builderDialog() {

        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.dialog_add_update_amigo, null);

        //edtCorpo = (EditText) view.findViewById(R.id.edtCorpo);
        //txtLayoutCorpo = (TextInputLayout) view.findViewById(R.id.txtLayout_corpo);

        edtNome = view.findViewById(R.id.edtNome);
        rgSexo = view.findViewById(R.id.rgSxAmigo);
        btnCancel = view.findViewById(R.id.btnCancel);
        btnOk = view.findViewById(R.id.btnOk);

        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.CustomDialog);
        builder.setView(view);
        dialog = builder.create();
    }
}
