package libraryBookCatalog;

public class Book implements Comparable<Book> {
	
	private int isbn, pubYear;
	private String title, author, pub;
	
	/**
	 * default constructor
	 */
	public Book() {}
	
	/**
	 * 5 parameter constructor for new Book objects
	 * @param isbn
	 * @param title
	 * @param author
	 * @param pub
	 * @param pubYear
	 */
	public Book(int isbn, String title, String author, String pub, int pubYear) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.pub = pub;
		this.pubYear = pubYear;
	}
	
	/**
	 * Retrieves the ISBN
	 * @return
	 */
	public int getISBN(){
		return isbn;
	}
	
	/**
	 * Retrieves the title
	 * @return
	 */
	public String getTitle(){
		return title;
	}
	
	/**
	 * Retrieves the author
	 * @return
	 */
	public String getAuthor(){
		return author;
	}
	
	/**
	 * Retrieves the publisher
	 * @return
	 */
	public String getPub(){
		return pub;
	}
	
	/**
	 * Retrieves the year published
	 * @return
	 */
	public int getPubYear(){
		return pubYear;
	}
	
	/**
	 * Sets a new ISBN
	 * @return
	 */
	public void setISBN(int isbn){
		this.isbn = isbn;
	}
	
	/**
	 * Sets a new author
	 * @return
	 */
	public void setAuthor(String author){
		this.author = author;
	}
	
	/**
	 * Sets a new publisher
	 * @return
	 */
	public void setPub(String pub){
		this.pub = pub;
	}
	
	/**
	 * Sets a new published year
	 * @return
	 */
	public void setPubYear(int pubYear){
		this.pubYear = pubYear;
	}
	
	/**
	 * Converts the object into a string
	 */
	@Override
	public String toString() {
		return isbn + "\n" + title + "\n" + author + "\n" + pub + "\n" + pubYear;
	}
	
	/**
	 * Compares the title of 2 Books, returns true if equal
	 */
	@Override
	public boolean equals(Object book) {
		if(book instanceof Book) {
			Book bookTitle = new Book();
			bookTitle = (Book) book;
			if(this.title == bookTitle.title) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Compares the title of 2 Books,
	 *  returns 1 if THIS book is first alphabetically,
	 *  returns -1 if the parameter book is first, and
	 *  returns 0 if they have they have the same title
	 */
	@Override public int compareTo(Book book) {
		if(title.compareTo(book.title) > 0)
			return -1;
		else if(title.compareTo(book.title) < 0)
			return 1;
		else
			return 0;
	}
}