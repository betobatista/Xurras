package com.betobatista.xurras.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.betobatista.xurras.R;
import com.betobatista.xurras.entities.AmigoEntities;
import com.betobatista.xurras.viewholder.AmigoViewHolder;

import java.util.List;

public class AmigoAdapter extends RecyclerView.Adapter<AmigoViewHolder> {

    private List<AmigoEntities> list;

    public AmigoAdapter(List<AmigoEntities> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public AmigoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.list_item_amigos, viewGroup, false);

        return new AmigoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AmigoViewHolder holder, int i) {
        final AmigoEntities entity = list.get(i);

        holder.bindData(entity);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
