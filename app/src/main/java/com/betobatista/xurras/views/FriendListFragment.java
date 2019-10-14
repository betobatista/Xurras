package com.betobatista.xurras.views;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.betobatista.xurras.R;
import com.betobatista.xurras.adapter.FriendAdapter;
import com.betobatista.xurras.entities.FriendEntities;
import com.betobatista.xurras.repository.FriendRepository;

import java.util.ArrayList;
import java.util.List;

public class FriendListFragment extends Fragment {

    // Lista //
    private RecyclerView recyclerView;
    private FriendAdapter adapter;
    private List<FriendEntities> list = new ArrayList<>();

    private FriendRepository repository;

    private FloatingActionButton fabAdd;

    private Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list_friend, container, false);

        repository = new FriendRepository(context);
        recyclerView = view.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        loadList();

        fabAdd = view.findViewById(R.id.fabAdd);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();

                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.fragment_content, new FriendDataFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        this.context = context;
        super.onAttach(context);
    }

    private void loadList() {
        list.clear();
        list = repository.loadList();
        if(list != null){
            if (list.size() > 0){
                adapter = new FriendAdapter(list);
                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);
            }
        }
    }

    @Override
    public void onResume() {
        loadList();
        super.onResume();
    }
}
