package edu.cientifica.divisasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.mbms.StreamingServiceInfo;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class JuegoDadosActivity extends AppCompatActivity {
    private static final int GANA_JUGADA = 1;
    private static final int PIERDE_JUGADA = 2;
    private static final int SIGUE_LANZANDO = 3;

    ImageView ivDado1, ivDado2;
    TextView tvResultado;
    int numjugada = 1;
    int numlanzamiento = 1;
    int valorPunto = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_dados);
        ivDado1 = (ImageView) findViewById(R.id.ivImagendado1);
        ivDado2 = (ImageView) findViewById(R.id.ivImagendado2);
        tvResultado = findViewById(R.id.tvResultado);
    }

    public void lanzarDados(View view) {
        int dado1 = (int) (Math.random() * 6) + 1;
        int dado2 = (int) (Math.random() * 6) + 1;
        int total = dado1 + dado2;
        String mensaje = "";
        mostrarDados(dado1, dado2);

        switch (analizarLanzamiento(total, valorPunto)) {
            case 1:
                mensaje = "Ganaste apuesta\n";
                registrarTexto(String.valueOf(total).toString(), mensaje);
                numjugada++;
                numlanzamiento = 1;
                valorPunto = 0;
                break;
            case 2:
                mensaje = "Perdiste apuesta\n";
                registrarTexto(String.valueOf(total).toString(), mensaje);
                numjugada++;
                numlanzamiento = 1;
                valorPunto = 0;
                break;
            case 3:
                mensaje = "Continua lanzando";
                registrarTexto(String.valueOf(total).toString(), mensaje);
                if (valorPunto == 0) {
                    valorPunto = total;
                }
                numlanzamiento++;
                break;
        }
    }

    private int analizarLanzamiento(int valorDado, int valorPunto) {
        int estado = SIGUE_LANZANDO;
        switch (valorDado) {
            case 7:
                if (valorPunto == 0) {
                    estado = GANA_JUGADA;
                } else {
                    estado = PIERDE_JUGADA;
                }
                break;

            case 11:
                if (valorPunto == 0) {
                    estado = GANA_JUGADA;
                }
                break;
            case 2:
            case 3:
            case 12:
                if (valorPunto == 0) {
                    estado = PIERDE_JUGADA;
                }
                break;
            case 4:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
                if (valorPunto != 0) {
                    if (valorPunto == valorDado) {
                        estado = GANA_JUGADA;
                    }
                }
                break;
        }
        return estado;
    }

    private void registrarTexto(String text, String estado) {
        tvResultado.append("\n Jugada: " + String.valueOf(numjugada)
                + " Lanzamiento: " + String.valueOf(numlanzamiento)
                + " Numero: " + text
                + " " + estado);

    }

    private void mostrarDados(int dado1, int dado2) {
        switch (dado1) {
            case 1:
                ivDado1.setImageResource(R.drawable.dado1);
                break;
            case 2:
                ivDado1.setImageResource(R.drawable.dado2);
                break;
            case 3:
                ivDado1.setImageResource(R.drawable.dado3);
                break;
            case 4:
                ivDado1.setImageResource(R.drawable.dado4);
                break;
            case 5:
                ivDado1.setImageResource(R.drawable.dado5);
                break;
            case 6:
                ivDado1.setImageResource(R.drawable.dado6);
                break;
        }

        switch (dado2) {
            case 1:
                ivDado2.setImageResource(R.drawable.dado1);
                break;
            case 2:
                ivDado2.setImageResource(R.drawable.dado2);
                break;
            case 3:
                ivDado2.setImageResource(R.drawable.dado3);
                break;
            case 4:
                ivDado2.setImageResource(R.drawable.dado4);
                break;
            case 5:
                ivDado2.setImageResource(R.drawable.dado5);
                break;
            case 6:
                ivDado2.setImageResource(R.drawable.dado6);
                break;
        }
    }

}