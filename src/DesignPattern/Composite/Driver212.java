package DesignPattern.Composite;

public class Driver212 {
    public static void main(String[] args) {
        Folder folder=new Folder("harsh",null);

        FileSystemNode file1=new File("t1.txt",folder,1.0);

        FileSystemNode subfolder=new Folder("sri",null);

        folder.addChildren(file1);
        folder.addChildren(subfolder);

        System.out.println(file1.getPath());
        System.out.println(folder.getPath());

    }
}
