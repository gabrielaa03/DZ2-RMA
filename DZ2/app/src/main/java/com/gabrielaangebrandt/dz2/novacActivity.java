package com.gabrielaangebrandt.dz2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

public class novacActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String KEY_TEXT = "text";
    public static final String KEY_SPINNER_1 = "spiner1 selected";

    ImageButton slikaDolara;
    EditText iznos;
    Spinner dlkn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.novac_layout);
        setUpUI();

    }

    private void setUpUI() {
        this.dlkn = (Spinner) findViewById(R.id.dlkn);
        this.slikaDolara = (ImageButton) findViewById(R.id.slikaDolara);
        this.iznos = (EditText) findViewById(R.id.iznos);

        this.slikaDolara.setOnClickListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.popisNovaca, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dlkn.setAdapter(adapter);


    }

/*
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this, "Niste odabrali jedinicu.", Toast.LENGTH_SHORT).show();

    }*/
    @Override
    public void onClick(View v) {
        String text = this.iznos.getText().toString();
        Intent intent = new Intent(getApplicationContext(), RezultatiActivity.class);
        intent.putExtra(KEY_SPINNER_1,dlkn.getSelectedItem().toString());
        intent.putExtra(KEY_TEXT, text);
        this.startActivity(intent);

    }
}

