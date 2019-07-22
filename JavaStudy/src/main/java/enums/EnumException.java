package enums;

/**
 * Created by wzp on 2017/2/24.
 */
public class EnumException extends RuntimeException {

  public EnumException() {
  }

  public EnumException(String message) {
    super(message);
  }

  public EnumException(Throwable cause) {
    super(cause);
  }

  public EnumException(String message, Throwable cause) {
    super(message, cause);
  }
}