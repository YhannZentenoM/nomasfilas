package com.example.nomasfilas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nomasfilas.Models.Cita;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.UUID;

public class RegistroCitasActivity extends AppCompatActivity {

    Spinner sp_consul, sp_medico;
    TextView tx_fecha, tx_hora;
    Button bt_registrar;

    Cita citaSeleccionada;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_citas);

        inicializarFirebase();

        sp_consul = (Spinner) findViewById(R.id.spConsultorio);
        sp_medico = (Spinner) findViewById(R.id.spMedico);
        tx_fecha = findViewById(R.id.etFecha);
        tx_hora = findViewById(R.id.etHora);
        bt_registrar = findViewById(R.id.btSaveCita);

        ArrayList<String> comboConsul = new ArrayList<String>();
        comboConsul.add("Consultorios");
        comboConsul.add("Pediatria");
        comboConsul.add("Odontología");
        comboConsul.add("Medicina");
        comboConsul.add("Traumatología");

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,comboConsul);
        sp_consul.setAdapter(adapter);
        sp_consul.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayList<String> comboMedico = new ArrayList<String>();
        comboMedico.add("Medicos");
        comboMedico.add("Dr. Juan Perez");
        comboMedico.add("Dra. Luisa Lane");
        comboMedico.add("Dra. Olga Carreon");
        comboMedico.add("Dr. Luis Angel");
        comboMedico.add("Dr. Peter Parker");

        ArrayAdapter<CharSequence> adapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,comboMedico);
        sp_medico.setAdapter(adapter2);
        sp_medico.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        bt_registrar.setOnClickListener(new View.OnClickListener() {
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
        String consultorio = sp_consul.getSelectedItem().toString();
        String medico = sp_medico.getSelectedItem().toString();
        String fecha = tx_fecha.getText().toString();
        String hora = tx_hora.getText().toString();
        if(consultorio != "Consultorios" && medico != "Medicos" && !fecha.isEmpty() && !hora.isEmpty()){
            Cita c = new Cita();
            c.setIdcita(UUID.randomUUID().toString());
            c.setConsultorio(consultorio);
            c.setMedico(medico);
            c.setFecha(fecha);
            c.setHora(hora);
            databaseReference.child("Citas").child(c.getIdcita()).setValue(c);
            Toast.makeText(RegistroCitasActivity.this, "Cita creada con exito", Toast.LENGTH_SHORT).show();
        }
    }
}