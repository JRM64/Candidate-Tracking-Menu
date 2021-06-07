//creating the exception for non-retrievable objects
 class CannotRetrieveException extends Exception
 {
	public CannotRetrieveException(String error)
    {
		System.out.println("CannotRetrieveException thrown");
	}
}