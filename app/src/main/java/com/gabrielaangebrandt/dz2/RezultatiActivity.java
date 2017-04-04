package com.gabrielaangebrandt.dz2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class RezultatiActivity extends AppCompatActivity{

    TextView prvaJedinica, drugaJedinica, pretvoreno, uneseno;
    String textNovac, textTemperature, textDuzina, textTekucina;
    double novo, novo1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rezultati);
        SetUpUI();

    }

    private void SetUpUI() {
        prvaJedinica = (TextView) findViewById(R.id.prvaJedinica);
        drugaJedinica = (TextView) findViewById(R.id.drugaJedinica);
        pretvoreno = (TextView) findViewById(R.id.izracunataVrijednost);
        uneseno = (TextView) findViewById(R.id.unesenaVrijednost);

        Intent intent = this.getIntent();

        if(intent.hasExtra(novacActivity.KEY_UNESENI_IZNOS)){
            textNovac = intent.getStringExtra(novacActivity.KEY_UNESENI_IZNOS);
            uneseno.setText(textNovac);

        }
        if(intent.hasExtra(novacActivity.KEY_ODABRANA_KONVERZIJA)){
            String konverzija = intent.getStringExtra(novacActivity.KEY_ODABRANA_KONVERZIJA);

            switch (konverzija){
                case "kuna u dolar":
                    prvaJedinica.setText(R.string.kn);
                    drugaJedinica.setText(R.string.dolar);
                    textNovac=textNovac.replace(",", "");
                    try
                    {
                        novo = Double.parseDouble(textNovac);
                    }catch(NumberFormatException e)
                    {
                        e.printStackTrace();
                    }
                    double intTextNovac = novo / 6.9759817;

                    pretvoreno.setText(String.valueOf(intTextNovac));
                    break;
                case "dolar u kuna":
                    prvaJedinica.setText(R.string.dolar);
                    drugaJedinica.setText(R.string.kn);
                    textNovac=textNovac.replace(",", "");
                    try
                    {
                        novo = Double.parseDouble(textNovac);
                    }catch(NumberFormatException e)
                    {
                        e.printStackTrace();
                    }
                    double intTextNovac1 = novo * 6.9759817;
                    String noviTekst1 =String.valueOf(intTextNovac1);
                    pretvoreno.setText(noviTekst1);
                    break;

            }
        }
         if (intent.hasExtra(temperaturaActivity.KEY_UNOS_TEMPERATURE)) {
            textTemperature = intent.getStringExtra(temperaturaActivity.KEY_UNOS_TEMPERATURE);
            uneseno.setText(textTemperature);
        }
        if (intent.hasExtra(temperaturaActivity.KEY_KONVERZIJA_TEMPERATURE)){

            String konverzija = intent.getStringExtra(temperaturaActivity.KEY_KONVERZIJA_TEMPERATURE);

            switch (konverzija){
                case "Celzius u Kelvin":
                    prvaJedinica.setText(R.string.Celzius);
                    drugaJedinica.setText(R.string.Kelvin);
                    textTemperature=textTemperature.replace(",", "");
                    try
                    {
                        novo = Double.parseDouble(textTemperature);
                    }catch(NumberFormatException e)
                    {
                        e.printStackTrace();
                    }

                    double intTextTemperature= novo + 273.15;

                    pretvoreno.setText(String.valueOf(intTextTemperature));
                    break;
                case "Kelvin u Celzius":
                    prvaJedinica.setText(R.string.Kelvin);
                    drugaJedinica.setText(R.string.Celzius);
                    textTemperature=textTemperature.replace(",", "");
                    try
                    {
                        novo = Double.parseDouble(textTemperature);
                    }catch(NumberFormatException e)
                    {
                        e.printStackTrace();
                    }
                    double intTextTemperature1 = novo - 273.15;
                    pretvoreno.setText(String.valueOf(intTextTemperature1));
                    break;

            }
        }

        if (intent.hasExtra(tekucineActivity.KEY_IZNOS_TEKUCINE)) {
            textTekucina= intent.getStringExtra(tekucineActivity.KEY_IZNOS_TEKUCINE);
            uneseno.setText(textTekucina);
        }
        if (intent.hasExtra(tekucineActivity.KEY_KONVERZIJA_TEKUCINE)) {
            String konverzija = intent.getStringExtra(tekucineActivity.KEY_KONVERZIJA_TEKUCINE);

            switch (konverzija){
                case "ml u dl":
                    prvaJedinica.setText(R.string.mililitar);
                    drugaJedinica.setText(R.string.decilitar);
                    textTekucina=textTekucina.replace(",", "");
                    try
                    {
                        novo = Double.parseDouble(textTekucina);
                    }catch(NumberFormatException e)
                    {
                        e.printStackTrace();
                    }

                    double intTextTekucine= novo /100;

                    pretvoreno.setText(String.valueOf(intTextTekucine));
                    break;
                case "l u dl":
                    prvaJedinica.setText(R.string.litra);
                    drugaJedinica.setText(R.string.decilitar);
                    textTekucina=textTekucina.replace(",", "");
                    try
                    {
                        novo = Double.parseDouble(textTekucina);
                    }catch(NumberFormatException e)
                    {
                        e.printStackTrace();
                    }
                    double intTextTekucine1 = novo *10 ;
                    pretvoreno.setText(String.valueOf(intTextTekucine1));
                    break;

                case "dl u l":
                    prvaJedinica.setText(R.string.decilitar);
                    drugaJedinica.setText(R.string.litra);
                    textTekucina=textTekucina.replace(",", "");
                    try
                    {
                        novo = Double.parseDouble(textTekucina);
                    }catch(NumberFormatException e)
                    {
                        e.printStackTrace();
                    }
                    double intTextTekucine2 = novo /10 ;
                    pretvoreno.setText(String.valueOf(intTextTekucine2));
                    break;

                case "dl u ml":
                    prvaJedinica.setText(R.string.decilitar);
                    drugaJedinica.setText(R.string.mililitar);
                    textTekucina=textTekucina.replace(",", "");
                    try
                    {
                        novo = Double.parseDouble(textTekucina);
                    }catch(NumberFormatException e)
                    {
                        e.printStackTrace();
                    }

                    double intTextTekucine3= novo *100;

                    pretvoreno.setText(String.valueOf(intTextTekucine3));
                    break;

                case "l u ml":
                    prvaJedinica.setText(R.string.litra);
                    drugaJedinica.setText(R.string.mililitar);
                    textTekucina=textTekucina.replace(",", "");
                    try
                    {
                        novo = Double.parseDouble(textTekucina);
                    }catch(NumberFormatException e)
                    {
                        e.printStackTrace();
                    }

                    double intTextTekucine4= novo *1000;

                    pretvoreno.setText(String.valueOf(intTextTekucine4));
                    break;

                case "ml u l":
                    prvaJedinica.setText(R.string.mililitar);
                    drugaJedinica.setText(R.string.litra);
                    textTekucina=textTekucina.replace(",", "");
                    try
                    {
                        novo = Double.parseDouble(textTekucina);
                    }catch(NumberFormatException e)
                    {
                        e.printStackTrace();
                    }

                    double intTextTekucine5= novo /1000;

                    pretvoreno.setText(String.valueOf(intTextTekucine5));
                    break;
            }
        }
            if (intent.hasExtra(duzineActivity.KEY_IZNOS)) {
            textDuzina= intent.getStringExtra(duzineActivity.KEY_IZNOS);
            uneseno.setText(textDuzina);
        }

            if (intent.hasExtra(duzineActivity.KEY_KONVERZIJA_DUZINA)) {
                String konverzija = intent.getStringExtra(duzineActivity.KEY_KONVERZIJA_DUZINA);

                switch (konverzija) {
                    case "inch u cm":
                        prvaJedinica.setText(R.string.inch);
                        drugaJedinica.setText(R.string.cm);
                        textDuzina = textDuzina.replace(",", "");
                        try {
                            novo = Double.parseDouble(textDuzina);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }

                        double intTextDuzina = novo * 2.541;

                        pretvoreno.setText(String.valueOf(intTextDuzina));
                        break;

                    case "cm u inch":
                        prvaJedinica.setText(R.string.cm);
                        drugaJedinica.setText(R.string.inch);
                        textDuzina = textDuzina.replace(",", "");
                        try {
                            novo = Double.parseDouble(textDuzina);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }

                        double intTextDuzina1 = novo / 2.54;

                        pretvoreno.setText(String.valueOf(intTextDuzina1));
                        break;

                    case "m  u cm":
                        prvaJedinica.setText(R.string.m);
                        drugaJedinica.setText(R.string.cm);
                        textDuzina = textDuzina.replace(",", "");
                        try {
                            novo = Double.parseDouble(textDuzina);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }

                        double intTextDuzina2 = novo * 100;

                        pretvoreno.setText(String.valueOf(intTextDuzina2));
                        break;

                    case "dm u cm":
                        prvaJedinica.setText(R.string.dm);
                        drugaJedinica.setText(R.string.cm);
                        textDuzina = textDuzina.replace(",", "");
                        try {
                            novo = Double.parseDouble(textDuzina);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }

                        double intTextDuzina3 = novo * 10;

                        pretvoreno.setText(String.valueOf(intTextDuzina3));
                        break;

                    case "mm u cm":
                        prvaJedinica.setText(R.string.mm);
                        drugaJedinica.setText(R.string.cm);
                        textDuzina = textDuzina.replace(",", "");
                        try {
                            novo = Double.parseDouble(textDuzina);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }

                        double intTextDuzina4 = novo / 10;

                        pretvoreno.setText(String.valueOf(intTextDuzina4));
                        break;

                    case "mm u dm":
                        prvaJedinica.setText(R.string.mm);
                        drugaJedinica.setText(R.string.dm);
                        textDuzina = textDuzina.replace(",", "");
                        try {
                            novo = Double.parseDouble(textDuzina);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }

                        double intTextDuzina5 = novo / 100;

                        pretvoreno.setText(String.valueOf(intTextDuzina5));
                        break;

                    case "mm u m":
                        prvaJedinica.setText(R.string.mm);
                        drugaJedinica.setText(R.string.m);
                        textDuzina = textDuzina.replace(",", "");
                        try {
                            novo = Double.parseDouble(textDuzina);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }

                        double intTextDuzina6 = novo / 1000;

                        pretvoreno.setText(String.valueOf(intTextDuzina6));
                        break;

                    case "dm u mm":
                        prvaJedinica.setText(R.string.dm);
                        drugaJedinica.setText(R.string.mm);
                        textDuzina = textDuzina.replace(",", "");
                        try {
                            novo = Double.parseDouble(textDuzina);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }

                        double intTextDuzina7 = novo * 100;

                        pretvoreno.setText(String.valueOf(intTextDuzina7));
                        break;


                    case "dm u m":
                        prvaJedinica.setText(R.string.dm);
                        drugaJedinica.setText(R.string.m);
                        textDuzina = textDuzina.replace(",", "");
                        try {
                            novo = Double.parseDouble(textDuzina);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }

                        double intTextDuzina8 = novo / 10;

                        pretvoreno.setText(String.valueOf(intTextDuzina8));
                        break;

                    case "m u dm":
                        prvaJedinica.setText(R.string.m);
                        drugaJedinica.setText(R.string.dm);
                        textDuzina = textDuzina.replace(",", "");
                        try {
                            novo = Double.parseDouble(textDuzina);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }

                        double intTextDuzina9 = novo * 10;

                        pretvoreno.setText(String.valueOf(intTextDuzina9));
                        break;

                    case "m u cm":
                        prvaJedinica.setText(R.string.m);
                        drugaJedinica.setText(R.string.cm);
                        textDuzina = textDuzina.replace(",", "");
                        try {
                            novo = Double.parseDouble(textDuzina);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }

                        double intTextDuzina10 = novo * 100;

                        pretvoreno.setText(String.valueOf(intTextDuzina10));
                        break;

                    case "m u mm":
                        prvaJedinica.setText(R.string.m);
                        drugaJedinica.setText(R.string.mm);
                        textDuzina = textDuzina.replace(",", "");
                        try {
                            novo = Double.parseDouble(textDuzina);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }

                        double intTextDuzina11 = novo * 1000;

                        pretvoreno.setText(String.valueOf(intTextDuzina11));
                        break;

                    case "cm u mm":
                        prvaJedinica.setText(R.string.cm);
                        drugaJedinica.setText(R.string.mm);
                        textDuzina = textDuzina.replace(",", "");
                        try {
                            novo = Double.parseDouble(textDuzina);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }

                        double intTextDuzina12 = novo * 10;

                        pretvoreno.setText(String.valueOf(intTextDuzina12));
                        break;

                    case "cm u m":
                        prvaJedinica.setText(R.string.cm);
                        drugaJedinica.setText(R.string.m);
                        textDuzina = textDuzina.replace(",", "");
                        try {
                            novo = Double.parseDouble(textDuzina);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }

                        double intTextDuzina13 = novo / 100;

                        pretvoreno.setText(String.valueOf(intTextDuzina13));
                        break;

                    case "cm u dm":
                        prvaJedinica.setText(R.string.cm);
                        drugaJedinica.setText(R.string.dm);
                        textDuzina = textDuzina.replace(",", "");
                        try {
                            novo = Double.parseDouble(textDuzina);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }

                        double intTextDuzina14 = novo / 10;

                        pretvoreno.setText(String.valueOf(intTextDuzina14));
                        break;
                }

            }



    }

}