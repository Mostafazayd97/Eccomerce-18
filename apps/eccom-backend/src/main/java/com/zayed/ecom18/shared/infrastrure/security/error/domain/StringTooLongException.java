package com.zayed.ecom18.shared.infrastrure.security.error.domain;

public class StringTooLongException extends AssertionException {

    private final String maxLength;
    private final String currentLength;

    private StringTooLongException(StringTooLongExceptionBuilder builder) {
        super(builder.field, builder.message());
        maxLength = String.valueOf(builder.maxLength);
        currentLength = String.valueOf(builder.value.length());
    }
    public static StringTooLongExceptionBuilder builder() {
        return new StringTooLongExceptionBuilder();
      }

    @Override
    public AssertionErrorType type() {
        throw new UnsupportedOperationException("Unimplemented method 'type'");
    }

    @Override
    public String field() {
        throw new UnsupportedOperationException("Unimplemented method 'field'");
    }

    @Override
    public java.util.Map<String, String> parameters() {
        throw new UnsupportedOperationException("Unimplemented method 'parameters'");
    }


    static final class StringTooLongExceptionBuilder {

        private String value;
        private int maxLength;
        private String field;

        private StringTooLongExceptionBuilder() {
        }

        StringTooLongExceptionBuilder value(String value) {
            this.value = value;
            return this;
        }

        StringTooLongExceptionBuilder maxLength(int maxLength) {
            this.maxLength = maxLength;
            return this;
        }

        StringTooLongExceptionBuilder field(String field) {
            this.field = field;
            return this;
        }

        StringTooLongException build() {
            return new StringTooLongException(this);
        }

        private String message() {
            return "The value \"%s\" in field \"%s\" must be at most %d long but was %d".formatted(value, field, maxLength, value.length());
        }

    }

}
