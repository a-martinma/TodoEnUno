package com.example.todoenuno;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class NumeroAleatorio extends Fragment {

    private EditText editTextNumber1;
    private EditText editTextNumber2;
    private TextView textViewNumeroResultado;
    private Button botonGenerar;

    public NumeroAleatorio() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Sonido.pulsarUnaVez(getActivity(), R.raw.sonidopulsar);

        View view = inflater.inflate(R.layout.fragment_numero_aleatorio, container, false);

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null) {
            ActionBar actionBar = activity.getSupportActionBar();
            if (actionBar != null) {
                actionBar.setTitle("Generador de números aleatorios");
            }
        }

        editTextNumber1 = view.findViewById(R.id.editTextNumber1);
        editTextNumber2 = view.findViewById(R.id.editTextNumber2);
        textViewNumeroResultado = view.findViewById(R.id.textViewNumeroResultado);
        botonGenerar = view.findViewById(R.id.botonGenerar);

        botonGenerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generarNumeroAleatorio();
            }
        });

        return view;
    }

    private void generarNumeroAleatorio() {

        String stringNum1 = editTextNumber1.getText().toString();
        String stringNum2 = editTextNumber2.getText().toString();

        //Se verifica que ambos campos esten rellenos
        if (!stringNum1.isEmpty() && !stringNum2.isEmpty()) {
            int numero1 = Integer.parseInt(stringNum1);
            int numero2 = Integer.parseInt(stringNum2);

            // Se verifica que el primer numero sea menor que el segundo
            if (numero1 < numero2) {
                Sonido.pulsarUnaVez(getActivity(), R.raw.sonidopulsar);
                Random random = new Random();
                int numeroAleatorio = random.nextInt((numero2 - numero1) + 1) + numero1;

                // Se muestra el numero aleatorio en el textView
                textViewNumeroResultado.setText(String.valueOf(numeroAleatorio));
            } else {
                Toast.makeText(getActivity(), "El primer número debe ser menor que el segundo", Toast.LENGTH_SHORT).show();
                Sonido.pulsarUnaVez(getActivity(), R.raw.sonidoerror);
            }
        } else{
            Toast.makeText(getActivity(), "Debes rellenar los 2 campos", Toast.LENGTH_SHORT).show();
            Sonido.pulsarUnaVez(getActivity(), R.raw.sonidoerror);
            }
    }

}