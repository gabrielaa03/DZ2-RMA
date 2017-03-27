package com.gabrielaangebrandt.dz2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class RezultatiActivity extends AppCompatActivity{

    TextView prvaJedinica, drugaJedinica, pretvoreno, uneseno;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.novac_layout);
        setUpUI();

    }

    private void setUpUI() {
        this.prvaJedinica = (TextView) findViewById(R.id.prvaJedinica);
        this.drugaJedinica = (TextView) findViewById(R.id.drugaJedinica);
        this.pretvoreno = (TextView) findViewById(R.id.izracunataVrijednost);
        this.uneseno = (TextView) findViewById(R.id.unesenaVrijednost);

        Intent intent = this.getIntent();
        if(intent.hasExtra(novacActivity.KEY_TEXT)){
            String text = intent.getStringExtra(novacActivity.KEY_TEXT);
            uneseno.setText(text);
        }
        if (intent.hasExtra(duzineActivity.KEY_TEXT)) {
            String text = intent.getStringExtra(duzineActivity.KEY_TEXT);
            uneseno.setText(text);
        }

        if (intent.hasExtra(tekucineActivity.KEY_TEXT)) {
            String text = intent.getStringExtra(tekucineActivity.KEY_TEXT);
            uneseno.setText(text);
        }
        if (intent.hasExtra(temperaturaActivity.KEY_TEXT)) {
            String text = intent.getStringExtra(temperaturaActivity.KEY_TEXT);
            uneseno.setText(text);
        }

        if (intent.hasExtra(novacActivity.KEY_SPINNER_1)) {
            String text = intent.getStringExtra(novacActivity.KEY_SPINNER_1);
            prvaJedinica.setText(text);
        }
        if (intent.hasExtra(duzineActivity.KEY_SPINNER_1)) {
            String text = intent.getStringExtra(duzineActivity.KEY_SPINNER_1);
            prvaJedinica.setText(text);
        }

        if (intent.hasExtra(tekucineActivity.KEY_SPINNER_1)) {
            String text = intent.getStringExtra(tekucineActivity.KEY_SPINNER_1);
            prvaJedinica.setText(text);
        }

        if (intent.hasExtra(temperaturaActivity.KEY_SPINNER_1)) {
            String text = intent.getStringExtra(temperaturaActivity.KEY_SPINNER_1);
            prvaJedinica.setText(text);
        }

    }

}