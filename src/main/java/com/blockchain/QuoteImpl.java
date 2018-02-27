package com.blockchain;

public class QuoteImpl implements Quote {
    private double bid;
    private double ask;
    private double bidSize;
    private double askSize;

    public QuoteImpl(){
    }

    public QuoteImpl(double bid, double bidSize, double ask, double askSize){
        this.bid = bid;
        this.bidSize = bidSize;
        this.ask = ask;
        this.askSize = askSize;
    }

    public double bid() {
        return this.bid;
    }

    public double bidSize() {
        return this.bidSize;
    }

    public double ask() {
        return this.ask;
    }

    public double askSize() {
        return this.askSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuoteImpl quote = (QuoteImpl) o;

        if (Double.compare(quote.bid, bid) != 0) return false;
        if (Double.compare(quote.ask, ask) != 0) return false;
        if (Double.compare(quote.bidSize, bidSize) != 0) return false;
        return Double.compare(quote.askSize, askSize) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(bid);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(ask);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(bidSize);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(askSize);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
