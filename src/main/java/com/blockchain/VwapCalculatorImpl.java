package com.blockchain;

public class VwapCalculatorImpl implements VwapCalculator {

    private MarketQuotes marketQuotes = new MarketQuotes();

    public Quote calculate(CurrencyPair pair, Market market, Quote quote) {
        marketQuotes.put(market, pair, quote);
        double accumulatedBid = 0;
        double accumulatedAsk = 0;
        double accumulatedBidSize = 0;
        double accumulatedAskSize = 0;
        for(Market currentMarket: marketQuotes.availableMarkets()){
            Quote currentQuote = marketQuotes.get(currentMarket, pair);
            accumulatedAsk += currentQuote.ask() * currentQuote.askSize();
            accumulatedAskSize += currentQuote.askSize();
            accumulatedBid += currentQuote.bid() * currentQuote.bidSize();
            accumulatedBidSize += currentQuote.bidSize();
        }
        return new QuoteImpl(accumulatedBid / accumulatedBidSize, accumulatedBidSize, accumulatedAsk / accumulatedAskSize, accumulatedAskSize);
    }
}
