package com.blockchain;

public interface VwapCalculator {
    Quote calculate(CurrencyPair pair, Market market, Quote quote);
}