package Reflections;

import java.lang.reflect.Field;

public class Driver2 {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {


        Class<?> c=StudentForReflection.class;
        StudentForReflection obj=new StudentForReflection();
        Field f=c.getDeclaredField("name");
        f.setAccessible(true);
        f.set(obj,"Harsh");
        System.out.println(f.get(obj));

    }
}
