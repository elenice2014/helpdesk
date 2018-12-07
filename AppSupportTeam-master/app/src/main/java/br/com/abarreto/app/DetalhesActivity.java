package br.com.abarreto.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class DetalhesActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        button = (Button) findViewById(R.id.voltar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voltarChamados();
            }
        });

    }

    private void voltarChamados() {
        Intent intent = new Intent(this, ChamadosActivity.class);
        startActivity(intent);
    }

}
