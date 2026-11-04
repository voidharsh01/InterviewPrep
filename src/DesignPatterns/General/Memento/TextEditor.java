package DesignPatterns.General.Memento;

public class TextEditor {



    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    TextEditor(String text){
        this.text=text;
    }
    public TextMemento save(){

        return new TextMemento(this.text);
    }

    public void restore(TextMemento textMemento){
        this.text=textMemento.getText();
    }
}
