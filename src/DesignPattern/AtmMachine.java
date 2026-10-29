package DesignPattern;

public class AtmMachine {

    private AtmMachineState atmMachineState;

    private void insertCard(){
    atmMachineState.insertCard(this);
    }
    private void dispenseCash(){
        atmMachineState.dispenseCash(this);
    }


    private void cancel(){
        atmMachineState.cancel(this);
    }


}
