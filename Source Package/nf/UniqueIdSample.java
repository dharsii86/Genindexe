package nf;

/**
 * Delivers a unique ID number for the samples.
 */
public class UniqueIdSample {
  private int number = 0;

  public int newNumber() {
	return ++number;
  }

}
