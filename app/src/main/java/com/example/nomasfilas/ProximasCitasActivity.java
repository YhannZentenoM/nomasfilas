package com.example.nomasfilas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.nomasfilas.Adaptadores.ListViewCitas;
import com.example.nomasfilas.Models.Cita;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ProximasCitasActivity extends AppCompatActivity {

    private ArrayList<Cita> listCitas = new ArrayList<Cita>();
    ArrayAdapter<Cita> arrayAdapterCita;
    ListViewCitas listViewCitas;
    ListView listViewCitasV;

    Cita citaSeleccionada;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximas_citas);

        listViewCitasV = findViewById(R.id.lvCitas);

        inicializarFirebase();
        listarCitas();
    }

    private void inicializarFirebase(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    private void listarCitas(){
        databaseReference.child("Citas").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listCitas.clear();
                for (DataSnapshot objSnapshot : dataSnapshot.getChildren()){
                    Cita c = objSnapshot.getValue(Cita.class);
                    listCitas.add(c);
                }
                listViewCitas = new ListViewCitas(ProximasCitasActivity.this,listCitas);
                /*arrayAdapterCita = new ArrayAdapter<Cita>(
                        ProximasCitasActivity.this, android.R.layout.simple_expandable_list_item_1,listCitas
                );*/
                listViewCitasV.setAdapter(listViewCitas);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}