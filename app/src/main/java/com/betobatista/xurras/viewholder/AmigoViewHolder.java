package com.betobatista.xurras.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.betobatista.xurras.R;
import com.betobatista.xurras.entities.AmigoEntities;

public class AmigoViewHolder extends RecyclerView.ViewHolder {

    private AppCompatTextView txtNmAmigo;
    private AppCompatTextView txtSxAmigo;
    private AppCompatTextView txtVlAmigo;

    public AmigoViewHolder(@NonNull View itemView) {
        super(itemView);

        txtNmAmigo = itemView.findViewById(R.id.txtNmAmigo);
        txtSxAmigo = itemView.findViewById(R.id.txtSexAmigo);
        txtVlAmigo = itemView.findViewById(R.id.txtCashAmigo);
    }

    public void bindData(final AmigoEntities entity){

       txtNmAmigo.setText(entity.getNmAmigo());
       txtSxAmigo.setText(entity.getSxAmigo());
       txtVlAmigo.setText(String.valueOf(entity.getVlAmigo()));

    }
}
