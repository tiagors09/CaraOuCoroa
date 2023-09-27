package br.com.tiagors09.caraoucoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class EscolhendoResultado extends AppCompatActivity {
    private GifImageView gifImageView;
    private Button buttonVoltar;
    private int[] ladosMoeda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolhendo_resultado);

        gifImageView = findViewById(R.id.coinFlipping);
        ladosMoeda = new int[]{R.drawable.cara, R.drawable.coroa};

        buttonVoltar = findViewById(R.id.buttonVoltar);
        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        int ladoEscolhido = ladosMoeda[new Random().nextInt()%2];

        super.onResume();

        gifImageView.postDelayed(new Runnable() {
            @Override
            public void run() {
                gifImageView.setImageResource(ladoEscolhido);
                buttonVoltar.setVisibility(View.VISIBLE);
            }
        }, 1850);
    }
}