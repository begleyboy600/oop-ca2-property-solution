package com.dkit.oop;

import java.util.Objects;

//********************************** SOLUTION ***************************************

public class PrivateProperty extends Property
{
    private int numBeds;
    private PropertyType propertyType;

    public PrivateProperty(String owner, String postcode, double sellingPrice, double area, int numBeds, PropertyType propertyType) {
        super(owner, postcode, sellingPrice, area);
        this.numBeds = numBeds;
        this.propertyType = propertyType;
    }

    @Override
    public String toString() {
        return "PrivateProperty{" +
                super.toString() +
                "numBeds=" + numBeds +
                ", propertyType=" + propertyType +
                '}';
    }

    public int getNumBeds() {
        return numBeds;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

// equals()
    // equals() is inherited from Property
    // comparison of two private properties depends only on two fields ID and owner
    // which is already provided by the Property equals() version
    // So, we add no code, and simply inherit the equals() from Property

    @Override
    public double calculateTax() {
        return  super.calculateTax() + numBeds * 25;  //
    }
}
