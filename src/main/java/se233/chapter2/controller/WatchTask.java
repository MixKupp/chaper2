package se233.chapter2.controller;

import javafx.scene.control.Alert;
import se233.chapter2.Launcher;
import se233.chapter2.model.Currency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class WatchTask implements Callable<Void> {
    @Override
    public Void call() {
        List<Currency> allCurrencies = Launcher.getCurrencyList();
        String found = "";
        for (int i = 0; i < allCurrencies.size(); i++) {
            if (allCurrencies.get(i).getWatchRate() != 0 && allCurrencies.get(i).getWatchRate() > allCurrencies.get(i).getCurrency().getRate()) {
                if (found.equals("")) {
                    found = allCurrencies.get(i).getShortcode();
                } else {
                    found = found + " and " + allCurrencies.get(i).getShortcode();
                }
            }
        }
        if (!found.equals(" ")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle(null);
            alert.setHeaderText(null);
            if (found.length() > 3){
                alert.setContentText(String.format("%s have become lower than the watch rate!",found));
            }else {
                alert.setContentText(String.format("%s has become lower than the watch rate!",found));
                alert.showAndWait();
            }
            alert.showAndWait();
    }
        return null;
}
}
