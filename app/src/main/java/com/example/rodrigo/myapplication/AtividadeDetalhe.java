package com.example.rodrigo.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


@SuppressWarnings("deprecation")
public class AtividadeDetalhe extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividade_detalhe);

        Intent intent = getIntent();
        String detailText = intent.getStringExtra(Intent.EXTRA_TEXT);

        if (intent.hasExtra(Intent.EXTRA_TEXT)) {
            TextView detailTextView = (TextView) findViewById(R.id.detalhe_item_texto);

            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            String nome_vovo = prefs.getString(getString(R.string.conf_nome_vovo_chave),
                    getString(R.string.conf_nome_vovo_padrao));

            detailText = "Vovó " + nome_vovo + " faz " + detailText;

            detailTextView.setText(detailText);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_atividade_detalhe, menu);
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
