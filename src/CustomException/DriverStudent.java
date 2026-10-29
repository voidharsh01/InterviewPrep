package CustomException;

public class DriverStudent {

    public static void main(String[] args) {
        Student student=new Student();
        try {
            if (student.name == null)
                throw new InvalidAgeException("Age not valid", 23);
        } catch (InvalidAgeException e) {
            System.out.println("ex");


        }
    }
}
