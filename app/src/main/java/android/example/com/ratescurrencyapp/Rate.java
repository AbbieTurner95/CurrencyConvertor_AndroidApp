package android.example.com.ratescurrencyapp;

/**
 * Created by Abbie on 19/01/2018.
 */

public class Rate {
    private String symbol;
    private double rate;

    public Rate(){
    }

    public Rate(String symbol, double rate){
        this.symbol = symbol;
        this.rate = rate;
    }

    public String getSymbol(){
        return symbol;
    }

    public double getRate(){
        return rate;
    }
}
