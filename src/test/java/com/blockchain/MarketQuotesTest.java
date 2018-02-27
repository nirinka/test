package com.blockchain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class MarketQuotesTest {

    @Test
    public void returnEmptyQuoteWhenMarketQuotesAreEmpty(){
        MarketQuotes marketQuotes = new MarketQuotes();
        assertEquals(marketQuotes.get(Market.MARKET1, CurrencyPair.PAIR2), new QuoteImpl());
    }

    @Test
    public void putNewQuote() throws Exception {
        MarketQuotes marketQuotes = new MarketQuotes();
        Quote testQuote = new QuoteImpl();
        marketQuotes.put(Market.MARKET1, CurrencyPair.PAIR1, testQuote);
        assertEquals(marketQuotes.get(Market.MARKET1, CurrencyPair.PAIR1), testQuote);
    }

    @Test
    public void updateExistingQuote() throws Exception {
        MarketQuotes marketQuotes = new MarketQuotes();
        Quote testQuote = new QuoteImpl(1, 1, 1, 1);
        marketQuotes.put(Market.MARKET1, CurrencyPair.PAIR1, testQuote);
        Quote updatedQuote = new QuoteImpl(1.5, 2, 1.7, 3);
        marketQuotes.put(Market.MARKET1, CurrencyPair.PAIR1, updatedQuote);
        assertEquals(marketQuotes.get(Market.MARKET1, CurrencyPair.PAIR1), updatedQuote);
    }

    @Test
    public void returnAvailableMarkets() throws Exception {
        MarketQuotes marketQuotes = new MarketQuotes();
        Quote testQuote = new QuoteImpl(1, 1, 1, 1);
        marketQuotes.put(Market.MARKET1, CurrencyPair.PAIR1, testQuote);
        marketQuotes.put(Market.MARKET2, CurrencyPair.PAIR1, testQuote);
        marketQuotes.put(Market.MARKET1, CurrencyPair.PAIR2, testQuote);
        Set<Market> marketSet = new HashSet<Market>();
        marketSet.add(Market.MARKET1);
        marketSet.add(Market.MARKET2);
        assertEquals(marketQuotes.availableMarkets(), marketSet);
    }

}