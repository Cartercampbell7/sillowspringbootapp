package com.gcu.model;


// Class to model a real estate property
public class PropertyModel 
{
    String nameOfProperty = "";
    String location = "";
    int squareFeet = 0;
    String photoFileName = "";
    String description = "";
    double value = 0;
    String dateOfConstruction;

    public PropertyModel(String nameOfProperty, String location, int squareFeet, String photoFileName,
            String description, double value, String dateOfConstruction) {
        this.nameOfProperty = nameOfProperty;
        this.location = location;
        this.squareFeet = squareFeet;
        this.photoFileName = photoFileName;
        this.description = description;
        this.value = value;
        this.dateOfConstruction = dateOfConstruction;
    }

    public PropertyModel()
    {
        super();
    }

    @Override
    public String toString() {
        return "PropertyModel [nameOfProperty=" + nameOfProperty + ", location=" + location + ", squareFeet="
                + squareFeet + ", photoFileName=" + photoFileName + ", description=" + description + ", value=" + value
                + ", dateOfConstruction=" + dateOfConstruction + "]";
    }
    
    public String getNameOfProperty() {
        return nameOfProperty;
    }
    public void setNameOfProperty(String nameOfProperty) {
        this.nameOfProperty = nameOfProperty;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public int getSquareFeet() {
        return squareFeet;
    }
    public void setSquareFeet(int squareFeet) {
        this.squareFeet = squareFeet;
    }
    public String getPhotoFileName() {
        return photoFileName;
    }
    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }
    public String getDateOfConstruction() {
        return dateOfConstruction;
    }
    public void setDateOfConstruction(String dateOfConstruction) {
        this.dateOfConstruction = dateOfConstruction;
    }

    
}
