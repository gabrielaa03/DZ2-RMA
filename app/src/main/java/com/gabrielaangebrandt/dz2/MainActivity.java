package com.gabrielaangebrandt.dz2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button novac, temperatura, tekucine, duzine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setUpUI();
    }

    private void setUpUI() {
        this.novac =  (Button) findViewById(R.id.prviGumb);
        this.temperatura =  (Button) findViewById(R.id.drugiGumb);
        this.duzine =  (Button) findViewById(R.id.treciGumb);
        this.tekucine =  (Button) findViewById(R.id.cetvrtiGumb);

        this.novac.setOnClickListener(this);
        this.temperatura.setOnClickListener(this);
        this.duzine.setOnClickListener(this);
        this.tekucine.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent explicitIntent = null;

        switch(v.getId()) {

            case (R.id.prviGumb):

                explicitIntent= new Intent();
                explicitIntent.setClass(getApplicationContext(), novacActivity.class);
                startActivity(explicitIntent);
                break;
            case (R.id.drugiGumb):
                explicitIntent= new Intent();
                explicitIntent.setClass(getApplicationContext(), temperaturaActivity.class);
                startActivity(explicitIntent);
                break;
            case (R.id.treciGumb):
                explicitIntent= new Intent();
                explicitIntent.setClass(getApplicationContext(), duzineActivity.class);
                startActivity(explicitIntent);
                break;
            case (R.id.cetvrtiGumb):
                explicitIntent= new Intent();
                explicitIntent.setClass(getApplicationContext(), tekucineActivity.class);
                startActivity(explicitIntent);
                break;
        }

    }
}
