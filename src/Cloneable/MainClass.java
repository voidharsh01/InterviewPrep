package Cloneable;

public class MainClass {

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneableStudent student1=new CloneableStudent();
        student1.setAddress(new Address());
        CloneableStudent student2=student1.clone();
        System.out.println(student1.getAddress()==student2.getAddress());
    }
}
