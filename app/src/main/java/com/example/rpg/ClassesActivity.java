package com.example.rpg;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class ClassesActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnBarbaro, btnBruxo, btnDruida, btnFeiticeiro, btnGuerreiro,
            btnLadino, btnMago, btnMonge, btnRanger, btnPaladino, btnBardo, btnClerigo;

    String assetName;
    int[] pages = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        creatViews();
    }

    private void creatViews() {
        btnBarbaro = (Button) findViewById(R.id.btnBarbaro);
        btnBruxo = (Button) findViewById(R.id.btnBruxo);
        btnDruida = (Button) findViewById(R.id.btnDruida);
        btnFeiticeiro = (Button) findViewById(R.id.btnFeiticeiro);
        btnGuerreiro = (Button) findViewById(R.id.btnGuerreiro);
        btnLadino = (Button) findViewById(R.id.btnLadino);
        btnMago = (Button) findViewById(R.id.btnMago);
        btnMonge = (Button) findViewById(R.id.btnMonge);
        btnRanger = (Button) findViewById(R.id.btnRanger);
        btnPaladino = (Button) findViewById(R.id.btnPaladino);
        btnBardo = (Button) findViewById(R.id.btnBardo);
        btnClerigo = (Button) findViewById(R.id.btnClerigo);

        btnBarbaro.setOnClickListener(this);
        btnBruxo.setOnClickListener(this);
        btnDruida.setOnClickListener(this);
        btnFeiticeiro.setOnClickListener(this);
        btnGuerreiro.setOnClickListener(this);
        btnLadino.setOnClickListener(this);
        btnMago.setOnClickListener(this);
        btnMonge.setOnClickListener(this);
        btnRanger.setOnClickListener(this);
        btnPaladino.setOnClickListener(this);
        btnBardo.setOnClickListener(this);
        btnClerigo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnBarbaro:
                assetName = "Jogador.pdf";
                pages = new int[]{46, 47, 48, 49, 50};
                openPdf();
                break;
            case R.id.btnBardo:
                assetName = "Jogador.pdf";
                pages = new int[]{51, 52, 53, 54, 55};
                openPdf();
                break;
            case R.id.btnBruxo:
                assetName = "Jogador.pdf";
                pages = new int[]{56, 57, 58, 59, 60, 61, 62};
                openPdf();
                break;
            case R.id.btnClerigo:
                assetName = "Jogador.pdf";
                pages = new int[]{63, 64, 65, 66, 67, 68, 69, 70};
                openPdf();
                break;

            case R.id.btnDruida:
                assetName = "Jogador.pdf";
                pages = new int[]{71, 72, 73, 74, 75, 76};
                openPdf();
                break;

            case R.id.btnFeiticeiro:
                assetName = "Jogador.pdf";
                pages = new int[]{77, 78, 79, 80, 81, 82};
                openPdf();
                break;

            case R.id.btnGuerreiro:
                assetName = "Jogador.pdf";
                pages = new int[]{83, 84, 85, 86, 87, 88};
                openPdf();
                break;

            case R.id.btnLadino:
                assetName = "Jogador.pdf";
                pages = new int[]{89, 90, 91, 92, 93};
                openPdf();
                break;

            case R.id.btnMago:
                assetName = "Jogador.pdf";
                pages = new int[]{94, 95, 96, 97, 98, 99, 100, 101};
                openPdf();
                break;

            case R.id.btnMonge:
                assetName = "Jogador.pdf";
                pages = new int[]{102, 103, 104, 105, 106, 107};
                openPdf();
                break;

            case R.id.btnPaladino:
                assetName = "Jogador.pdf";
                pages = new int[]{108, 109, 110, 111, 112, 113, 114};
                openPdf();
                break;

            case R.id.btnRanger:
                assetName = "Jogador.pdf";
                pages = new int[]{115, 116, 117, 118, 119};
                openPdf();
                break;

            default:
                break;
        }

    }

    private void openPdf() {
        Intent i = new Intent(ClassesActivity.this, PdfActivity.class);
        i.putExtra("PDF", assetName);
        i.putExtra("Pages", pages);
        startActivity(i);
    }

    @Override
    public boolean onPrepareOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch ( item.getItemId() ){
            case R.id.roll:
                alertDialogDice();
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void alertDialogDice() {

        int roll = getRandomNumber(1, 20);

        AlertDialog.Builder alertDice = new AlertDialog.Builder(ClassesActivity.this);
        alertDice.setIcon(R.drawable.d20);
        alertDice.setTitle("D20 rolado!").setCancelable(false).
                setMessage("Resultado: " + roll)
                .setPositiveButton("Voltar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        alertDice.show();

        if (roll == 20){

            Toast.makeText(getApplicationContext(), "BOA VOCÊ CRITOU 20! " +
                    roll, Toast.LENGTH_LONG).show();

        }if(roll == 1){

            Toast.makeText(getApplicationContext(), "Que triste, critou 1! " +
                    roll, Toast.LENGTH_LONG).show();
        }

    }

    public static int getRandomNumber(int min, int max) {

        return (new Random()).nextInt((max - min) + 1) + min;
    }

}