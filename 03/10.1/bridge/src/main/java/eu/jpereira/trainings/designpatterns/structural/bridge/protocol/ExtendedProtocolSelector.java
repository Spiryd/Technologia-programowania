package eu.jpereira.trainings.designpatterns.structural.bridge.protocol;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ExtendedProtocolSelector extends ProtocolSelector {
    @Override
    protected Collection<Protocol> createAditionalProtocols() {
        ArrayList<Protocol> extended = new ArrayList<Protocol>();
        extended.add(new BluetoothProtocol());
        return extended;
    }



}
