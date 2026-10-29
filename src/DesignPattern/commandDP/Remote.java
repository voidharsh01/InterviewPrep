package DesignPattern.commandDP;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Remote {

    List<RemoteCommand> commands;
    Map<Integer,RemoteCommand> buttons;

    Remote(List<RemoteCommand> rm){
        this.commands=rm;
        this.buttons=new HashMap<>();
        for(int i=0;i<rm.size();i++){
            buttons.put(i,  commands.get(i));
        }
    }

    void press(int buttonNumber){

        (buttons.get(buttonNumber)).execute();
    }

}
