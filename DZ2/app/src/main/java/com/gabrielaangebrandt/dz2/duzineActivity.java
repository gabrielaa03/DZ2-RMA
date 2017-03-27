package com.gabrielaangebrandt.dz2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class duzineActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String KEY_TEXT = "text";
    public static final String KEY_SPINNER_1 = "spiner1 selected";

    Button button;
    EditText editText;
    Spinner spinner1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.duzine_layout);
        setUpUI();

    }

    private void setUpUI() {
        this.spinner1 = (Spinner) findViewById(R.id.spinner1);
        this.button = (Button) findViewById(R.id.button);
        this.editText = (EditText) findViewById(R.id.editText);

        this.button.setOnClickListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.popisDuzina, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {



        String text1 = this.editText.getText().toString();
        Intent intent = new Intent(getApplicationContext(), RezultatiActivity.class);
        intent.putExtra(KEY_SPINNER_1,spinner1.getSelectedItem().toString());
        intent.putExtra(KEY_TEXT, text1);
        this.startActivity(intent);

    }
}
