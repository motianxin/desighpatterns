package com.design.patterns.creational.factorymethod;

public class HtmlDialog extends Dialog {
    public Button createButton() {
        return new HtmlButton();
    }
}
