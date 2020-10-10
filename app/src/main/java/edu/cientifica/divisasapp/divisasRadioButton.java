package edu.cientifica.divisasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class divisasRadioButton extends AppCompatActivity {
    RadioButton rbSolADolar, rbDolarASol;
    EditText etMontoInicial;
    TextView tvMontoFInal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_divisas_radio_button);

        rbSolADolar = findViewById(R.id.rbSolADolar);
        rbDolarASol = findViewById(R.id.rbDolarASol);
        etMontoInicial = findViewById(R.id.etMontoInicial);
        tvMontoFInal=findViewById(R.id.tvMontoFinal);

    }

    public void procesar(View view) {

        Double montoInicial = Double.parseDouble(etMontoInicial.getText().toString());
        Double factor = leerfactor();


        DecimalFormat dformat = new DecimalFormat("#.00");

        if(rbSolADolar.isChecked()){
            if(!rbDolarASol.isChecked())
                factor = 1/factor;
        }else
            if(rbDolarASol.isChecked())
                factor = factor;

        Double montoFinal = convertirDivisa(montoInicial, factor);
        tvMontoFInal.setText(dformat.format(montoFinal));

    }

    private Double leerfactor() {
        /*logica de lectura*/
        return 3.6;
    }

    private Double convertirDivisa(double monto, double factor) {
        return monto*factor;
    }
}