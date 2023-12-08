package com.example.gamesuitjawa;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView txscore;
    private ImageView player, com;
    private Button btnbatu, btngunting, btnkertas;
    private int scorePlayer = 0, scoreKomputer = 0;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txscore = findViewById(R.id.txscore);
        com = findViewById(R.id.com);
        player = findViewById(R.id.player);
        btnbatu = findViewById(R.id.btnbatu);
        btngunting = findViewById(R.id.btngunting);
        btnkertas = findViewById(R.id.btnkertas);

        btnbatu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.setImageResource(R.drawable.batu_bawah);
                String message = gamestart("batu");
                Toast.makeText(MainActivity.this, "Kamu Memilih Batu" + message, Toast.LENGTH_SHORT).show();
                txscore.setText("Score Player: " + Integer.toString(scorePlayer) + " Score Komputer: " + Integer.toString(scoreKomputer));
            }
        });

        btngunting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.setImageResource(R.drawable.gunting_bawah);
                String message = gamestart("gunting");
                Toast.makeText(MainActivity.this, "Kamu Memilih Gunting" + message, Toast.LENGTH_SHORT).show();
                txscore.setText("Score Player: " + Integer.toString(scorePlayer) + " Score Komputer: " + Integer.toString(scoreKomputer));
            }
        });

        btnkertas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.setImageResource(R.drawable.kertas_bawah);
                String message = gamestart("kertas");
                Toast.makeText(MainActivity.this, "Kamu Memilih Kertas" + message, Toast.LENGTH_SHORT).show();
                txscore.setText("Score Player: " + Integer.toString(scorePlayer) + " Score Komputer: " + Integer.toString(scoreKomputer));
            }
        });
    }

    private String gamestart(String player) {
        String komputer = "";
        Random angka_random = new Random();

        int angka_komputer = angka_random.nextInt(3) + 1;

        if (angka_komputer == 1) {
            komputer = "batu";
        } else if (angka_komputer == 2) {
            komputer = "gunting";
        } else if (angka_komputer == 3) {
            komputer = "kertas";
        }

        if (komputer.equals("batu")) {
            com.setImageResource(R.drawable.batu_atas);
        } else if (komputer.equals("gunting")) {
            com.setImageResource(R.drawable.gunting_atas);
        } else if (komputer.equals("kertas")) {
            com.setImageResource(R.drawable.kertas_atas);
        }

        // Aturan main
        if (komputer.equals(player)) {
            return "SERI";
        } else if (player.equals("batu") && komputer.equals("gunting")) {
            scorePlayer++;
            return "Kamu Menang";
        } else if (player.equals("batu") && komputer.equals("kertas")) {
            scoreKomputer++;
            return "Kamu Kalah";

        } else if (player == "gunting" && komputer == "kertas") {
            scorePlayer++;
            return "Kamu Menang";

        } else if (player == "gunting" && komputer == "batu") {
            scoreKomputer++;
            return "Kamu Kalah";

        } else if (player == "kertas" && komputer == "batu") {
            scorePlayer++;
            return "Kamu Menang";

        }else {
            scoreKomputer++;
            return "Kamu Kalah";

        }

    }
}