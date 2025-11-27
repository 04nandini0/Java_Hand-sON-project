import java.util.Scanner;

class Currency {
    private String name;
    private double rateToUSD;

    public Currency(String name, double rateToUSD) {
        this.name = name;
        this.rateToUSD = rateToUSD;
    }

    public String getName() {
        return name;
    }

    public double getRateToUSD() {
        return rateToUSD;
    }

    public double convertTo(Currency targetCurrency, double amount) {
        double amountInUSD = amount / this.rateToUSD;
        return amountInUSD * targetCurrency.getRateToUSD();
    }
}

class USD extends Currency {
    public USD() {
        super("USD", 1.0);
    }
}

class EUR extends Currency {
    public EUR() {
        super("EUR", 0.92);
    }
}

class INR extends Currency {
    public INR() {
        super("INR", 83.10);
    }
}

class GBP extends Currency {
    public GBP() {
        super("GBP", 0.78);
    }
}

public class SimpleCurrencyConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        USD usd = new USD();
        EUR eur = new EUR();
        INR inr = new INR();
        GBP gbp = new GBP();

        System.out.println("=== SIMPLE CURRENCY CONVERTER ===");
        System.out.println("Supported Currencies: USD, EUR, INR, GBP");
        System.out.print("Enter source currency (USD/EUR/INR/GBP): ");
        String from = sc.next().toUpperCase();

        System.out.print("Enter target currency (USD/EUR/INR/GBP): ");
        String to = sc.next().toUpperCase();

        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();

        Currency fromCurrency = null;
        Currency toCurrency = null;

        if (from.equals("USD")) fromCurrency = usd;
        else if (from.equals("EUR")) fromCurrency = eur;
        else if (from.equals("INR")) fromCurrency = inr;
        else if (from.equals("GBP")) fromCurrency = gbp;

        if (to.equals("USD")) toCurrency = usd;
        else if (to.equals("EUR")) toCurrency = eur;
        else if (to.equals("INR")) toCurrency = inr;
        else if (to.equals("GBP")) toCurrency = gbp;

        if (fromCurrency == null || toCurrency == null) {
            System.out.println("Invalid currency code entered!");
        } else {
            double result = fromCurrency.convertTo(toCurrency, amount);
            System.out.printf("%.2f %s = %.2f %s\n", amount, fromCurrency.getName(), result, toCurrency.getName());
        }

        sc.close();
    }
}
