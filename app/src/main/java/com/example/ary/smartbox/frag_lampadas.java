package com.example.ary.smartbox;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class frag_lampadas extends Fragment{
    Button on1;
    Button on2;
    Button off1;
    Button off2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.lampadas, container, false);
        on1= (Button) v.findViewById(R.id.on1);
        on2= (Button) v.findViewById(R.id.on2);
        off1= (Button) v.findViewById(R.id.off1);
        off2= (Button) v.findViewById(R.id.off2);
        on1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("lamp_sala");

                myRef.setValue(true);
            }
        });
        off1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("lamp_sala");

                myRef.setValue(false);
            }
        });
        on2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("lamp_cozinha");

                myRef.setValue(true);
            }
        });
        off2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("lamp_cozinha");

                myRef.setValue(false);
            }
        });

        return  v;


    }
}
