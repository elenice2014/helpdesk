package br.com.abarreto.app;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterListView extends BaseAdapter
{
    private LayoutInflater mInflater;
    private ArrayList<ItemListView> itens;

    public AdapterListView(Context context, ArrayList<ItemListView> itens) {

        this.itens = itens;
        mInflater = LayoutInflater.from(context);
    }

    public int getCount(){
        return itens.size();
    }

    public ItemListView getItem(int position) {
        return itens.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View view, ViewGroup parent) {
        ItemListView item = itens.get(position);
        view = mInflater.inflate(R.layout.item_listview, null);

        ((TextView) view.findViewById(R.id.numero_chamado)).setText(item.getChamado());

        if (item.getStatus() == "aberto") {
            ((ImageView) view.findViewById(R.id.status)).setImageResource(R.drawable.aberto);
        } else if (item.getStatus() == "atendimento") {
            ((ImageView) view.findViewById(R.id.status)).setImageResource(R.drawable.atendimento);
        } else {
            ((ImageView) view.findViewById(R.id.status)).setImageResource(R.drawable.fechado);
        }

        return view;
    }

}
