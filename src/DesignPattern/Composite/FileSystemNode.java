package DesignPattern.Composite;

public abstract class FileSystemNode {
    abstract public Double getSize();






    public FileSystemNode(String name, FileSystemNode parent) {
        this.name = name;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FileSystemNode getParent() {
        return parent;
    }

    public void setParent(FileSystemNode parent) {
        this.parent = parent;
    }
    public String getPath(){

        if(this.getParent()==null)
            return this.getName();

        return this.getParent().getPath()+"/"+this.getName();
    }


    private String name;
    private FileSystemNode parent;




}
