package models;

public class Order {
    private String orderNumber;

    private int orderQuantity;

    public void OrderDetails(){
        System.out.println(orderNumber + " numaralı siparişinizin, Sipariş sayısı : "+ orderQuantity);
    }


    public Order(String orderNumber, int orderQuantity) {
        this.orderNumber = orderNumber;
        this.orderQuantity = orderQuantity;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }
}
