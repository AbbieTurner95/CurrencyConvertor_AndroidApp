package android.example.com.ratescurrencyapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ConversionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);

        TextView currncyTitleTop = findViewById(R.id.tvCurrencyTitleTop);
        EditText BaseAmount = findViewById(R.id.etBaseAmount);
        TextView BaseCurrencySymbols = findViewById(R.id.tvBaseCurrencySymbol);
        TextView BaseCurrencyShort = findViewById(R.id.baseCurrencyShort);
        EditText ToAmount = findViewById(R.id.etToAmount);
        TextView toCurrencySymbol = findViewById(R.id.tvToCurrencySymbol);
        TextView currencyTitleBottom = findViewById(R.id.tvCurrencyTitleBottom);

        FloatingActionButton fab = findViewById(R.id.fab);


        Intent intent = getIntent();
        final Rate rate = intent.getExtras().getParcelable(MainActivity.RATE_KEY);  //rate to convert with
        final String baseCurrency = intent.getStringExtra(MainActivity.CURRENCY_KEY); //base currency first selected

        //double amount = Double.parseDouble(input_amount.getText().toString());
    }

    private double convertFromBase(double amount, Rate rate) {
        return amount * rate.getRate();
    }

    private double convertToBase(double amount, Rate rate) {
        return amount * 1 / rate.getRate();
    }

}
