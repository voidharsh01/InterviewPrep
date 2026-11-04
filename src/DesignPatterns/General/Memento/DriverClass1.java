package DesignPatterns.General.Memento;

public class DriverClass1 {


    public static void main(String[] args) {

        TextEditor textEditor=new TextEditor("");

        textEditor.setText("Harsh2");
        TextMemento point1=textEditor.save();

        textEditor.setText("Harsh Srivastava");

        textEditor.setText("Harsh Srivastava");
        textEditor.restore(point1);
        System.out.println(textEditor.getText());


    }
}
