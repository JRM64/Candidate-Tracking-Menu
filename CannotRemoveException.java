//creating the exception for non-removable objects
class CannotRemoveException extends Exception
 {
	public CannotRemoveException(String error)
    {
		System.out.println("CannotRemoveException Thrown");
	}
}