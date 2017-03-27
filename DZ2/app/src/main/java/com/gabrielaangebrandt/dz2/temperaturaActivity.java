package com.gabrielaangebrandt.dz2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class temperaturaActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String KEY_TEXT = "text";
    public static final String KEY_SPINNER_1 = "spiner1 selected";

    Button button;
    EditText upisTemperature;
    Spinner temperatura1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temp_layout);
        setUpUI();

    }

    private void setUpUI() {
        this.temperatura1 = (Spinner) findViewById(R.id.temperatura1);
        this.button = (Button) findViewById(R.id.bTemperatura);
        this.upisTemperature = (EditText) findViewById(R.id.upistemperature);

        this.button.setOnClickListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.popisTemperatura, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temperatura1.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        String text2 = this.upisTemperature.getText().toString();
        Intent intent = new Intent(getApplicationContext(), RezultatiActivity.class);
        intent.putExtra(KEY_SPINNER_1,temperatura1.getSelectedItem().toString());
        intent.putExtra(KEY_TEXT, text2);
        this.startActivity(intent);

    }
}