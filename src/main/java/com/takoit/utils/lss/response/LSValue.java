package com.takoit.utils.lss.response;

public class LSValue {
    public LSValue(){

    }
    public LSValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private String value;
}
