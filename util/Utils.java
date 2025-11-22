package ua.util;

import java.text.DecimalFormat;

public class Utils {
    private static final DecimalFormat MONEY = new DecimalFormat("#0.00");

    public static String formatMoney(double amount) {
        return MONEY.format(amount);
    }

    public static String requireName(String s, String field) {
        return ValidationHelper.requireNonBlank(s, field);
    }

    public static double requirePositive(double v, String field) {
        return ValidationHelper.requirePositive(v, field);
    }

    public static double requireNonNegative(double v, String field) {
        return ValidationHelper.requireNonNegative(v, field);
    }

    private Utils() { }
}
