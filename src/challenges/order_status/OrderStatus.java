package challenges.order_status;

public class OrderStatus {
    public static void main(String[] args) {
        String status = "SHIPPED";
        String destiny = "NORTH";

        System.out.println(resolveOrderStatus(status, destiny));
    }

    static String resolveOrderStatus(String status, String destiny) {
        String message = resolveMessage(status);
        int days = resolveDays(status, destiny);

        String deliveryTime = days == 0 ? "No delivery time." : "Delivery time of: " + days + (days == 1 ? " day" : " days");

        return message + " " + deliveryTime;
    }

    static String resolveMessage(String status) {
        return switch (status) {
            case "PENDING" -> "Awaiting payment confirmation.";
            case "CONFIRMED" -> "Order confirmed, preparing for shipment.";
            case "SHIPPED" -> "Order shipped.";
            case "DELIVERED" -> "Order delivered successfully.";
            case "CANCELLED" -> "Order cancelled.";
            default -> throw new IllegalArgumentException("Invalid status " + status);
        };
    }

    static int resolveDays(String status, String destiny) {
        return switch (status) {
            case "PENDING" -> 1;
            case "CONFIRMED" -> 3;
            case "SHIPPED" -> destiny.equals("NORTH") || destiny.equals("NORTHEAST") ? 10 : 5;
            case "DELIVERED", "CANCELLED" -> 0;

            default -> throw new IllegalArgumentException("Invalid status " + status);
        };
    }
}
