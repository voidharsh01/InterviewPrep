package DesignPattern.commandDP;

import java.util.ArrayList;
import java.util.List;

public class MainR {

    public static void main(String[] args) {

        ACOnCommand acOnCommand=new ACOnCommand(new AC());
        List<RemoteCommand> commandList=new ArrayList();

        commandList.add(acOnCommand);
        Remote remote=new Remote(commandList);

        remote.press(1);
    }
}
