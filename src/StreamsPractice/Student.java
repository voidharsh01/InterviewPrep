package StreamsPractice;

import java.util.Iterator;
import java.util.Objects;

public class Student {


    public Integer id;
    public String name;

    Student(Integer i,String name){
        this.name=name;
        this.id=i;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Student student)) return false;
        return Objects.equals(id, student.id) && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
