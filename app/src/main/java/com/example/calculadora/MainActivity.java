package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText numero_uno, numero_dos;
    private TextView resultado;
    private Spinner Operacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numero_uno = findViewById(R.id.txtNumeroUno);
        numero_dos=findViewById(R.id.txtNumeroDos);
        resultado = findViewById(R.id.lblResultado);
        Operacion = findViewById(R.id.spOperacion);
        String [] opciones = {"Sumar","Restar","Multiplicar","Dividir"};
        ArrayAdapter<String> adaptor = new ArrayAdapter<String>( this, android.R.layout.simple_spinner_item, opciones);
        Operacion.setAdapter(adaptor);
    }

    public void Calcular (View v) {
    int num_uno, num_dos, resultados;
    String Operador1 = numero_uno.getText().toString();
    String Operador2 = numero_dos.getText().toString();
    String opcion = Operacion.getSelectedItem().toString();

    if ((Operador1.length() == 0) || (Operador2.length() == 0)) {
        resultado.setText("Debe ingresar un valor en ambas celdas");
    }
    else {
        num_uno = Integer.parseInt(numero_uno.getText().toString());
        num_dos = Integer.parseInt(numero_dos.getText().toString());


        if (opcion.equals("Sumar")) {
            resultados = num_uno + num_dos;
            resultado.setText("" + resultados);
        } else if (opcion.equals("Restar")) {
            resultados = num_uno - num_dos;
            resultado.setText("" + resultados);
        } else if (opcion.equals("Multiplicar")) {
            resultados = num_uno * num_dos;
            resultado.setText("" + resultados);
        } else if (num_dos != 0) {
            resultados = num_uno / num_dos;
            resultado.setText("" + resultados);
        } else
            Toast.makeText(this, "El divisor debe ser diferente a cero 0.", Toast.LENGTH_LONG).show();
    }
    }
    public void aux_limpiar(View v){
        numero_uno.setText("");
        numero_dos.setText("");
        resultado.setText("");
        numero_uno.requestFocus();
    }
}
