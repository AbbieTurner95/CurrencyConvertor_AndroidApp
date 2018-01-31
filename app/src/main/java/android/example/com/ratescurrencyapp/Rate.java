package android.example.com.ratescurrencyapp;

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
