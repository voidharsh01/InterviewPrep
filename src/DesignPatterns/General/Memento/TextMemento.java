package DesignPatterns.General.Memento;

public class TextMemento {
    private String text;
    TextMemento(String text){
        this.text=text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
