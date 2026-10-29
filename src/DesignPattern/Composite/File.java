package DesignPattern.Composite;

import java.util.List;

public class File extends FileSystemNode{

    public File(String name, FileSystemNode parent,Double size) {
        super(name, parent);
        this.size=size;
    }
    private Double size;

    public Double getSize() {
        return this.getSize();
    }

}
