package com.andrab.flares.cobolino;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

class FileTaxStore implements ForGettingTaxRates {

    private Map<String, Double> states = new HashMap<String, Double>();

    FileTaxStore() {
        populateStateTaxRates();
    }

    public double taxRateForState(String state) {
        return states.get(state);
    }

    private void populateStateTaxRates() {
        String filePath = "src/res/taxRates.txt";

        Path path = FileSystems.getDefault().getPath(filePath);

        try {
            this.states = Files.lines(path).collect(
                    Collectors.toMap(line -> extractStateName(line), line -> extractStateTaxRate(line)));
        } catch (IOException _) {
            // Ignore exceptions, if any.
        }
    }

    private String extractStateName(String line) {
        return line.split(",")[0];
    }

    private Double extractStateTaxRate(String line) {
        return new Double(line.split(",")[1]);
    }

}
