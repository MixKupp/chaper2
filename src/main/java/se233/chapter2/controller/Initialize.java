package se233.chapter2.controller;

import se233.chapter2.model.Currency;
import se233.chapter2.model.CurrencyEntity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Initialize {
    public static List<Currency> initializeApp() throws IOException {
        Currency c = new Currency("USD");
        List<CurrencyEntity> cList = FetchData.fetchRange(c.getShortcode(), 8);
        c.setHistorical(cList);
        c.setCurrency(cList.get(cList.size() - 1));
        List<Currency> currencyList = new ArrayList<>();
        currencyList.add(c);
        return currencyList;
    }
}
