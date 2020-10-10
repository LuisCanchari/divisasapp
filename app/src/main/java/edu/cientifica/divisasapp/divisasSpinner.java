package edu.cientifica.divisasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class divisasSpinner extends AppCompatActivity {
    String listaMonedas[] = {"Sol","Dolar","Euro","Libra","Peso"};
    Double factorMonedas[] = {3.6, 1.0,0.8,0.7,20.0};

    Spinner spinnerOrigen, spinnerDestino;
    EditText etMontoInicial;
    TextView tvMontoFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_divisas_spinner);

        etMontoInicial = findViewById(R.id.etMontoInicial);
        tvMontoFinal = findViewById(R.id.tvMontoFinal);


        spinnerOrigen = findViewById(R.id.spinnerOrigen);
        spinnerDestino = findViewById(R.id.spinnerDestino);

//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                R.array.listaMonedas, android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> adapter = new
                ArrayAdapter(this,android.R.layout.simple_spinner_item,listaMonedas);

        spinnerOrigen.setAdapter(adapter);
        spinnerDestino.setAdapter(adapter);


       /* spinnerOrigen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(adapterView.getContext(), "Moneda Origen: " + listaMonedas[i].toString(), Toast.LENGTH_LONG).show();
            }
        });*/


        spinnerOrigen.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(adapterView.getContext(), "Moneda origen: "+listaMonedas[i], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerDestino.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(adapterView.getContext(), "Moneda destino: "+listaMonedas[i], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
    public void procesoSpinner(View view){
        DecimalFormat dformat =  new DecimalFormat("#.00");

        double montoInicial = Double.parseDouble(etMontoInicial.getText().toString());

        //double factorMonedaOrigen = factorMonedas[];
        double factorMonedaOrigen = factorMonedas[spinnerOrigen.getSelectedItemPosition()];
        double factorMonedaDestino = factorMonedas[spinnerDestino.getSelectedItemPosition()];

        double montoFinal = montoInicial*(factorMonedaDestino/factorMonedaOrigen);

        tvMontoFinal.setText(dformat.format(montoFinal));

        //Toast.makeText(this,spinnerOrigen.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
    }
}