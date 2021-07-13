package com.example.nomasfilas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nomasfilas.Models.Cita;
import com.example.nomasfilas.Models.Comentarios;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class ComentariosActivity extends AppCompatActivity {

    TextView tx_com;
    Button bt_regcom;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentarios);

        tx_com = findViewById(R.id.etComentario);
        bt_regcom = findViewById(R.id.btSaveCom);

        inicializarFirebase();

        bt_regcom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertar();
            }
        });
    }

    private void inicializarFirebase(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    public void insertar(){
        String com = tx_com.getText().toString();
        if(!com.isEmpty()){
            Comentarios c = new Comentarios();
            c.setIdcom(UUID.randomUUID().toString());
            c.setComentario(com);

            databaseReference.child("Comentarios").child(c.getIdcom()).setValue(c);
            Toast.makeText(ComentariosActivity.this, "Comentario creada con exito", Toast.LENGTH_SHORT).show();
        }
    }
}