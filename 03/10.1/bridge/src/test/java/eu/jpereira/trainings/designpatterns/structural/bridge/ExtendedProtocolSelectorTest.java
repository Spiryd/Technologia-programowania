package eu.jpereira.trainings.designpatterns.structural.bridge;

import eu.jpereira.trainings.designpatterns.structural.bridge.protocol.ExtendedProtocolSelector;
import eu.jpereira.trainings.designpatterns.structural.bridge.protocol.ProtocolSelector;

public class ExtendedProtocolSelectorTest extends ProtocolSelectorTest{
    @Override
    protected int getProtocolCount() {
        return 4;
    }

    @Override
    protected ProtocolSelector createProtocolSelector() {
        return new ExtendedProtocolSelector();
    }
}
