package com.mycompany.rigbandhoeren.rigAPI;

/**
 * Created by Lennox on 12/06/2015.
 */
class BadIDException extends RiGException {
    public BadIDException(Exception e) {
        super(e);
    }

    public BadIDException() {
    }
}
