package com.example.rodrigo.myapplication;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SuppressWarnings("deprecation")
public class MainActivity extends ActionBarActivity {

    private ListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] dados = {
                "Bolo - 45min",
                "Pizza - 30min",
                "Capuccino - 5min",
                "Salada - 10min",
                "Nhoque - 1h",
                "Vitamina - 10min"
        };

        List<String> receitas = new ArrayList<>(Arrays.asList(dados));

        mAdapter = new ArrayAdapter<>(
                getApplicationContext(), // Contexto atual
                R.layout.item_lista, // Nome do ID do layout
                R.id.item_texto, // ID do TextView a ser preenchido
                receitas);

        ListView listView = (ListView) findViewById(R.id.lista_principal);
        listView.setAdapter(mAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
