//creating the exception for objects that were already added into the list
class DuplicateObjectException extends Exception
 {
	public DuplicateObjectException(String error)
    {
		System.out.println("Its already in the set");
	}
}

