package android.example.com.ratescurrencyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ConversionActivity extends AppCompatActivity {

    EditText input_amount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);

        Intent intent = getIntent();

        TextView show_conversion = findViewById(R.id.rates_text);
        input_amount = findViewById(R.id.rate_input);
        Button convertButton = findViewById(R.id.convert_button);

        input_amount.getText().toString();

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                input_amount.getText().toString();



            }
        });
    }



}
