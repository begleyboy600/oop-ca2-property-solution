package com.dkit.oop;

import java.util.ArrayList;

/**
 * OOP - CA#2 - Nov 2020  ****************SOLUTION*********************
 * Your Name:
 * <p>
 * Your GitHub link:
 */
public class App
{
    public static void main(String[] args)
    {
        System.out.println("\n*** Property & Private Property- - App ***");
        App app = new App();
        app.start();
    }

    public void start()
    {
        System.out.println("Q1 - some simple tests");

    //    Property p1 = new Property(1, "Mary Smith", "A91AB12", 255000, 130);
        Property p1 = new Property( "Mary Smith", "A91AB12", 255000, 130);
        p1.addFacility("mains water");
        p1.addFacility("pool");
        p1.removeFacility("pool");

        System.out.println("Property p1 details:");
        System.out.println(p1.getPropertyID() + " : " + p1.getOwner() + " : " + p1.getPostcode() +  " : " + p1.getSellingPrice() + " : " + p1.getArea());

        Property p2 = new Property( "James Smith", "B91AB12", 440);
        System.out.println("Property p2 details:");
        System.out.println(p1.getPropertyID() + " : " + p2.getOwner() + " : " + p2.getPostcode() + " : " + p2.getSellingPrice() + " : " + p2.getArea());

        System.out.println("Q2 - tests");
        ArrayList<Property> list = new ArrayList<>();
        list.add(new Property( "Annie Smith", "A91AB12", 255000, 130));
        list.add(new Property( "Barry Smith", "B91AB12", 355000, 230));
        list.add(new Property( "Connie Smith", "C91AB12", 455000, 330));
        displayProperties(list);

        System.out.println("Q3 - tests");

        ArrayList<Property> above = getPropertiesPricedAbove(list,350_000);
        displayProperties(above);

        System.out.println("Q4 - tests");

        list.add(new PrivateProperty( "John Malone", "X91AB12", 644000, 530,5,PropertyType.DETACHED));
        list.add(new PrivateProperty( "Ronnie Wood", "XY91AB12", 355000, 230,2,PropertyType.APARTMENT));
        list.add(new PrivateProperty( "Reggie Berry", "XYZ91AB12", 422000, 230,4,PropertyType.SEMI_D));
        displayProperties(list);

        displayPropertyIdsAndPropertyTax(list); // Q4.b

        displayFieldsForDetachedProperties( list);
    }

    public void displayProperties( ArrayList<Property> list){
        for(Property p : list) {
            System.out.println( p.toString() );
        }
    }

    // This is an example of polymorphism and dynamic binding.
    // The reference 'p' can point at either a Property or a PrivateProperty
    // Both types implement the calculateTax() method in different ways,
    // so the version of the method called depends on the type of the object
    // (and not on the reference type).
    // We say the the method is dynamically bound (i.e. selected at run-time
    // based on the type of the object)
    public void displayPropertyIdsAndPropertyTax(ArrayList<Property> list) {
        for(Property p : list) {
            System.out.println( "Id = " + p.getPropertyID() +", Tax = " + p.calculateTax());
        }
    }

    // use of 'instanceof' to filter out a subclass type.
    // use of Cast to convert Property ref to a PrivateProperty reference type
    public void displayFieldsForDetachedProperties(ArrayList<Property> list) {
        System.out.println("Detached Properties details:");
        for(Property p : list) {
            if( p instanceof PrivateProperty ) {
                if ( ((PrivateProperty) p).getPropertyType() == PropertyType.DETACHED) {
                    System.out.println( "Id = " + p.getPropertyID() +", Selling = " +
                            p.getSellingPrice () + "Bedrooms = " + ((PrivateProperty) p).getNumBeds());
                }
            }
        }
    }

    public ArrayList<Property> getPropertiesPricedAbove( ArrayList<Property> list, double boundary) {
        ArrayList<Property> aboveBoundaryList = new ArrayList<>();
        for(Property p : list){
            if(p.getSellingPrice()>boundary) {
                aboveBoundaryList.add(p);
            }
        }
        return aboveBoundaryList;
    }


}

