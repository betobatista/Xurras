package com.betobatista.xurras.viewholder;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.betobatista.xurras.R;
import com.betobatista.xurras.adapter.FriendAdapter;
import com.betobatista.xurras.entities.FriendEntities;
import com.betobatista.xurras.repository.FriendRepository;

public class FriendViewHolder extends RecyclerView.ViewHolder {

    private AppCompatTextView txtNmAmigo;
    private AppCompatTextView txtSxAmigo;
    private AppCompatTextView txtVlAmigo;
    public LinearLayout cdFriendItem;

    public FriendViewHolder(@NonNull View itemView) {
        super(itemView);

        txtNmAmigo = itemView.findViewById(R.id.txtNmAmigo);
        txtSxAmigo = itemView.findViewById(R.id.txtSexAmigo);
        txtVlAmigo = itemView.findViewById(R.id.txtCashAmigo);
        cdFriendItem = itemView.findViewById(R.id.llFriendItem);

    }

    public void bindData(final FriendEntities entity){

       txtNmAmigo.setText(entity.getNmAmigo());
       txtSxAmigo.setText(entity.getSxAmigo());
       txtVlAmigo.setText(String.valueOf(entity.getVlAmigo()));
    }


}
