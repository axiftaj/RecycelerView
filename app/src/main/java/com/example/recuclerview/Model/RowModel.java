package com.example.recuclerview.Model;

public class RowModel  {

    String name , message ;
    int image ;

    public RowModel(String name, String message, int image) {
        this.name = name;
        this.message = message;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
