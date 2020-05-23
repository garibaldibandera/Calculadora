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
    private Spinner combo_operaciones;
    private String[] operaciones;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numero_uno = findViewById(R.id.txtNumeroUno);
        numero_dos = findViewById(R.id.txtNumeroDos);
        resultado = findViewById(R.id.lblResultado);
        combo_operaciones = findViewById(R.id.cmbOperaciones);
        operaciones=getResources().getStringArray(R.array.operaciones);
        adapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,operaciones);
        combo_operaciones.setAdapter(adapter);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, operaciones);
     }

    public void Calcular(View v) {
        int opcion;
        double num_uno, num_dos, resultados = 0;
        if (validar()) {
            num_uno = Double.parseDouble(numero_uno.getText().toString());
            num_dos = Double.parseDouble(numero_dos.getText().toString());
            opcion = combo_operaciones.getSelectedItemPosition();
            if (opcion == 0) {
                resultados = num_uno + num_dos;
            } else if (opcion == 1) {
                resultados = num_uno - num_dos;
            } else if (opcion == 2) {
                resultados = num_uno * num_dos;
            } else if (opcion == 3) {

                resultados = num_uno / num_dos;
            }
            resultado.setText("" + resultados);
        }
    }
            //switch()

    public void aux_limpiar(View v) {
        numero_uno.setText("");
        numero_dos.setText("");
        resultado.setText("");
        numero_uno.requestFocus();
        combo_operaciones.setSelection(0);
    }

    public boolean validar() {
        String error_numero_uno, error_numero_dos, error_division;
        int opcion;

        error_numero_uno = getResources().getString(R.string.error_numero_uno);
        error_numero_dos = getResources().getString(R.string.error_numero_dos);
        error_division=getResources().getString(R.string.error_division);

        opcion=combo_operaciones.getSelectedItemPosition();

        if (numero_uno.getText().toString().isEmpty()) {
            numero_uno.setError(error_numero_uno);
            numero_uno.requestFocus();
            return false;
        } else if (numero_dos.getText().toString().isEmpty()) {
            numero_dos.setError(error_numero_uno);
            numero_dos.requestFocus();
            return false;
        }else if (opcion == 3 && Double.parseDouble(numero_dos.getText().toString())==0){
            numero_dos.setError(error_division);
            numero_dos.requestFocus();
            return false;
        }
        return true;
    }

}
