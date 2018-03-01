package com.blockchain;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class MarketQuotes {
    private Map<Market, Map<CurrencyPair, Quote>> marketQuotes;

    public MarketQuotes() {
        this.marketQuotes = new HashMap<Market, Map<CurrencyPair, Quote>>();
    }

    public void put(Market market, CurrencyPair currencyPair, Quote quote) {
        Map<CurrencyPair, Quote> currencyPairQuotes = marketQuotes.get(market);
        if(currencyPairQuotes == null)
            currencyPairQuotes = new HashMap<CurrencyPair, Quote>();
        currencyPairQuotes.put(currencyPair, quote);
        marketQuotes.put(market, currencyPairQuotes);
    }


    public Optional<Quote> get(Market market, CurrencyPair currencyPair) {
        if(marketQuotes.containsKey(market))//here I am assuming that every market has all currency pairs
            return Optional.of(marketQuotes.get(market).get(currencyPair));
        return Optional.empty();
    }

    public Set<Market> availableMarkets(){
        return marketQuotes.keySet();
    }
}
