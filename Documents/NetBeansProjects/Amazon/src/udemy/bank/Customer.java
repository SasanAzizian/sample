/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package udemy.bank;

import java.util.ArrayList;

/**
 *
 * @author sazizian
 */
public class Customer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name, double transactions) {
        this.name = name;       
        this.transactions=new ArrayList<>();
        addTransaction(transactions);
    }
    
    public void addTransaction(double amount){
        this.transactions.add(amount);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }
    
    
    
    
}
