package com.example.anonymous.caffeinetrackeriii;

/**
 * Created by ANONYMOUS on 02-Sep-17.
 */

public class Amount {

    private float amount;
    private int sync_status;

    //creating a constructor method for amount class:
    Amount(float amount, int sync_status){

        this.setAmount(amount);
        this.setSync_status(sync_status);

    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getSync_status() {
        return sync_status;
    }

    public void setSync_status(int sync_status) {
        this.sync_status = sync_status;
    }
}
