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
    private TextView resultado, mensajes;
    private Spinner Operacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numero_uno = findViewById(R.id.txtNumeroUno);
        numero_dos = findViewById(R.id.txtNumeroDos);
        resultado = findViewById(R.id.lblResultado);
        mensajes = findViewById(R.id.txtMensajes);
        Operacion = findViewById(R.id.spOperacion);
        String[] opciones = {"Sumar", "Restar", "Multiplicar", "Dividir"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        Operacion.setAdapter(adaptador);
    }

    public void Calcular(View v) {
        int num_uno, num_dos, resultados = 0;
        //String Operador1 = numero_uno.getText().toString();
        //String Operador2 = numero_dos.getText().toString();
        String opcion = Operacion.getSelectedItem().toString();

    /*if ((Operador1.length() == 0) || (Operador2.length() == 0)) {
        Toast.makeText(this, "DEBE INGRESAR UN VALOR EN AMBAS CELDAS", Toast.LENGTH_LONG).show();
        //mensajes.setText("DEBE INGRESAR UN VALOR EN AMBAS CELDAS");
    }
    else {*/
        if (validar()) {
            num_uno = Integer.parseInt(numero_uno.getText().toString());
            num_dos = Integer.parseInt(numero_dos.getText().toString());
           // resultados = num_uno + num_dos;

            if (opcion.equals("Sumar")) {
                resultados = num_uno + num_dos;
               // resultado.setText("" + resultados);
            } else if (opcion.equals("Restar")) {
                resultados = num_uno - num_dos;
               // resultado.setText("" + resultados);
            } else if (opcion.equals("Multiplicar")) {
                resultados = num_uno * num_dos;
                //resultado.setText("" + resultados);
            } else if (num_dos != 0) {
                resultados = num_uno / num_dos;
                //resultado.setText("" + resultados);
            } else {
                Toast.makeText(this, "EL DIVISOR DEBE SER DIFERENTE A CERO 0.", Toast.LENGTH_LONG).show();
                //mensajes.setText("EL DIVISOR DEBE SER DIFERENTE A CERO 0");
            }
            resultado.setText("" + resultados);
        }
    }

    /*      if (opcion.equals("Sumar")) {
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
          } else {
              Toast.makeText(this, "EL DIVISOR DEBE SER DIFERENTE A CERO 0.", Toast.LENGTH_LONG).show();
              //mensajes.setText("EL DIVISOR DEBE SER DIFERENTE A CERO 0");
          }
       //resultado.setText("" + resultados);
      }

      }*/
    public void aux_limpiar(View v) {
        numero_uno.setText("");
        numero_dos.setText("");
        resultado.setText("");
        mensajes.setText("");
        numero_uno.requestFocus();
    }

    public boolean validar() {
        String error_numero_uno, error_numero_dos;
        error_numero_uno = getResources().getString(R.string.error_numero_uno);
        error_numero_dos = getResources().getString(R.string.error_numero_dos);
        if (numero_uno.getText().toString().isEmpty()) {
            numero_uno.setError(error_numero_uno);
            numero_uno.requestFocus();
            return false;
        } else if (numero_dos.getText().toString().isEmpty()) {
            numero_dos.setError(error_numero_uno);
            numero_dos.requestFocus();
            return false;
        }
        return false;
    }

}
