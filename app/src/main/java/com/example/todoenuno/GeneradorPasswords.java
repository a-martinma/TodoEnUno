package com.example.todoenuno;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.security.SecureRandom;

public class GeneradorPasswords extends Fragment {

    private CheckBox checkBoxNums;
    private CheckBox checkBoxMayus;
    private CheckBox checkBoxMinus;
    private CheckBox checkBoxCaracteres;
    private SeekBar seekBarLongitud;
    private TextView textViewLongitud;
    private Button botonGenerarPassword;
    private TextView textViewNumeroResultado;

    @SuppressLint({"StringFormatInvalid", "MissingInflatedId"})
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Sonido.pulsarUnaVez(getActivity(), R.raw.sonidopulsar);
        View view = inflater.inflate(R.layout.fragment_generador_passwords, container, false);

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null) {
            ActionBar actionBar = activity.getSupportActionBar();
            if (actionBar != null) {
                actionBar.setTitle("Generador de contraseñas");
            }
        }

        checkBoxNums = view.findViewById(R.id.checkBoxNums);
        checkBoxMayus = view.findViewById(R.id.checkBoxMayus);
        checkBoxMinus = view.findViewById(R.id.checkBoxMinus);
        checkBoxCaracteres = view.findViewById(R.id.checkBoxCaracteres);
        seekBarLongitud = view.findViewById(R.id.seekBarLongitudContrasenia);
        textViewLongitud = view.findViewById(R.id.textViewLongitudContrasenia);
        botonGenerarPassword = view.findViewById(R.id.botonGenerarPassword);
        textViewNumeroResultado = view.findViewById(R.id.textViewNumeroResultado);

        seekBarLongitud.setMax(18); //Longitud máxima posible de la contraseña
        seekBarLongitud.setProgress(10); // Valor inicial
        textViewLongitud.setText(getString(R.string.longitud_contrasenia, seekBarLongitud.getProgress()));

        //Listener para que vaya cambiando el numero del textView de la seekBar cuando el usuario vaya modificándola.
        seekBarLongitud.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewLongitud.setText(getString(R.string.longitud_contrasenia, progress));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar){}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar){}
        });

        //Listener para cuando se pulsa el botón, que se genere la contraseña
        botonGenerarPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sonido.pulsarUnaVez(getActivity(), R.raw.sonidopulsar);
                generarPassword();
            }
        });

        return view;
    }

    private void generarPassword() {

        String caracteres = "";
        SecureRandom random = new SecureRandom();

        // Construir la cadena de caracteres permitidos basada en las opciones seleccionadas
        if (checkBoxNums.isChecked())
            caracteres += "0123456789";
        if (checkBoxCaracteres.isChecked())
            caracteres += "^*=+_-|;:',./[]{}<>()¿?¡!@#$%€&";
        if (checkBoxMinus.isChecked())
            caracteres += "abcdefghijklmnñopqrstuvwxyz";
        if (checkBoxMayus.isChecked())
            caracteres += "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        if(caracteres.length() == 0){
            Toast.makeText(getActivity(), "Debes seleccionar al menos una casilla en el checkbox", Toast.LENGTH_SHORT).show();
            Sonido.pulsarUnaVez(getActivity(), R.raw.sonidoerror);
            return;
        }

        // Se genera la contraseña eligiendo aleatoriamente entre los valores seleccionados
        int longitud = seekBarLongitud.getProgress();
        String password = "";

        for (int i = 0; i < longitud; i++) {
            int valor = random.nextInt(caracteres.length());
            password += (caracteres.charAt(valor));
        }

        //Se muestra la contraseña resultado
        textViewNumeroResultado.setText(password.toString());
    }
}
