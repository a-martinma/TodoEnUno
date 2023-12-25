package com.example.todoenuno;

import android.os.Bundle;

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


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    private EditText editTextNumber1;
    private EditText editTextNumber2;
    private TextView textViewNumeroResultado;
    private Button botonGenerar;

    public NumeroAleatorio() {
    }


    public static NumeroAleatorio newInstance(String param1, String param2) {
        NumeroAleatorio fragment = new NumeroAleatorio();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Sonido.pulsarUnaVez(getActivity(), R.raw.sonidopulsar);
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_numero_aleatorio, container, false);

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

            // Se verifica que el primer numero es menor que el segundo
            if (numero1 < numero2) {
                int numeroAleatorio = generarNumeroAleatorio(numero1, numero2);

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

    private int generarNumeroAleatorio(int min, int max) {
        Random random = new Random();
        Sonido.pulsarUnaVez(getActivity(), R.raw.sonidopulsar);
        return random.nextInt((max - min) + 1) + min;
    }
}