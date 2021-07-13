package com.example.nomasfilas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button bt_prox,bt_reg,bt_tuto,bt_com,bt_map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bt_prox = findViewById(R.id.button);
        bt_reg = findViewById(R.id.button2);
        bt_tuto = findViewById(R.id.button3);
        bt_com = findViewById(R.id.button4);
        bt_map = findViewById(R.id.button5);

        bt_prox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,ProximasCitasActivity.class);
                startActivity(intent);
            }
        });

        bt_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,RegistroCitasActivity.class);
                startActivity(intent);
            }
        });

        bt_tuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,TutorialActivity.class);
                startActivity(intent);
            }
        });

        bt_com.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,ComentariosActivity.class);
                startActivity(intent);
            }
        });

        bt_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,MapsActivity.class);
                startActivity(intent);
            }
        });
    }
}