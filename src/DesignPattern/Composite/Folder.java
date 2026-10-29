package DesignPattern.Composite;

import java.util.ArrayList;
import java.util.List;

public class Folder extends FileSystemNode{




    private List<FileSystemNode> children;

    public Folder(String name, FileSystemNode parent) {
        super(name, parent);
        children=new ArrayList<>();
    }

    public void addChildren(FileSystemNode element){
        this.children.add(element);

    }

    public Double getSize(){

        Double total=0.0d;
        for(FileSystemNode element:children)
            total+= element.getSize();

        return total;
    }


}
