package edu.cientifica.divisasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Math.*;

public class aleatorioActivity extends AppCompatActivity {

    ImageView ivImagen1, ivImagen2;
    Button btngenerar;
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aleatorio);

        btngenerar = findViewById(R.id.btnGenerarAleatorio);
        ivImagen1 = findViewById(R.id.ivImagendado1);
        ivImagen2 = findViewById(R.id.ivImagendado2);


        btngenerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int dado1 = (int)(Math.random()*6)+1;
                int dado2 = (int)(Math.random()*6)+1;
                int total = dado1+dado2;

                switch (dado1){
                    case 1:
                        ivImagen1.setImageResource(R.drawable.dado1);

                        break;
                    case 2:
                        ivImagen1.setImageResource(R.drawable.dado2);
                        break;
                    case 3:
                        ivImagen1.setImageResource(R.drawable.dado3);
                        break;
                    case 4:
                        ivImagen1.setImageResource(R.drawable.dado4);
                        break;
                    case 5:
                        ivImagen1.setImageResource(R.drawable.dado5);
                        break;
                    case 6:
                        ivImagen1.setImageResource(R.drawable.dado6);
                        break;
                }

                switch (dado2){
                    case 1:
                        ivImagen2.setImageResource(R.drawable.dado1);
                        break;
                    case 2:
                        ivImagen2.setImageResource(R.drawable.dado2);
                        break;
                    case 3:
                        ivImagen2.setImageResource(R.drawable.dado3);
                        break;
                    case 4:
                        ivImagen2.setImageResource(R.drawable.dado4);
                        break;
                    case 5:
                        ivImagen2.setImageResource(R.drawable.dado5);
                        break;
                    case 6:
                        ivImagen2.setImageResource(R.drawable.dado6);
                        break;
                }


            }

        });
    }
}