package eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty;

import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.CodeMismatchException;
import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.IncorrectDoorCodeException;
import eu.jpereira.trainings.designpatterns.structural.adapter.model.Door;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeCodeForUnlockedDoor;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeStateOfLockedDoor;

import java.util.Objects;

public class ThirdPartyDoorAdaper extends ThirdPartyDoor implements Door{


    @Override
    public void open(String code) throws IncorrectDoorCodeException, CannotChangeStateOfLockedDoor {
        // try the code
        if (Objects.equals(code, this.code)) {
            this.setState(DoorState.OPEN);
        } else {
            throw new IncorrectDoorCodeException();
        }

    }

    @Override
    public void close() throws CannotChangeStateOfLockedDoor {
        this.setState(DoorState.CLOSED);
    }

    @Override
    public boolean isOpen() {
        return this.getState() == DoorState.OPEN;
    }

    @Override
    public void changeCode(String oldCode, String newCode, String newCodeConfirmation) throws IncorrectDoorCodeException, CodeMismatchException, CannotChangeCodeForUnlockedDoor {
        if (newCode.equals(newCodeConfirmation)) {
            if (oldCode.equals(this.code)) {
               this.setNewLockCode(newCode);
            } else {
                throw new IncorrectDoorCodeException();
            }
        } else {
            throw new CodeMismatchException();
        }
    }

    @Override
    public boolean testCode(String code) {
        return Objects.equals(code, this.code);
    }
}
