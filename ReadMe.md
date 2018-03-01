# Notes about the solution
### Assumptions
- I assumed that the only ```Quote calculate(CurrencyPair pair, Market market, Quote quote)``` method would make sense is if it actually updates some kind of exisitng storage and returns updated VWAP price for the currency pair the update was performed for. If I designed the interface I would actually prefer to split it in two (or rename)
- I assumed VwapCalculator would be called from a single-threaded environment
- Implemented in Java 8

I created a maven project for the convenience - to execute the test run ```mvn clean install test``` from the project folder

Just as a side not - the test description is missing the VWAP definition (*1. Volume Weighted Price (VWAP) is defined as the ...*)