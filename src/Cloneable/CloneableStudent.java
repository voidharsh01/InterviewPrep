package Cloneable;

public class CloneableStudent implements Cloneable{
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    private Integer age;
    private String name;
    private Address address;
    public CloneableStudent clone() throws CloneNotSupportedException {
       CloneableStudent student= (CloneableStudent)super.clone();
       student.setAddress(student.getAddress().clone());
       return student;

    }

}
