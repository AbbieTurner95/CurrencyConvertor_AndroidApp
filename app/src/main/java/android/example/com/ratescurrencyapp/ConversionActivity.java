package android.example.com.ratescurrencyapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ConversionActivity extends AppCompatActivity {

    EditText topBaseAmount;
    TextView baseCurrencySymbols;
    EditText baseAmount;
    TextView toCurrencySymbol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);

        TextView currencyTitleTop = findViewById(R.id.tvCurrencyTitleTop);
        topBaseAmount = findViewById(R.id.etBaseAmount);
        baseCurrencySymbols = findViewById(R.id.tvBaseCurrencySymbol);
        TextView baseCurrencyShort = findViewById(R.id.baseCurrencyShort);

        FloatingActionButton fab = findViewById(R.id.fab);

        TextView currencyTitleBottom = findViewById(R.id.tvCurrencyTitleBottom);
        baseAmount = findViewById(R.id.etToAmount);
        toCurrencySymbol = findViewById(R.id.tvToCurrencySymbol);
        TextView bottomCurrencyShort = findViewById(R.id.bottomCurrencyShort);


        Intent intent = getIntent();
        final Rate rate = intent.getExtras().getParcelable(MainActivity.RATE_KEY);      //rate to convert with        //second chosen
        final String baseCurrency = intent.getStringExtra(MainActivity.CURRENCY_KEY);   //base currency first selected


        /* FIRST RATE SELECTED SETTINGS */
        currencyTitleTop.setText(baseCurrency);
        baseCurrencyShort.setText(baseCurrency);

        /*  SECOND RATE SELECTED SETTINGS  */
        String titleBottom = rate.getSymbol();
        currencyTitleBottom.setText(titleBottom);
        final double secondRateChosen = rate.getRate();
        bottomCurrencyShort.setText(String.format("Current Live Rate : %s", secondRateChosen));

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //if top edittext not null then do frombase
                // if bottom edittext not null then do to base
                //if both null do nothing
                //if both text then do from base

                double amount = Double.parseDouble(topBaseAmount.getText().toString());
                double convertedAmount = convertFromBase(amount,rate);
                baseAmount.setText(String.valueOf(convertedAmount));
            }
        });
    }

    private double convertFromBase(double amount, Rate rate) {
        return amount * rate.getRate();
    }

    private double convertToBase(double amount, Rate rate) {
        return amount * 1 / rate.getRate();
    }


}
