package eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty;

import eu.jpereira.trainings.designpatterns.structural.adapter.model.Door;

public class ThirdPartyDoorObjectAdapter implements Door{

    private ThirdPartyDoor thirdPartyDoor = new ThirdPartyDoor();

    public void open(String code) throws IncorrectDoorCodeException, CannotChangeStateOfLockedDoor{

    }

	public void close() throws CannotChangeStateOfLockedDoor{

    }


	public boolean isOpen(){
        return false;
    }


	public void changeCode(String oldCode, String newCode, String newCodeConfirmation) throws IncorrectDoorCodeException, CodeMismatchException, CannotChangeCodeForUnlockedDoor{

    }

	public boolean testCode(String code){
        return false;
    }
}
