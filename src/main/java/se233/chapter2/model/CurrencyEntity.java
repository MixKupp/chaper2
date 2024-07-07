package se233.chapter2.model;

public class CurrencyEntity {
    private String date;
    private Double rate;

    public CurrencyEntity(Double rate, String date) {
        this.date = date;
        this.rate = rate;
    }

    public Double getRate() {
        return rate;
    }
    public String getTimestamp() {
        return date;
    }
    @Override
    public String toString() {
        return String.format("%s %.4f", date, rate);
    }
}
