package johnmendes.com.example.magiclifecounter.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import johnmendes.com.example.magiclifecounter.R;

public class DueloActivity extends AppCompatActivity {

    private ImageButton upBtt1, downBtt1, upBtt2, downBtt2, diceBtt;
    private TextView lifeCount1, lifeCount2;
    private int lifeCountFirst = 20;
    private int lifeCountSecon = 20;

    int roll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duelo);

        this.setTitle("Duelo");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        diceBtt = findViewById(R.id.diceBtt);

        upBtt1 = findViewById(R.id.up1);
        upBtt2 = findViewById(R.id.up2);

        downBtt1 = findViewById(R.id.down1);
        downBtt2 = findViewById(R.id.down2);

        lifeCount1 = findViewById(R.id.cont1);
        lifeCount2 = findViewById(R.id.cont2);

//      Botão dado D20
        diceBtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alertDialogDice();
            }
        });

//      Botão vida +
        upBtt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lifeCountFirst++;
                lifeCount1.setText(Integer.toString(lifeCountFirst));
            }
        });

//      Botão vida +
        upBtt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lifeCountSecon++;
                lifeCount2.setText(Integer.toString(lifeCountSecon));
            }
        });

//      Botão vida -
        downBtt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lifeCountFirst--;
                lifeCount1.setText(Integer.toString(lifeCountFirst));

                if (lifeCountFirst == 0) {

                    lifeCountFirst = 0;
                    lifeCount1.setText(Integer.toString(lifeCountFirst));
                    alertDialog();
                }
            }
        });

//      Botão vida -
        downBtt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lifeCountSecon--;
                lifeCount2.setText(Integer.toString(lifeCountSecon));

                if (lifeCountSecon == 0) {

                    lifeCountSecon = 0;
                    lifeCount2.setText(Integer.toString(lifeCountSecon));

                    alertDialog();
                }
            }
        });

    }

//      Volta e fecha activity
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

//      Reinicia vida Dialog
    public void alertDialog() {

        AlertDialog.Builder alertLife = new AlertDialog.Builder(DueloActivity.this);
        alertLife.setIcon(R.drawable.smile);
        alertLife.setTitle("Parabéns ao campeão!").setCancelable(false)
                .setPositiveButton("Novo Jogo", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        refresh();

                    }
                });
                        alertLife.show();
    }

//     Roll Dado Dialog
   public void alertDialogDice() {

       roll = getRandomNumber(1, 20);

       AlertDialog.Builder alertDice = new AlertDialog.Builder(DueloActivity.this);
       alertDice.setIcon(R.drawable.diceicon);
       alertDice.setTitle("D20 rolado!").setCancelable(false).
               setMessage("Resultado: " + roll)
               .setPositiveButton("Voltar", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {

                   }
               });
       alertDice.show();

       if (roll == 20){

           Toast.makeText(getApplicationContext(), "BOA VOCÊ CRITOU " +
                   roll, Toast.LENGTH_LONG).show();

       }if(roll == 1){

           Toast.makeText(getApplicationContext(), "Que triste, critou " +
                   roll, Toast.LENGTH_LONG).show();
       }

   }

//     Reinicia vidas
   public void refresh() {
            lifeCountFirst = 20;
        lifeCountSecon = 20;

        lifeCount1.setText(Integer.toString(lifeCountFirst));
        lifeCount2.setText(Integer.toString(lifeCountSecon));
   }

   public static int getRandomNumber(int min, int max) {

      return (new Random()).nextInt((max - min) + 1) + min;
   }

}