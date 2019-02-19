package com.betobatista.xurras.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.betobatista.xurras.R;
import com.betobatista.xurras.adapter.AmigoAdapter;
import com.betobatista.xurras.entities.AmigoEntities;
import com.betobatista.xurras.repository.AmigoRepository;

import java.util.ArrayList;
import java.util.List;

public class AmigoActivity extends AppCompatActivity {

    // Lista //
    private RecyclerView recyclerView;
    private AmigoAdapter adapter;
    private List<AmigoEntities> list = new ArrayList<>();

    private AmigoRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amigo);
        repository = new AmigoRepository(getApplicationContext());
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadList();
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
}
