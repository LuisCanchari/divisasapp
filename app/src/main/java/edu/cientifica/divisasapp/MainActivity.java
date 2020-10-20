package edu.cientifica.divisasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void procesoConRadioButton(View view) {
        intent = new Intent(this,divisasRadioButton.class);
        startActivity(intent);
    }

    public void procesoConSpinner(View view) {
        intent = new Intent(this,divisasSpinner.class);
        startActivity(intent);
    }

    public void ProcesoConListView(View view) {
        intent = new Intent(this,divisasListView.class);
        startActivity(intent);
    }

    public void opcion1(View view) {
        intent = new Intent(this,aleatorioActivity.class);
        startActivity(intent);
    }

    public void jugarDados(View view) {
        intent = new Intent(this,JuegoDadosActivity.class);
        startActivity(intent);
    }
}