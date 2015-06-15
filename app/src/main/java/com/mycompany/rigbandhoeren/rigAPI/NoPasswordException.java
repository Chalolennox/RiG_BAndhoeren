package com.mycompany.rigbandhoeren.rigAPI;

/**
 * Created by Lennox on 12/06/2015.
 */
public class NoPasswordException extends RiGException {
    public NoPasswordException(Exception e) {
        super(e);
    }

    public NoPasswordException() {
    }
}
