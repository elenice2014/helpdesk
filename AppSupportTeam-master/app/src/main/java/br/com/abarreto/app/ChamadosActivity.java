package br.com.abarreto.app;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ChamadosActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView listView;
    private AdapterListView adapterListView;
    private ArrayList<ItemListView> itens;
    private LayoutInflater mInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chamados);

        mInflater = LayoutInflater.from(this);

        listView = (ListView) findViewById(R.id.lista);
        listView.setOnItemClickListener(this);
        createListView();
    }

    private void createListView() {
        itens = new ArrayList<ItemListView>();
        ItemListView item1 = new ItemListView("123456", "aberto");
        ItemListView item2 = new ItemListView("234567", "aberto");
        ItemListView item3 = new ItemListView("345678", "atendimento");
        ItemListView item4 = new ItemListView("456789", "atendimento");
        ItemListView item5 = new ItemListView("567891","fechado");
        ItemListView item6 = new ItemListView("678912","fechado");

        itens.add(item1);
        itens.add(item2);
        itens.add(item3);
        itens.add(item4);
        itens.add(item5);
        itens.add(item6);


        adapterListView = new AdapterListView(this, itens);

        listView.setAdapter(adapterListView);
        listView.setCacheColorHint(Color.TRANSPARENT);
    }

    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        Intent intent = new Intent(this, DetalhesActivity.class);
        startActivity(intent);
    }

}
