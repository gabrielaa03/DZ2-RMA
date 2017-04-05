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

public class tekucineActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String KEY_IZNOS_TEKUCINE= "volumen tekucine";
    public static final String KEY_KONVERZIJA_TEKUCINE = "odabrana konverzija";


    Button bTekucina;
    EditText iznos_tekucine;
    Spinner spinner_tekucine;
    String odabrana_konverzija;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tekucine_layout);
        setUpUI();

    }

    private void setUpUI() {
        this.spinner_tekucine = (Spinner) findViewById(R.id.spinnerTekucina);
        this.bTekucina = (Button) findViewById(R.id.bTekucine);
        this.iznos_tekucine = (EditText) findViewById(R.id.vrijednostTekucine);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.popisTekucina, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_tekucine.setAdapter(adapter);
        spinner_tekucine.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                odabrana_konverzija = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "Niste odabrali jedinicu.", Toast.LENGTH_SHORT).show();

            }
        });


        this.bTekucina.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), RezultatiActivity.class);
        intent.putExtra(KEY_KONVERZIJA_TEKUCINE, odabrana_konverzija);
        if(iznos_tekucine.getText().toString().isEmpty() || iznos_tekucine.getText().length()==0 || iznos_tekucine.getText().toString()==""){
         iznos_tekucine.setError("Unesite vrijednost");
        }else {
            intent.putExtra(KEY_IZNOS_TEKUCINE, iznos_tekucine.getText().toString());
            this.startActivity(intent);
        }

    }
}
