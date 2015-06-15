package com.mycompany.rigbandhoeren.rigAPI;

/**
 * Created by Lennox on 12/06/2015.
 */
class BadBandException extends RiGException {
    public BadBandException(Exception e) {
        super(e);
    }

    public BadBandException() {
        super();
    }
}
