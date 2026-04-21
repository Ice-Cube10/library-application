package libraryBookCatalog;

import java.io.*;
import java.util.*;

public class BookCatalog implements BookCatalogInterface{

	Scanner kbd = new Scanner(System.in);
	ArrayList<Book> bookCatalog = new ArrayList<>();
	Scanner inputStream = null;
	PrintWriter outputStream = null;
	private int isbn, pubYear;
	private String title, author, pub;
	
	/**
	 * default constructor
	 */
	public BookCatalog() {}
	
	/**
	 * 5 parameter constructor for new books in the catalog
	 * @param isbn
	 * @param title
	 * @param author
	 * @param pub
	 * @param pubYear
	 */
	public BookCatalog(int isbn, String title, String author, String pub, int pubYear) {
		bookCatalog.add(new Book(isbn, title, author, pub, pubYear));
	}
	
	/**
	 * Loads book information from the file into
	 *  the catalog
	 * @param filename
	 */
	@Override
	public void loadData(String filename) {
		try {
			inputStream = new Scanner(new File(filename));
		}
		catch(FileNotFoundException e) {
			System.err.println("Error opening the file " + filename);
			System.exit(1);
		}
		while(inputStream.hasNextLine()) {
			isbn = Integer.parseInt(inputStream.nextLine());
			title = inputStream.nextLine();
			author = inputStream.nextLine();
			pub = inputStream.nextLine();
			pubYear = Integer.parseInt(inputStream.nextLine());
			bookCatalog.add(new Book(isbn, title, author, pub, pubYear));
			if(inputStream.hasNextLine())
				inputStream.nextLine();
		}
		inputStream.close();
	}
	
	/**
	 * Displays all the books in the catalog
	 */
	@Override
	public void displayCatalog() {
		Iterator<Book> iter = bookCatalog.listIterator();
		while(iter.hasNext()) {
			System.out.println(iter.next().toString() + "\n");
		}
	}
	
	/**
	 * Searches for a book matching the provided title
	 *  and provides the information on the book if one
	 *  is found
	 * @param title
	 * @return
	 */
	@Override
	public Book searchForBook(String title) {
		Iterator<Book> books = bookCatalog.listIterator();
		while(books.hasNext()) {
			Book b = books.next();
			if(b.getTitle().equals(title)) {
				return b;
			}
		}
		return null;
	}
	
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
	@Override
	public boolean addBook(int isbn, String title, String author, String pub, int pubYear) {
		Iterator<Book> books = bookCatalog.listIterator();
		while(books.hasNext()) {
			Book b = books.next();
			if(b.getTitle().equals(title)) {
				System.out.println("Book Title already used.\n");
				return false;
			}
		}
		bookCatalog.add(new Book(isbn, title, author, pub, pubYear));
		return true;
	}
	
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
	@Override
	public boolean updateBook(int isbn, String title, String author, String pub, int pubYear) {
		Iterator<Book> books = bookCatalog.listIterator();
		while(books.hasNext()) {
			Book b = books.next();
			if(b.getTitle().equals(title)) {
				b.setISBN(isbn);
				b.setAuthor(author);
				b.setPub(pub);
				b.setPubYear(pubYear);
				return true;
			}
		}
		System.out.println("Book Not Found.");
		return false;
	}
	
	/**
	 * Removes the book with a title matching the
	 *  input. If there is none, prints a message
	 *  if not
	 * @param title
	 * @return
	 */
	@Override
	public boolean removeBook(String title) {
		Iterator<Book> books = bookCatalog.listIterator();
		while(books.hasNext()) {
			Book b = books.next();
			if(b.getTitle().equals(title)) {
				books.remove();
				return true;
			}
		}
		System.out.println("Book Not Found.\n");
		return false;
	}
	
	/**
	 * Asks the user for a publisher
	 *  and returns an ArrayList of
	 *  books by that publisher
	 * @param pub
	 * @return
	 */
	@Override
	public ArrayList<Book> getBooksByPublisher(String pub) {
		Iterator<Book> books = bookCatalog.listIterator();
		ArrayList<Book> pubCatalog = new ArrayList<>();
		while(books.hasNext()) {
			Book b = books.next();
			if(b.getPub().equals(pub)) {
				pubCatalog.add(b);
			}
		}
		return pubCatalog;
	}
	
	/**
	 * Sorts the catalog alphabetically
	 */
	@Override
	public void sortByTitle() {
		bookCatalog.sort(Comparator.comparing(Book::getTitle));
	}
	
	/**
	 * Updates the input text file with
	 *  any changes made to the catalog
	 */
	@Override
	public void Save(String filename) {
		
		try {
			outputStream = new PrintWriter("assg6_catalog.txt");
		}
		catch(IOException e) {
			System.err.println("Error opening the file assg6_catalog.txt");
			System.exit(1);
		}
		outputStream.print("");
		
		Iterator<Book> iter = bookCatalog.listIterator();
		while(iter.hasNext()) {
			outputStream.print(iter.next().toString() + "\n\n");
		}
		outputStream.close();
	}
}