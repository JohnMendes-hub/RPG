package com.example.rpg;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    Button btnClasses, btnMonstros, btnMestre, btnJogador, btnXanathar;
    String assetName;
    int[] pages = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        createViews();
    }

    private void createViews() {
        btnClasses = (Button) findViewById(R.id.btnClasses);
        btnMonstros = (Button) findViewById(R.id.btnMonstros);
        btnMestre = (Button) findViewById(R.id.btnMestre);
        btnJogador = (Button) findViewById(R.id.btnJogador);
        btnXanathar = (Button) findViewById(R.id.btnXanathar);

        btnClasses.setOnClickListener(this);
        btnMonstros.setOnClickListener(this);
        btnMestre.setOnClickListener(this);
        btnJogador.setOnClickListener(this);
        btnXanathar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnClasses:
                startActivity(new Intent(MainActivity.this, ClassesActivity.class));
                break;
            case R.id.btnMonstros:
                 assetName = "Monsters.pdf";
                 openPdf();
                break;
            case R.id.btnJogador:
                assetName = "Jogador.pdf";
                openPdf();
                break;
            case R.id.btnXanathar:
                assetName = "Xanathar.pdf";
                openPdf();
                break;
            case R.id.btnMestre:
                assetName = "Mestre.pdf";
                openPdf();
            default:
                break;
        }
    }

    private void openPdf() {
        Intent i = new Intent(MainActivity.this, PdfActivity.class);
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

        AlertDialog.Builder alertDice = new AlertDialog.Builder(MainActivity.this);
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