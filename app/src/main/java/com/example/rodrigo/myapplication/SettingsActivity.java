package com.example.rodrigo.myapplication;

import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

@SuppressWarnings("deprecation")
public class SettingsActivity extends PreferenceActivity
        implements Preference.OnPreferenceChangeListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.config_principal);

        // Para cada opção, associar um OnPreferenceChangeListener para atualizar a interface,
        // para que o texto nas configurações esteja de acordo com o valor atual da opção
        bindPreferenceSummaryToValue(findPreference(getString(R.string.conf_nome_vovo_chave)));
    }

    /**
     * Associa um listener a uma opção
     */
    private void bindPreferenceSummaryToValue(Preference preference) {
        // Define o listener como este objeto
        preference.setOnPreferenceChangeListener(this);

        // Chama o listener imediatamente com o valor atual
        onPreferenceChange(preference,
                PreferenceManager
                        .getDefaultSharedPreferences(preference.getContext())
                        .getString(preference.getKey(), ""));
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object value) {
        String stringValue = value.toString();

        if (preference instanceof ListPreference) {
            // Se a opção for uma lista, procura o elemento correspondente
            ListPreference listPreference = (ListPreference) preference;
            int prefIndex = listPreference.findIndexOfValue(stringValue);
            if (prefIndex >= 0) {
                preference.setSummary(listPreference.getEntries()[prefIndex]);
            }
        } else {
            // Para outros tipos, utilizar a versão simplificada em texto
            preference.setSummary(stringValue);
        }
        return true;
    }
}

