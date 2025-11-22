package ua.util;

class ValidationHelper {
    static String requireNonBlank(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " не може бути порожнім");
        }
        return value.trim();
    }

    static double requireNonNegative(double value, String fieldName) {
        if (value < 0) {
            throw new IllegalArgumentException(fieldName + " не може бути від’ємним");
        }
        return value;
    }

    static double requirePositive(double value, String fieldName) {
        if (value <= 0) {
            throw new IllegalArgumentException(fieldName + " має бути > 0");
        }
        return value;
    }

    private ValidationHelper() { }
}
