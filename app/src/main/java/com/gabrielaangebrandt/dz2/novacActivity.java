package com.gabrielaangebrandt.dz2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class novacActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String KEY_UNESENI_IZNOS = "iznos za pretvorbu unesen";
    public static final String KEY_ODABRANA_KONVERZIJA = "spinner odabran";

    Button slikaDolara;
    EditText iznos;
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    String odabrana_konverzija, uneseni_iznos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.novac_layout);
        setUpUI();

    }

    private void setUpUI() {
        this.spinner = (Spinner) findViewById(R.id.spinnerNovac);
        this.slikaDolara = (Button) findViewById(R.id.nButton);
        this.iznos = (EditText) findViewById(R.id.editTextNovac);


        adapter = ArrayAdapter.createFromResource(this, R.array.popisNovaca, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                odabrana_konverzija = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "Niste odabrali jedinicu.", Toast.LENGTH_SHORT).show();

            }
        });

        this.slikaDolara.setOnClickListener(this); //osluškivac na klik

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), RezultatiActivity.class);
        intent.putExtra(KEY_ODABRANA_KONVERZIJA, odabrana_konverzija);
        if(iznos.getText().toString().isEmpty() || iznos.getText().length()==0 || iznos.getText().toString()==""){
            iznos.setError("Unesite vrijednost");
        }else {
            intent.putExtra(KEY_UNESENI_IZNOS, iznos.getText().toString());
            this.startActivity(intent);
        }
    }
}

