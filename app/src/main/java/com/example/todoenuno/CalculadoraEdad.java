package com.example.todoenuno;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.Calendar;

public class CalculadoraEdad extends Fragment {

    private Button botonSeleccionEdad;
    private TextView textViewResultado;
    private Calendar fechaSeleccionada;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Sonido.pulsarUnaVez(getActivity(), R.raw.sonidopulsar);
        View view = inflater.inflate(R.layout.fragment_calculadora_edad, container, false);

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null) {
            ActionBar actionBar = activity.getSupportActionBar();
            if (actionBar != null) {
                actionBar.setTitle("Calculadora de edad");
            }
        }

        botonSeleccionEdad = view.findViewById(R.id.botonSeleccionarFecha);
        textViewResultado = view.findViewById(R.id.textViewEdadResultado);

        botonSeleccionEdad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarSeleccionadorEdad();
                Sonido.pulsarUnaVez(getActivity(), R.raw.sonidopulsar);
            }
        });

        return view;
    }

    private void mostrarSeleccionadorEdad() {
        final Calendar currentDate = Calendar.getInstance();

        //Se obtiene la fecha actual para que se muestre inicialmente al abrir el datePickerDialog
        int anio = currentDate.get(Calendar.YEAR);
        int mes = currentDate.get(Calendar.MONTH);
        int dia = currentDate.get(Calendar.DAY_OF_MONTH);

        //Se crea el datePickerDialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                requireContext(),
                new DatePickerDialog.OnDateSetListener() {
                    //Cuando el usuario elige la fecha, se recoge y se llama al método calcularEdad
                    @Override
                    public void onDateSet(DatePicker view, int anio, int mes, int dia) {
                        fechaSeleccionada = Calendar.getInstance();
                        fechaSeleccionada.set(anio, mes, dia);
                        calcularEdad();
                    }
                },
                anio, mes, dia //Valores iniciales
        );

        datePickerDialog.show(); //Se muestra el calendario
    }

    private void calcularEdad() {
        if (fechaSeleccionada != null) {
            Sonido.pulsarUnaVez(getActivity(), R.raw.sonidopulsar);
            Calendar hoy = Calendar.getInstance();

            //Se calcula la diferencia de años normal
            int edad = hoy.get(Calendar.YEAR) - fechaSeleccionada.get(Calendar.YEAR);

            //Hay que ver si se han cumplido los años este año o no
            if (hoy.get(Calendar.DAY_OF_YEAR) < fechaSeleccionada.get(Calendar.DAY_OF_YEAR)) {
                edad--;
            }
            if(edad >= 0)
                textViewResultado.setText("Tienes: " + edad + " años");
            else
                textViewResultado.setText("Todavía no has nacido");

        }else{
            Toast.makeText(getActivity(), "Debes introducir una fecha para calcular la edad", Toast.LENGTH_SHORT).show();
            Sonido.pulsarUnaVez(getActivity(), R.raw.sonidoerror);
        }
    }
}
