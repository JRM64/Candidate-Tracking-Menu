/**
 * @author Jack Mitchell
 */

public abstract class Element {

	// Access method

	/**
	 * The getClassName method returns the name of the calling object's class.
	 * 
	 * @return the name of the calling object's class
	 */

	public String getClassName() {
		// Local data ...
		String resultStr;
		// Result of applying toString method to
		// the calling object
		int whereAt; // Where the @ symbol is in resultStr

		// Logic ...
		resultStr = this.toString();
		whereAt = resultStr.indexOf('@');
		resultStr = resultStr.substring(0, whereAt);
		whereAt = resultStr.indexOf('.');
		return resultStr.substring(whereAt + 1);
	}

	// Abstract methods readIn, display, equals and clone.
	// A direct subclass must implement these abstract methods
	// unless the direct subclass is itself declared "abstract"

	public abstract void readIn();

	public abstract void display();

	public abstract boolean equals(Element dobj);

	public abstract Element clone();
}
