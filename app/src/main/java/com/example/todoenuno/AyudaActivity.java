package com.example.todoenuno;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class AyudaActivity extends AppCompatActivity {

    private Button btnAyuda1;
    private Button btnAyuda2;
    private Button btnAyuda3;
    private Button btnAyuda4;
    private Button btnAtras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);

        btnAyuda1 = findViewById(R.id.btnAyuda1);
        btnAyuda2 = findViewById(R.id.btnAyuda2);
        btnAyuda3 = findViewById(R.id.btnAyuda3);
        btnAyuda4 = findViewById(R.id.btnAyuda4);
        btnAtras = findViewById(R.id.btnVolver);

        btnAyuda1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sonido.pulsarUnaVez(AyudaActivity.this, R.raw.sonidopulsar);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(AyudaActivity.this);
                Intent intent = new Intent(AyudaActivity.this, ActivityAyuda1.class);
                startActivity(intent, options.toBundle());
            }
        });

        btnAyuda2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sonido.pulsarUnaVez(AyudaActivity.this, R.raw.sonidopulsar);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(AyudaActivity.this);
                Intent intent = new Intent(AyudaActivity.this, ActivityAyuda2.class);
                startActivity(intent, options.toBundle());
            }
        });

        btnAyuda3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sonido.pulsarUnaVez(AyudaActivity.this, R.raw.sonidopulsar);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(AyudaActivity.this);
                Intent intent = new Intent(AyudaActivity.this, ActivityAyuda3.class);
                startActivity(intent, options.toBundle());
            }
        });

        btnAyuda4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sonido.pulsarUnaVez(AyudaActivity.this, R.raw.sonidopulsar);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(AyudaActivity.this);
                Intent intent = new Intent(AyudaActivity.this, ActivityAyuda4.class);
                startActivity(intent, options.toBundle());
            }
        });

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sonido.pulsarUnaVez(AyudaActivity.this, R.raw.sonidopulsar);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(AyudaActivity.this);
                Intent intent = new Intent(AyudaActivity.this, MainActivity.class);
                startActivity(intent, options.toBundle());
            }
        });
    }
}
