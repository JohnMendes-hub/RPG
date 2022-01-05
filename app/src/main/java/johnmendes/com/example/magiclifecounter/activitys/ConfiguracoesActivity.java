package johnmendes.com.example.magiclifecounter.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import johnmendes.com.example.magiclifecounter.R;


public class ConfiguracoesActivity extends AppCompatActivity {

    private ImageButton rightButton, leftButton;
    private Button wallpaperButton;
    private ImageView wallpaperImg;

    int[] imagensIds = {
            R.drawable.background0,
            R.drawable.background1,
            R.drawable.background2,
            R.drawable.background3,
            R.drawable.background4,
            R.drawable.background5,
            R.drawable.background6,
            R.drawable.background7,
            R.drawable.background8,
            R.drawable.background10,
            R.drawable.background11,
            R.drawable.background12,

    };

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_configuracoes);
        this.setTitle("Configurações");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        rightButton     = findViewById(R.id.rightButton);
        leftButton      = findViewById(R.id.leftButton);
        wallpaperImg    = findViewById(R.id.wallpaperImg);
        wallpaperButton = findViewById(R.id.wallpaperButton);

        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nextImage();

            }
        });

        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                previousImage();
            }
        });

        wallpaperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ConfiguracoesActivity.this, MainActivity.class); intent.putExtra("image", imagensIds[i]);
                startActivity(intent);

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void nextImage(){

        i++;
        wallpaperImg.setImageResource(imagensIds[i]);
        leftButton.setVisibility(View.VISIBLE);

        if(i > 10){
            i = 10;
            wallpaperImg.setImageResource(imagensIds[11]);

        }

    }

    public void previousImage(){

        i--;
        wallpaperImg.setImageResource(imagensIds[i]);

        if(i == -1 | i == 0){

            leftButton.setVisibility(View.GONE);

        }

    }

}
