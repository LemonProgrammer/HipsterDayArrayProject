package hipster.model;

/**
 * 
 * @author Fernando Blanco
 * @version 1.1 11/20/13 added getter/setters, overloaded constructor for additional hipsters, documentation comments.
 * 
 */
public class Hipster
{
	/**
	 * The name of the Hipster.
	 */
	private String name;
	/**
	 * The type of Hipster
	 */
	private String hipsterType;
	/**
	 * The phrase of the Hipster.
	 */
	private String hipsterPhrase;
	/**
	 * The collection of the Hipster's books.
	 */
	private String [] hipsterBooks;
	
	/**
	 * creates a default Hipster object with values based on me.
	 */
	public Hipster()
	{
		hipsterBooks = new String[5];
		name = "fernando";
		hipsterType = "Student Hipster";
		hipsterPhrase = "gee whiz";
		
		fillTheBooks();
		
	}
	
	/**
	 * Creates a Hipster object with the specified parameters to fill in the component data members.
	 * @param name The name of the created Hipster.
	 * @param hipsterType The type of the created hipster.
	 * @pram hipsterPhrase The cath-phrase of this created hipster.
	 * @pram hipsterBooks An array of books for the Hipster.
	 */
	public Hipster(String name, String hipsterType, String hipsterPhrase, String [] hipsterBooks)
	{
		this.name = name;
		this.hipsterBooks = hipsterBooks;
		this.hipsterPhrase = hipsterPhrase;
		this.hipsterType = hipsterType;
	}
	
	/**
	 * Getter method to get the name.
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Getter method to get the type.
	 * @return the hipsterType
	 */
	public String getHipsterType()
	{
		return hipsterType;
	}
	
/**
 	* Getter method to get the phrase.
 * @return the hipsterPhrase
*/
	public String getHipsterPhrase()
	{
		return hipsterPhrase;
	}
	
	/**
	 * Getter method to get the collection of books.
	 * @return the hipsterBooks
	 */
	public String[] getHipsterBooks()
	{
		return hipsterBooks;
	}
	
	/**
	 * Setter method to set the name
	 * @param name
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Setter method to set the type.
	 * @param hipsterType
	 */
	public void setHipsterType(String hipsterType)
	{
		this.hipsterType = hipsterType;
	}

	/**
	 * Setter method to set the phrase.
	 * @param hipsterPhrase
	 */
	public void setHipsterPhrase(String hipsterPhrase)
	{
		this.hipsterPhrase = hipsterPhrase;
	}

	/**
	 * Setter method to set the collection of books.
	 * @param hipsterBooks
	 */
	public void setHipsterBooks(String[] hipsterBooks)
	{
		this.hipsterBooks = hipsterBooks;
	}
	
	/**
	 * Helper method to fill the book array for the Hipster.
	 */
	private void fillTheBooks()
	{
		hipsterBooks[0] = "The anti-mainstream book";
		hipsterBooks[1] = "Oxford Dictionary";
		hipsterBooks[2] = "Beauty and the Beast";
		hipsterBooks[3] = "1984";
		hipsterBooks[4] = "Fahrenheit 451";
		
	}
}
