package johnmendes.com.example.magiclifecounter.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import johnmendes.com.example.magiclifecounter.R;

public class FichasActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    private Spinner spinner;
    private int marcadorPositivo = 0, marcadorNegativo = 0;

    public static String selected;

    int[] imagensIds = {
            R.drawable.rat,
            R.drawable.soldier,
            R.drawable.elf,
            R.drawable.zombie,
            R.drawable.angel,
            R.drawable.spirit,
            R.drawable.pig,
            R.drawable.pegasus,
            R.drawable.vampire,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fichas);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


        this.setTitle("Fichas");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        spinner = findViewById(R.id.Spinner);
        linearLayout = findViewById(R.id.LinearLayout);

        fichasLista();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void fichasLista(){

        List<String> list = new ArrayList<String>();
        list.add("Rat");
        list.add("Soldier");
        list.add("Elf");
        list.add("Zombie");
        list.add("Angel");
        list.add("Spirit");
        list.add("Pig");
        list.add("Pegasus");
        list.add("Vampire");

//      Listando itens
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
//       Selecionando itens
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if(adapterView.getItemAtPosition(i).toString().equals("Rat")){

                    linearLayout.setBackgroundResource(imagensIds[0]);
                }if(adapterView.getItemAtPosition(i).toString().equals("Soldier")){

                    linearLayout.setBackgroundResource(imagensIds[1]);
                }if(adapterView.getItemAtPosition(i).toString().equals("Elf")){

                    linearLayout.setBackgroundResource(imagensIds[2]);
                }if(adapterView.getItemAtPosition(i).toString().equals("Zombie")){

                    linearLayout.setBackgroundResource(imagensIds[3]);
                }if(adapterView.getItemAtPosition(i).toString().equals("Angel")){

                    linearLayout.setBackgroundResource(imagensIds[4]);
                }if(adapterView.getItemAtPosition(i).toString().equals("Spirit")){

                    linearLayout.setBackgroundResource(imagensIds[5]);
                }if(adapterView.getItemAtPosition(i).toString().equals("Pig")){

                    linearLayout.setBackgroundResource(imagensIds[6]);
                }if(adapterView.getItemAtPosition(i).toString().equals("Pegasus")){

                    linearLayout.setBackgroundResource(imagensIds[7]);
                }if(adapterView.getItemAtPosition(i).toString().equals("Vampire")){

                    linearLayout.setBackgroundResource(imagensIds[8]);
                }

                Toast.makeText(getApplicationContext(), "Selecionado " +
                        adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
                selected = adapterView.getItemAtPosition(i).toString();
                Log.e("SELECIONADO", selected);

                try {

                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

}