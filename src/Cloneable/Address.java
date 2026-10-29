package Cloneable;

import java.util.ArrayList;

public class Address implements Cloneable{
    String city;
    String state;

    @Override
    public Address clone() {
        try {
            Address clone = (Address) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();

        }
    }
}
