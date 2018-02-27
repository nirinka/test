package com.blockchain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class VwapCalculatorImplTest {
    @Test
    public void calculateCorrectVwapPriceForEmptyMarket() throws Exception {
        VwapCalculator calculator = new VwapCalculatorImpl();
        Quote expectedQuotes = new QuoteImpl(1, 1, 2, 2);
        Quote testQuote = calculator.calculate(CurrencyPair.PAIR1, Market.MARKET1, expectedQuotes);
        assertEquals(testQuote, expectedQuotes);
    }

    @Test
    public void calculateCorrectVwapPriceForNonEmptyMarket() throws Exception {
        VwapCalculator calculator = new VwapCalculatorImpl();
        Quote quote1 = new QuoteImpl(1, 3, 2, 2);
        calculator.calculate(CurrencyPair.PAIR1, Market.MARKET1, quote1);
        Quote quote2 = new QuoteImpl(2, 1, 3, 3);
        Quote testQuote = calculator.calculate(CurrencyPair.PAIR1, Market.MARKET2, quote2);
        Quote expectedQuote = new QuoteImpl(1.25, 4, 2.6, 5);
        assertEquals(testQuote, expectedQuote);
    }

}