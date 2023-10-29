package entities;

public class Car {
    private int chassisNumber;
    private String brand;
    private String color;
    private String type;
    private int yearOfProduction;
    private double unitPrice;


    public Car(){

    }

    public Car(int chassisNumber, String brand, String color, String type, int yearOfProduction, double unitPrice) {
        this.chassisNumber = chassisNumber;
        this.brand = brand;
        this.color = color;
        this.type = type;
        this.yearOfProduction = yearOfProduction;
        this.unitPrice=unitPrice;
    }

    public int getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(int chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
