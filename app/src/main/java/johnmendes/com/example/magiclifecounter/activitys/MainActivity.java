package johnmendes.com.example.magiclifecounter.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import johnmendes.com.example.magiclifecounter.R;

public class MainActivity extends AppCompatActivity {

    private ImageButton upBtt, downBtt, refreshBtt;
    private TextView lifeCounter;
    private int lifeCount = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.background);
        int image = getIntent().getIntExtra("image",R.drawable.background0);
        linearLayout.setBackgroundResource(image);

        upBtt = findViewById(R.id.UpBtt);
        upBtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lifeCount ++;
                lifeCounter.setText(Integer.toString(lifeCount));
            }
        });
        downBtt = findViewById(R.id.DownBtt);
        downBtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lifeCount --;
                lifeCounter.setText(Integer.toString(lifeCount));

                if (lifeCount == 0){

                    AlertDialog.Builder alertLife = new AlertDialog.Builder(MainActivity.this);
                    alertLife.setTitle("Você Perdeu!").setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {

                                    refresh();
                                }
                            });
                    alertLife.show();

                }else{
                    lifeCounter.setText(Integer.toString(lifeCount));
                }

            }
        });

        lifeCounter = findViewById(R.id.LifeCounter);
        refreshBtt = findViewById(R.id.refreshBtt);
        refreshBtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refresh();

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch ( item.getItemId() ){//Abrir Configurações
            case R.id.menuConfiguracoes:
                abrirConfiguracoes();

                break;
            case R.id.menuFichas:
                abrirFichas();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void abrirConfiguracoes(){
        Intent intent = new Intent(MainActivity.this, ConfiguracoesActivity.class);
        startActivity( intent );
    }


    public void abrirFichas() {

        Intent intent = new Intent(MainActivity.this, FichasActivity.class);
        startActivity(intent);
    }

    public void refresh(){
        lifeCount = 20;
        lifeCounter.setText(Integer.toString(lifeCount));
    }

}