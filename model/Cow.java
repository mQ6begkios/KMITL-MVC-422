package model;

public class Cow {
    private String id;
    private int ageYears;
    private int ageMonths;
    private int numUdders;

    public Cow(String id, int ageYears, int ageMonths, int numUdders) {
        this.id = id;
        this.ageYears = ageYears;
        this.ageMonths = ageMonths;
        this.numUdders = numUdders;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public int getAgeYears() {
        return ageYears;
    }

    public int getAgeMonths() {
        return ageMonths;
    }

    public int getNumUdders() {
        return numUdders;
    }

    public void setNumUdders(int numUdders) {
        this.numUdders = numUdders;
    }

    //milk production calculation
    public int calculateMilk() {
        return ageYears + ageMonths;
    }

    @Override
    public String toString() {
        return "Cow ID: " + id + ", Age: " + ageYears + " years " + ageMonths + " months, Udders: " + numUdders;
    }
}

