package edu.temple.tue80717.checkerboardapp;

/**
 * Created by kris on 9/29/15.
 */
public class Item {

    int columns;
    boolean black_square;

    public Item(int columns, boolean black_square) {
        super();
        this.columns = columns;
        this.black_square = black_square;
    }

    public int getColumns() {
        return columns;

    }

    public boolean getBlackSquare() {
        return black_square;
    }

    public void setColumns(int columns) {

        this.columns = columns;

    }
}
