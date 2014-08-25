package com.infintetech.hossam.tipcalc;

/**
 * Created by Hossam on 8/25/2014.
 */
public class Operations {

    double bill ;
    int percent ;

    public Operations(double bill, int percent) {
        this.bill = bill ;
        this.percent =  percent ;
    }

    protected double calculateBill(){
        double result = bill * (percent/100.0) ;
        return result ;
    }
}
