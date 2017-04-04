package com.gabrielaangebrandt.dz2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class temperaturaActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String KEY_UNOS_TEMPERATURE= "temperatura";
    public static final String KEY_KONVERZIJA_TEMPERATURE = "odabrana konverzija";

    ImageButton button;
    EditText iznos_temperature;
    Spinner spinner_temperatura;
    String odabrana_konverzija;
    ArrayAdapter<CharSequence> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temp_layout);
        setUpUI();

    }

    private void setUpUI() {
        this.spinner_temperatura = (Spinner) findViewById(R.id.konverzijaTemperature);
        this.button = (ImageButton) findViewById(R.id.bTemperatura);
        this.iznos_temperature = (EditText) findViewById(R.id.iznosTemperature);

        adapter = ArrayAdapter.createFromResource(this, R.array.popisTemperatura, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_temperatura.setAdapter(adapter);
        spinner_temperatura.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                odabrana_konverzija = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "Niste odabrali jedinicu.", Toast.LENGTH_SHORT).show();

            }
        });

        this.button.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(getApplicationContext(), RezultatiActivity.class);
        intent.putExtra(KEY_KONVERZIJA_TEMPERATURE, odabrana_konverzija);
        intent.putExtra(KEY_UNOS_TEMPERATURE, iznos_temperature.getText().toString());
        this.startActivity(intent);

    }
}