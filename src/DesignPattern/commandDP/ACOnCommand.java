package DesignPattern.commandDP;

public class ACOnCommand implements RemoteCommand {

    private AC ac;
    ACOnCommand(AC ac){
        this.ac=ac;

    }
    public void execute(){
        ac.on();
    }
    void undo(){
        ac.off();
    }


}
