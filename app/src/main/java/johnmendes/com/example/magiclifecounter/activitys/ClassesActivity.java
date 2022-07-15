package johnmendes.com.example.magiclifecounter.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import johnmendes.com.example.magiclifecounter.R;

public class ClassesActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnBarbaro, btnBruxo, btnDruida, btnFeiticeiro, btnGuerreiro, btnLadino, btnMago,
            btnMonge, btnRanger, btnPaladino;

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
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnBarbaro:

                openClass();

                break;
            case R.id.btnBruxo:

                break;

            case R.id.btnDruida:

                break;

            case R.id.btnFeiticeiro:

                break;

            case R.id.btnGuerreiro:

                break;

            case R.id.btnLadino:

                break;

            case R.id.btnMago:

                break;

            case R.id.btnMonge:

                break;

            case R.id.btnRanger:

                break;

            case R.id.btnPaladino:

                break;
            default:
                break;
        }


    }

    private void openClass() {
        startActivity(new Intent(ClassesActivity.this, ClasseSelecionadaActivity.class));
    }

}