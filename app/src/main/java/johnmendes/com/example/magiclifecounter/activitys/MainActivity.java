package johnmendes.com.example.magiclifecounter.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.WindowManager;
import android.widget.Button;


import johnmendes.com.example.magiclifecounter.R;

public class MainActivity extends Activity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    Button btnClasses, btnMonstros, btnMestre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        createViews();
    }

    private void createViews() {
        btnClasses = (Button) findViewById(R.id.btnClasses);
        btnMonstros = (Button) findViewById(R.id.btnMonstros);
        btnMestre = (Button) findViewById(R.id.btnMestre);

        btnClasses.setOnClickListener(this);
        btnMonstros.setOnClickListener(this);
        btnMestre.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnClasses:
                startActivity(new Intent(MainActivity.this, ClassesActivity.class));
                break;
            case R.id.btnMonstros:
                startActivity(new Intent(MainActivity.this, PdfActivity.class));
                break;
            case R.id.btnMestre:
                startActivity(new Intent(MainActivity.this, MestreActivity.class));
            default:
                break;
        }
    }

}