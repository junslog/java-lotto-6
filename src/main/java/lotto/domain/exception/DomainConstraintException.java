package lotto.domain.exception;

public class DomainConstraintException extends IllegalArgumentException {
    private DomainConstraintException(String message) {
        super(message);
    }

    public static DomainConstraintException of(String message) {
        return new DomainConstraintException(message);
    }
}