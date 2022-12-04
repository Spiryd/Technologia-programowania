package eu.jpereira.trainings.designpatterns.structural.bridge.protocol;

public class BluetoothProtocol extends Protocol{

    @Override
    public void startSession() {
        super.setSessionActive(true);
    }

    @Override
    public void endSession() {
        super.setSessionActive(false);
    }
}
