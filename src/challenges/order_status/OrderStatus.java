package challenges.order_status;

public class OrderStatus {
    public static void main(String[] args) {
        String status = "SHIPPED";
        String destiny = "NORTH";

        System.out.println(resolveOrderStatus(status, destiny));
    }

    static String resolveOrderStatus(String status, String destiny) {
        int days = 0;
        return switch (status) {
            case "PENDING" -> {
                days = 1;
                yield ("Awaiting payment confirmation. Delivery time of: " + days + " day");
            }
            case "CONFIRMED" -> {
                days = 3;
                yield ("Order confirmed, preparing for shipment. Delivery time of: " + days + " days");
            }
            case "SHIPPED" -> {
                days = destiny.equals("NORTH") || destiny.equals("NORTHEAST") ? 10 : 5;
                yield ("Order shipped. Delivery time of: " + days + " days");
            }
            case "DELIVERED" -> "Order delivered successfully. Delivery time of: 0 days";
            case "CANCELLED" -> "Order cancelled. Delivery time of: 0 days";

            default -> throw new IllegalArgumentException("Invalid status: " + status);
        };
    }
}
