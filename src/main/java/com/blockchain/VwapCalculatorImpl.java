package com.blockchain;

public class VwapCalculatorImpl implements VwapCalculator {

    private MarketQuotes marketQuotes = new MarketQuotes();

    private void updateMarket(CurrencyPair pair, Market market, Quote quote) {
        marketQuotes.put(market, pair, quote);
    }

    private Quote getVwap(CurrencyPair pair) {
        double accumulatedBid = 0;
        double accumulatedAsk = 0;
        double accumulatedBidSize = 0;
        double accumulatedAskSize = 0;
        for(Market currentMarket: marketQuotes.availableMarkets()){
            Quote currentQuote = marketQuotes.get(currentMarket, pair).orElse(new QuoteImpl());
            accumulatedAsk += currentQuote.ask() * currentQuote.askSize();
            accumulatedAskSize += currentQuote.askSize();
            accumulatedBid += currentQuote.bid() * currentQuote.bidSize();
            accumulatedBidSize += currentQuote.bidSize();
        }
        return new QuoteImpl(accumulatedBid / accumulatedBidSize, accumulatedBidSize, accumulatedAsk / accumulatedAskSize, accumulatedAskSize);

    }

    public Quote calculate(CurrencyPair pair, Market market, Quote quote) {
        updateMarket(pair, market, quote);
        return getVwap(pair);
    }
}
