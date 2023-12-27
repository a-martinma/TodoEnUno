package com.example.todoenuno;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.text.DecimalFormat;

public class CalculadoraDescuentos extends Fragment {

    private EditText editTextIntroducirPrecio;
    private EditText editTextIntroducirDescuento;
    private TextView textViewPrecioTotal;
    private Button botonGenerar;

    public CalculadoraDescuentos() {
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Sonido.pulsarUnaVez(getActivity(), R.raw.sonidopulsar);

        View view = inflater.inflate(R.layout.fragment_calculadora_descuentos, container, false);

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null) {
            ActionBar actionBar = activity.getSupportActionBar();
            if (actionBar != null) {
                actionBar.setTitle("Calculadora de descuentos");
            }
        }

        editTextIntroducirPrecio = view.findViewById(R.id.editTextIntroducirPrecio);
        editTextIntroducirDescuento = view.findViewById(R.id.editTextIntroducirDescuento);
        textViewPrecioTotal = view.findViewById(R.id.textViewPrecioTotal);
        botonGenerar = view.findViewById(R.id.botonGenerar);

        botonGenerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sonido.pulsarUnaVez(getActivity(), R.raw.sonidopulsar);
                calcularPrecio();
            }
        });

        return view;
    }

    private void calcularPrecio() {

        String stringNum1 = editTextIntroducirPrecio.getText().toString();
        String stringNum2 = editTextIntroducirDescuento.getText().toString();

        //Se verifica que ambos campos esten rellenos
        if (!stringNum1.isEmpty() && !stringNum2.isEmpty()) {
            double numero1 = Double.parseDouble(stringNum1);
            double numero2 = Double.parseDouble(stringNum2);

            // Se verifica que el segundo numero es un numero entre 0 y 100
            if ((numero2 > 0) && (numero2 < 100)) {
                //Se calcula el precio final
                double precioFinal = numero1 * (1 - (numero2/100));

                //Se formatea el precio final a 2 decimales por si acaso el resultado genera muchos decimales
                DecimalFormat formatoDecimal = new DecimalFormat("#.##");
                String resultadoFormateado = formatoDecimal.format(precioFinal);

                textViewPrecioTotal.setText(resultadoFormateado+ " €");
            } else {
                Toast.makeText(getActivity(), "El descuento debe ser un numero entre 0 y 100", Toast.LENGTH_SHORT).show();
                Sonido.pulsarUnaVez(getActivity(), R.raw.sonidoerror);
            }
        } else{
            Toast.makeText(getActivity(), "Debes rellenar los 2 campos", Toast.LENGTH_SHORT).show();
            Sonido.pulsarUnaVez(getActivity(), R.raw.sonidoerror);
        }
    }
}