/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package udemy.mobile;

import java.util.ArrayList;

/**
 *
 * @author sazizian
 */
public class MobilePhone {
    
    private String myNumber;
    private ArrayList<Contact> mycontants;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.mycontants=new ArrayList<>();
    }
    
    public boolean addNewContact(Contact contact){
        if(findContact(contact.getName())>=0){
            System.out.println("Contact is already on file");
            return false;
        }
        mycontants.add(contact);
        return true;
    }
    
    private int findContact(Contact contact){
        return mycontants.indexOf(contact);
    }
    
    private int findContact(String contactName){
        for(int i=0 ;i<this.mycontants.size();++i){
            Contact contact=this.mycontants.get(i);
            if(contact.getName().equals(contactName)){
                return i;
            }
        }
        return -1;
    }
    
    public boolean updateContact(Contact oldContact, Contact newContact){
        int foundposition=findContact(oldContact);
        if(foundposition<0){
            System.out.println(oldContact.getName()+", was not found");
            return false;
        }
        this.mycontants.set(foundposition, newContact);
        System.out.println(oldContact.getName()+", was replace with "+newContact.getName());
        return true;
    }
    
}
