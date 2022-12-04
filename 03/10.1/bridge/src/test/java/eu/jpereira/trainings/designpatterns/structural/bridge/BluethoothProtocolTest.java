package eu.jpereira.trainings.designpatterns.structural.bridge;

import eu.jpereira.trainings.designpatterns.structural.bridge.protocol.BluetoothProtocol;
import eu.jpereira.trainings.designpatterns.structural.bridge.protocol.ExtendedProtocolSelector;
import eu.jpereira.trainings.designpatterns.structural.bridge.protocol.Protocol;
import eu.jpereira.trainings.designpatterns.structural.bridge.protocol.ProtocolSelector;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BluethoothProtocolTest extends ProtocolTest {

    @Override
    protected Protocol createProtocolUnderTest() {
        return new BluetoothProtocol();
    }
}
