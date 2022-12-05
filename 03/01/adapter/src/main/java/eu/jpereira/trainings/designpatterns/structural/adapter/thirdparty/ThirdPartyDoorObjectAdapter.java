package eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty;

import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.CodeMismatchException;
import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.IncorrectDoorCodeException;
import eu.jpereira.trainings.designpatterns.structural.adapter.model.Door;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeCodeForUnlockedDoor;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeStateOfLockedDoor;

import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.ThirdPartyDoor.DoorState;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.ThirdPartyDoor.LockStatus;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotUnlockDoorException;

import java.util.Objects;

public class ThirdPartyDoorObjectAdapter implements Door{
    ThirdPartyDoor thirdPartyDoor = new ThirdPartyDoor();


    @Override
    public void open(String code) throws IncorrectDoorCodeException, CannotChangeStateOfLockedDoor {
        if (!isOpen()) {
            try {
                this.thirdPartyDoor.unlock(code);
                if (thirdPartyDoor.getLockStatus().equals(LockStatus.UNLOCKED)) {
                    this.thirdPartyDoor.setState(DoorState.OPEN);
                }

            } catch (CannotUnlockDoorException e) {
                throw new IncorrectDoorCodeException();
            } catch (CannotChangeStateOfLockedDoor e) {
                throw new IncorrectDoorCodeException();
            }
        }
    }

    @Override
    public void close() throws CannotChangeStateOfLockedDoor {
        try {
            if (isOpen()) {
                this.thirdPartyDoor.setState(DoorState.CLOSED);
            }
        } catch (CannotChangeStateOfLockedDoor e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isOpen() {
        return ThirdPartyDoor.DoorState.OPEN == thirdPartyDoor.getState();
    }

    @Override
    public void changeCode(String oldCode, String newCode, String newCodeConfirmation) throws IncorrectDoorCodeException, CodeMismatchException, CannotChangeCodeForUnlockedDoor {
        try {
            if (this.thirdPartyDoor.getLockStatus().equals(LockStatus.LOCKED)) {
                this.thirdPartyDoor.unlock(oldCode);
            }
            if (!newCode.equals(newCodeConfirmation)) {
                this.thirdPartyDoor.lock();
            }
            this.thirdPartyDoor.setNewLockCode(newCode);
        } catch (CannotChangeCodeForUnlockedDoor e) {
            throw new CodeMismatchException();
        } catch (CannotUnlockDoorException e) {
            throw new IncorrectDoorCodeException();
        }
    }

    @Override
    public boolean testCode(String code) {
        return Objects.equals(code, this.thirdPartyDoor.code);
    }
}
