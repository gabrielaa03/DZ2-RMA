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

public class duzineActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String KEY_IZNOS = "iznos duzine";
    public static final String KEY_KONVERZIJA_DUZINA = "odabrana konverzija";

    Button button;
    EditText iznos;
    Spinner spinnerDuzina;
    ArrayAdapter<CharSequence> adapter;
    String odabrana_konverzija;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.duzine_layout);
        setUpUI();

    }

    private void setUpUI() {
        this.spinnerDuzina = (Spinner) findViewById(R.id.spinnerDuzina);
        this.button = (Button) findViewById(R.id.dButton);
        this.iznos = (EditText) findViewById(R.id.editText);



        adapter = ArrayAdapter.createFromResource(this, R.array.popisDuzina, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDuzina.setAdapter(adapter);

        spinnerDuzina.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
        intent.putExtra(KEY_KONVERZIJA_DUZINA, spinnerDuzina.getSelectedItem().toString());
        if(iznos.getText().toString().isEmpty() || iznos.getText().length()==0 || iznos.getText().toString()==""){
            iznos.setError("Unesite vrijednost");
        }
        else {
            intent.putExtra(KEY_IZNOS, iznos.getText().toString());
            this.startActivity(intent);
        }


    }
}
