package br.com.abarreto.app;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText cpf;
    private static final String maskCPF = "###.###.###-##";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cpf = (EditText) findViewById(R.id.cpf);

        cpf.addTextChangedListener(MaskUtil.insert(cpf));

        button = (Button) findViewById(R.id.entrar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirChamados();
            }
        });

    }

    private void abrirChamados() {
        Intent intent = new Intent(this, ChamadosActivity.class);
        startActivity(intent);
    }

}
