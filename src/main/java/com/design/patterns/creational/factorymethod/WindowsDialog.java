package com.design.patterns.creational.factorymethod;

public class WindowsDialog extends Dialog {
    public Button createButton() {
        return new WindowsButton();
    }
}
