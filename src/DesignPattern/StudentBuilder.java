package DesignPattern;

public class StudentBuilder {

    private String name;
    private String rollNo;
    private String address;


    public StudentBuilder name(String name){
        this.name=name;
        return this;
    }
    public StudentBuilder rollNo(String rollNo){
        this.rollNo=rollNo;
        return this;
    }
    public StudentBuilder address(String address){
        this.address=address;
        return this;
    }
    public Student build(){
        Student student=new Student();
        student.setName(this.name);
        student.setRollNo(this.rollNo);
        student.setAddress(this.address);
        return student;
    }

}
