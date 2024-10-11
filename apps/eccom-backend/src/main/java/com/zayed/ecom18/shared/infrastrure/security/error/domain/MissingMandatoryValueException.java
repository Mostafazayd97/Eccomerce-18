package com.zayed.ecom18.shared.infrastrure.security.error.domain;


public final class MissingMandatoryValueException extends AssertionException {

  private MissingMandatoryValueException(String field, String message) {
    super(field, message);
  }

  /**
   * Creates a new {@link MissingMandatoryValueException} for a blank value (e.g. an empty string).
   *
   * @param field the name of the field that is missing a mandatory value
   * @return a new {@link MissingMandatoryValueException}
   */
  public static MissingMandatoryValueException forBlankValue(String field) {
    return new MissingMandatoryValueException(field, defaultMessage(field, "blank"));
  }

  public static MissingMandatoryValueException forNullValue(String field) {
    return new MissingMandatoryValueException(field, defaultMessage(field, "null"));
  }

  public static MissingMandatoryValueException forEmptyValue(String field) {
    return new MissingMandatoryValueException(field, defaultMessage(field, "empty"));
  }

  public static MissingMandatoryValueException forBlankValueWithCustomMessage(String field, String message) {
    return new MissingMandatoryValueException(field, message);
  }

  public static MissingMandatoryValueException forNullValueWithCustomMessage(String field, String message) {
    return new MissingMandatoryValueException(field, message);
  }

  public static MissingMandatoryValueException forEmptyValueWithCustomMessage(String field, String message) {
    return new MissingMandatoryValueException(field, message);
  }

  private static String defaultMessage(String field, String reason) {
    return new StringBuilder()
      .append("The field \"")
      .append(field)
      .append("\" is mandatory and wasn't set")
      .append(" (")
      .append(reason)
      .append(")")
      .toString();
  }

  @Override
  public AssertionErrorType type() {
    return AssertionErrorType.MISSING_MANDATORY_VALUE;
  }
}
