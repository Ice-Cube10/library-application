package libraryBookCatalog;

import java.util.ArrayList;

public interface BookCatalogInterface {

	/**
	 * Loads book information from the file into
	 *  the catalog
	 * @param filename
	 */
	public void loadData(String filename);
	
	/**
	 * Displays all the books in the catalog
	 */
	public void displayCatalog();
	
	/**
	 * Searches for a book matching the provided title
	 *  and provides the information on the book if one
	 *  is found
	 * @param title
	 * @return
	 */
	public Book searchForBook(String title);
	
	/**
	 * Adds a new book to the end of the catalog with all
	 *  of the provided information, returns false with a
	 *  message if a book with that title already exists
	 *  and true if successful.
	 * @param isbn
	 * @param title
	 * @param author
	 * @param pub
	 * @param pubYear
	 * @return
	 */
	public boolean addBook(int isbn, String title, String author, String pub, int pubYear);
	
	/**
	 * Updates a book with a matching title, updating
	 *  all of the other provided information, if no
	 *  book matches the title, prints a message
	 * @param isbn
	 * @param title
	 * @param author
	 * @param pub
	 * @param pubYear
	 * @return
	 */
	public boolean updateBook(int isbn, String title, String author, String pub, int pubYear);
	
	/**
	 * Removes the book with a title matching the
	 *  input. If there is one, prints a message
	 *  if not
	 * @param title
	 * @return
	 */
	public boolean removeBook(String title);
	
	/**
	 * Asks the user for a publisher
	 *  and returns an ArrayList of
	 *  books by that publisher
	 * @param pub
	 * @return
	 */
	public ArrayList<Book> getBooksByPublisher(String pub);
	
	/**
	 * Sorts the catalog alphabetically
	 * 
	 */
	public void sortByTitle();
	
	/**
	 * Updates the input text file with
	 *  any changes made to the catalog
	 */
	public void Save(String filename);
}