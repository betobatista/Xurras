package com.betobatista.xurras.views;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatRadioButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.betobatista.xurras.R;
import com.betobatista.xurras.repository.FriendRepository;

public class FriendDataFragment extends Fragment {

    // Componets //
    private RadioGroup rgSexFriend;
    private AppCompatRadioButton rbSex;
    private AppCompatButton btnCancel;
    private AppCompatButton btnConfirm;
    private AppCompatEditText edtFriendName;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_data_friend, container, false);

        rgSexFriend = view.findViewById(R.id.rgSexFriend);
        edtFriendName = view.findViewById(R.id.edtFriendName);

        // Botão cancelar //
        btnCancel = view.findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        // Botão confirmar //
        btnConfirm = view.findViewById(R.id.btnConfirm);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData(view);
            }
        });
        return view;
    }

    private void saveData(View view) {
        // Pega nome //
        String name = edtFriendName.getText().toString();

        // Pega sexo //
        int selectedId = rgSexFriend.getCheckedRadioButtonId();
        rbSex = view.findViewById(selectedId);
        String sex = rbSex.getText().toString();

        // Comunicando com o banco //
        FriendRepository repository = new FriendRepository(getContext());

        if(repository.insert(name, sex, 0)){
            Toast.makeText(getContext(), "Cadastro realizdo com sucesso", Toast.LENGTH_SHORT).show();
            getActivity().getSupportFragmentManager().popBackStack();
        } else {
            Toast.makeText(getContext(), "Falha ao realizar o cadastro", Toast.LENGTH_SHORT).show();
        }

    }
}
