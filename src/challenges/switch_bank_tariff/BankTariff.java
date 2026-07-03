package challenges.switch_bank_tariff;

public class BankTariff {
    public static void main(String[] args) {
        String accountType = "BASIC";
        double transactionValue = 600.00;

        double fee = calculateFee(accountType, transactionValue);
        System.out.println("Fee U$: " + fee);
    }

    static double calculateFee(String accountType, double transactionValue) {
        return switch (accountType) {
            case "BASIC" -> {
                double fixedRate = 5.00;
                yield transactionValue > 500.00 ? fixedRate + (transactionValue * 0.02) : fixedRate;
            }
            case "PREMIUM" -> {
                double fixedRate = 2.00;
                yield transactionValue > 1000.00 ? fixedRate + (transactionValue * 0.01) : fixedRate;
            }
            case "BLACK" -> 0.00;
            default -> throw new IllegalArgumentException("Invalid account type");
        };
    }

}
