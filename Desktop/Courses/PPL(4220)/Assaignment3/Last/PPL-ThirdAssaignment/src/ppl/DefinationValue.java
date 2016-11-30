/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppl;

/**
 *
 * @author sazizian
 */
public class DefinationValue {
    private String item;
    private String value;
    private boolean state;

    public DefinationValue(String item, String value) {
        this.item = item;
        this.value = value;
    }

    public DefinationValue(String item, String value, boolean state) {
        this.item = item;
        this.value = value;
        this.state = state;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
    

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    
}
