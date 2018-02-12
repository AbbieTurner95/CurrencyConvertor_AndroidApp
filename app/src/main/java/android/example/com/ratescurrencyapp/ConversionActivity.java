package android.example.com.ratescurrencyapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ConversionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);

        TextView currencyTitleTop = findViewById(R.id.tvCurrencyTitleTop);
        EditText baseAmount = findViewById(R.id.etBaseAmount);
        TextView baseCurrencySymbols = findViewById(R.id.tvBaseCurrencySymbol);
        TextView baseCurrencyShort = findViewById(R.id.baseCurrencyShort);

        TextView currencyTitleBottom = findViewById(R.id.tvCurrencyTitleBottom);    //USD
        EditText toAmount = findViewById(R.id.etToAmount);                          //edittext output
        TextView toCurrencySymbol = findViewById(R.id.tvToCurrencySymbol);          //$
        TextView bottomCurrencyShort = findViewById(R.id.bottomCurrencyShort);      //USD

        FloatingActionButton fab = findViewById(R.id.fab);

//TO-DO :
          //1. title top/bottom to selected rates
          //2. base/bottom short to selected rates
          //3  base symbol/tv to selected rates symbol
          //4. get top edit text input and convert with base rate
          //5. implement fab button to switch rates and divide (do really need if both edit text?


        Intent intent = getIntent();
        final Rate rate = intent.getExtras().getParcelable(MainActivity.RATE_KEY);  //rate to convert with              //second chosen
        final String baseCurrency = intent.getStringExtra(MainActivity.CURRENCY_KEY); //base currency first selected


        /*  SECOND RATE SELECTED SETTINGS  */
        String titleBottom = rate.getSymbol();    //USD
        currencyTitleBottom.setText(titleBottom); //USD
        double secondRateChosen = rate.getRate(); //1.383
        bottomCurrencyShort.setText("Current Rate : " + (int) secondRateChosen); //1.383


        //double amount = Double.parseDouble(input_amount.getText().toString());
    }

    private double convertFromBase(double amount, Rate rate) {
        return amount * rate.getRate();
    }

    private double convertToBase(double amount, Rate rate) {
        return amount * 1 / rate.getRate();
    }

}
