package edu.cientifica.divisasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import static java.lang.Math.*;

public class aleatorioActivity extends AppCompatActivity {

    ImageView ivImagen;
    Button btngenerar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aleatorio);

        btngenerar = findViewById(R.id.btnGenerarAleatorio);
        ivImagen = findViewById(R.id.ivImagen);

        btngenerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int numero = (int) (Math.random() * 6) + 1;

                Toast.makeText(view.getContext(),"numero: "+String.valueOf(numero),Toast.LENGTH_LONG).show();

                switch (numero){
                    case 1:
                        ivImagen.setImageResource(R.drawable.dado1);
                        break;
                    case 2:
                        ivImagen.setImageResource(R.drawable.dado2);
                        break;
                    case 3:
                        ivImagen.setImageResource(R.drawable.dado3);
                        break;
                    case 4:
                        ivImagen.setImageResource(R.drawable.dado4);
                        break;
                    case 5:
                        ivImagen.setImageResource(R.drawable.dado5);
                        break;
                    case 6:
                        ivImagen.setImageResource(R.drawable.dado6);
                        break;
                }

            }
        });
    }
}