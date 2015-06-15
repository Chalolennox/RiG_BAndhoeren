package com.mycompany.rigbandhoeren.rigAPI;

/**
 * Created by Lennox on 12/06/2015.
 */
public class BadAuthenticationException extends RiGException {
    public BadAuthenticationException(Exception e) {
        super(e);
    }

    public BadAuthenticationException() {
    }
}
