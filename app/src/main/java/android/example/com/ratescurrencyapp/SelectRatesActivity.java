package android.example.com.ratescurrencyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;


import java.util.ArrayList;

public class SelectRatesActivity extends AppCompatActivity {

    private Spinner rateSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_rates);

        ArrayList<ItemData> list = new ArrayList<>();
        list.add(new ItemData("USD",R.drawable.us));
        list.add(new ItemData("GBP",R.drawable.gb));
        list.add(new ItemData("AUD",R.drawable.au));
        list.add(new ItemData("BGN",R.drawable.bg));
        list.add(new ItemData("EUR",R.drawable.eu));
        list.add(new ItemData("BRL",R.drawable.br));
        list.add(new ItemData("CAD",R.drawable.ca));
        list.add(new ItemData("CHF",R.drawable.ch));
        list.add(new ItemData("CNY",R.drawable.cn));
        list.add(new ItemData("CZK",R.drawable.cz));
        list.add(new ItemData("DKK",R.drawable.dk));
        list.add(new ItemData("HKD",R.drawable.hk));
        list.add(new ItemData("HRK",R.drawable.hr));
        list.add(new ItemData("HUF",R.drawable.hu));
        list.add(new ItemData("IDR",R.drawable.id));
        list.add(new ItemData("ILS",R.drawable.il));
        list.add(new ItemData("INR",R.drawable.in));
        list.add(new ItemData("JPY",R.drawable.jp));
        list.add(new ItemData("KRW",R.drawable.kr));
        list.add(new ItemData("MXN",R.drawable.mx));
        list.add(new ItemData("MYR",R.drawable.my));
        list.add(new ItemData("NOK",R.drawable.no));
        list.add(new ItemData("NZD",R.drawable.nz));
        list.add(new ItemData("PHP",R.drawable.ph));
        list.add(new ItemData("PLN",R.drawable.pl));
        list.add(new ItemData("RON",R.drawable.ro));
        list.add(new ItemData("RUB",R.drawable.ru));
        list.add(new ItemData("SEK",R.drawable.se));
        list.add(new ItemData("SGD",R.drawable.sg));
        list.add(new ItemData("THB",R.drawable.th));
        list.add(new ItemData("TRY",R.drawable.tr));
        list.add(new ItemData("ZAR",R.drawable.za));

        rateSpinner = findViewById(R.id.rates_spinner);
        SpinnerAdapter adapter = new SpinnerAdapter(this, R.layout.spinner_layout, R.id.rates_text,list);
        rateSpinner.setAdapter(adapter);
    }

        /*rateSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currencyToConvert = rateSpinner.getSelectedItem().toString(); //get selected item from drop down

                Intent intent = new Intent(SelectRatesActivity.this, MainActivity.class);
                intent.putExtra(Intent.EXTRA_TEXT, currencyToConvert);
                startActivity(intent);
            }
        });
    }*/
}