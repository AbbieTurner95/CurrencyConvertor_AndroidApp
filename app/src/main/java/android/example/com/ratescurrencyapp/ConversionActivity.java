package android.example.com.ratescurrencyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ConversionActivity extends AppCompatActivity {

    private EditText input_amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);

        Button convertButton = findViewById(R.id.convert_button);
        input_amount = findViewById(R.id.rate_input);

        TextView full_rate_name = findViewById(R.id.fullname_rate1);
        TextView full_rate_name2 = findViewById(R.id.fullname_rate2);
        TextView symbol_rate_1 = findViewById(R.id.symbol_1);
        TextView symbol_rate_2 = findViewById(R.id.symbol_2);
        TextView abbrv_rate1 = findViewById(R.id.rate_1);
        TextView abbrv_rate2 = findViewById(R.id.rate_2);
        TextView output_rate = findViewById(R.id.converted_amount);

        Intent intent = getIntent();
        final Rate rate = intent.getExtras().getParcelable(MainActivity.RATE_KEY);  //rate to convert with
        final String baseCurrency = intent.getStringExtra(MainActivity.CURRENCY_KEY); //base currency first selected

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double amount = Double.parseDouble(input_amount.getText().toString());
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
