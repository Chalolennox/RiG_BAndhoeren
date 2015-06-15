package com.mycompany.rigbandhoeren.rigAPI;

/**
 * Created by Lennox on 05/06/2015.
 */
public class RiGException  extends Exception {
    public RiGException(Exception e) {
        super(e);
    }
    public RiGException() {

    }
}
class RoundCompletedException extends RiGException {
    public RoundCompletedException(Exception e) {
        super(e);

    }

    public RoundCompletedException() {
        super();
    }
}

class BandNonexistentException extends RiGException {
    public BandNonexistentException(Exception e) {
        super(e);
    }

    public BandNonexistentException() {
        super();
    }
}

class GroupOnlyException extends RiGException {
    public GroupOnlyException(Exception e) {
        super(e);
    }

    public GroupOnlyException() {
        super();
    }
}

class httpPostException extends RiGException {
    httpPostException(Exception e) {
        super(e);
    }
}

class rigGetBandException extends RiGException {
    rigGetBandException(Exception e) {
        super(e);
    }
}

class MissingDayException extends RiGException {
    public MissingDayException(Exception e) {
        super(e);
    }

    public MissingDayException() {
    }
}

class BadDayException extends RiGException {
    public BadDayException(Exception e) {
        super(e);
    }

    public BadDayException() {
    }
}

class MissingStringException extends RiGException {
    public MissingStringException(Exception e) {
        super(e);
    }

    public MissingStringException() {
    }
}

class MissingIDException extends RiGException {
    public MissingIDException(Exception e) {
        super(e);
    }

    public MissingIDException() {
    }
}

class MissingBandException extends RiGException {
    public MissingBandException(Exception e) {
        super(e);
    }

    public MissingBandException() {
    }
}

class MissingValueException extends RiGException {
    public MissingValueException(Exception e) {
        super(e);
    }

    public MissingValueException() {
    }
}

class NotInRoundException extends RiGException {
    public NotInRoundException(Exception e) {
        super(e);
    }

    public NotInRoundException() {
    }
}

class BadValueException extends RiGException {
    public BadValueException(Exception e) {
        super(e);
    }

    public BadValueException() {
    }
}

