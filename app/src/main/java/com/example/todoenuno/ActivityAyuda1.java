package com.example.todoenuno;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityAyuda1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda1);
    }

    public void atras (View v) {
        Sonido.pulsarUnaVez(this, R.raw.sonidopulsar);
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent intent = new Intent(this, AyudaActivity.class);
        startActivity(intent, options.toBundle());
    }
}