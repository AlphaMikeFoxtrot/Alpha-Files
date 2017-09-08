package com.example.anonymous.sqllite;

/**
 * Created by ANONYMOUS on 04-Sep-17.
 */

public class Amount {

    private int _id;
    private int amount;

    public Amount(){

    }

    public Amount(int amount) {
        this.amount = amount;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
