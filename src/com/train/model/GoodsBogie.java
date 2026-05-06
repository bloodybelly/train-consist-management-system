package com.train.model;

public class GoodsBogie {

    private final int id;
    private final String shape;   // e.g., CYLINDRICAL, RECTANGULAR
    private final String cargo;   // e.g., PETROLEUM, COAL

    public GoodsBogie(int id, String shape, String cargo) {
        this.id = id;
        this.shape = shape;
        this.cargo = cargo;
    }

    public int getId() {
        return id;
    }

    public String getShape() {
        return shape;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return "Bogie{" + id + ", " + shape + ", " + cargo + "}";
    }
}