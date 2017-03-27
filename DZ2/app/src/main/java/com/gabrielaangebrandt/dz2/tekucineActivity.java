package com.gabrielaangebrandt.dz2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class tekucineActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String KEY_TEXT = "text";
    public static final String KEY_SPINNER_1 = "spiner1 selected";


    Button bTekucina;
    EditText upisTekucine;
    Spinner popisTekucina;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tekucine_layout);
        setUpUI();

    }

    private void setUpUI() {
        this.popisTekucina = (Spinner) findViewById(R.id.popistekucina);
        this.bTekucina = (Button) findViewById(R.id.bTekucine);
        this.upisTekucine = (EditText) findViewById(R.id.upistekucine);

        this.bTekucina.setOnClickListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.popisTekucina, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        popisTekucina.setAdapter(adapter);


    }

    @Override
    public void onClick(View v) {
        String text1 = this.upisTekucine.getText().toString();
        Intent intent = new Intent(getApplicationContext(), RezultatiActivity.class);
        intent.putExtra(KEY_SPINNER_1,popisTekucina.getSelectedItem().toString());
        intent.putExtra(KEY_TEXT, text1);
        this.startActivity(intent);

    }
}