package DesignPattern;

public interface AtmMachineState {



    void insertCard(AtmMachine atmMachine);

    void dispenseCash(AtmMachine atmMachine);

    void cancel(AtmMachine atmMachine);
}
