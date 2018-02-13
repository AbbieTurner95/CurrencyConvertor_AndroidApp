package android.example.com.ratescurrencyapp;

import java.util.ArrayList;

public class Currency {
    private String base;
    private String date;
    private ArrayList<Rate> rates;

    public Currency(){}

    public Currency(String base, String date){
        this.base = base;
        this.date = date;
        this.rates = new ArrayList<>();
    }

    public String getBase(){
        return base;
    }

    public String getDate(){
        return date;
    }

    public ArrayList<Rate> getRates(){
        return rates;
    }

    public void addRate(Rate rate){
        this.rates.add(rate);
    }
}
