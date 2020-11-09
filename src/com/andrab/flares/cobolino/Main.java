package com.andrab.flares.cobolino;

import java.io.PrintStream;

class CliApp {
    private ForCalculatingPrices hex;

    public CliApp(ForCalculatingPrices hex) {
        this.hex = hex;
    }

    public void iniciar(String... args) {
        this.args = args;
        parsear();
    }

    private void decir(String str) {
        stream.println(str);
    }

    public void setOut(PrintStream out) {
        stream = out;
    }

    private void parsear() {
        String reporte = "";

        while (hayMas()) {
            if (donde == 1) {
                String functionName = args[donde];

                if (functionName.equals("echoValue")) {
                    int precio = Integer.parseInt(args[++donde]);
                    reporte = String.format("El precio es %.2f dólares", (float) hex.echoValue(precio));
                } else if (functionName.equals("getTaxRateForState")) {
                    String state = args[++donde];
                    reporte = String.format("La tasa de impuesto es %.2f por ciento.", hex.getTaxRateForState(state));
                } else if (functionName.equals("calculatePriceWithTax")) {
                    int precio = Integer.parseInt(args[++donde]);
                    String state = args[++donde];
                    reporte = String.format("El precio con la tasa de impuesto es %.2f dólares", hex.calculatePriceWithTax(precio, state));
                }
            }

            donde++;
        }

        decir(reporte);
    }

    private boolean hayMas() {
        if (args.length <= donde)
            return false;
        if (donde >= args.length)
            return false;
        return true;
    }

    private static PrintStream stream = System.out;

    private String[] args;
    private int donde = 1;
}

public class Main {
    public static void main(String... args) {
        PriceMaker hex = new PriceMaker();
        hex.setTaxStore(new InMemoryTaxStore());

        CliApp ui = new CliApp(hex);
        ui.iniciar(args);
    }
}
