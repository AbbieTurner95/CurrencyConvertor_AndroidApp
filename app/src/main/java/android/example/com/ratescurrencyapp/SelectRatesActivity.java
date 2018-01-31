package android.example.com.ratescurrencyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SelectRatesActivity extends AppCompatActivity {

    private Spinner rateSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_rates);

        rateSpinner = findViewById(R.id.rates_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.CurrencyRates, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rateSpinner.setAdapter(adapter);

        rateSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currencyToConvert = rateSpinner.getSelectedItem().toString(); //get selected item from drop down

                Intent intent = new Intent(SelectRatesActivity.this, MainActivity.class);
                intent.putExtra(Intent.EXTRA_TEXT, currencyToConvert);
                startActivity(intent);
            }
        });
    }
}