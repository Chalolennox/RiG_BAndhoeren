package com.mycompany.rigbandhoeren.rigAPI;

/**
 * Created by Lennox on 12/06/2015.
 */
public class NoUserException extends RiGException {
    public NoUserException(Exception e) {
        super(e);
    }

    public NoUserException() {
        super();
    }
}
