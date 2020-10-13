package com.design.patterns.creational.abstractfactory;

public class WindowsButton implements Button {
    public void paint() {
        System.out.println("You have created WindowsButton.");
    }
}
