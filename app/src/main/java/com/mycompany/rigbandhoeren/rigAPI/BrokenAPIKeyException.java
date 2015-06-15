package com.mycompany.rigbandhoeren.rigAPI;

/**
 * Created by Lennox on 12/06/2015.
 */
public class BrokenAPIKeyException extends RiGException {
    public BrokenAPIKeyException(Exception e) {
        super(e);
    }

    public BrokenAPIKeyException() {
    }
}
