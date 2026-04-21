package libraryBookCatalog;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class LibraryApplication {
	
	static Scanner kbd = new Scanner(System.in); //Global since it is used in both functions
	final static String inputFile = "BookList.txt";
	
	public static void main(String[] args) {
		
		
		int input, output = 0;
		
		
		BookCatalog books = new BookCatalog();
		
		books.loadData(inputFile);
		
		while(output == 0) {
		System.out.println("Enter a number:");
		System.out.println("1. Display all books in Catalog");
		System.out.println("2. Search for a book");
		System.out.println("3. Add a new book");
		System.out.println("4. Update an existing book");
		System.out.println("5. Remove a book");
		System.out.println("6. Display all books by a publisher");
		System.out.println("7. Sort all books based on title");
		System.out.println("8. Save data");
		System.out.println("9. Exit");
		input = kbd.nextInt();
		kbd.nextLine();
		
		output = menuOptions(input, books);
		}
		
		kbd.close();
	}
	
	/**
	 * Takes the selected menu option and the current configuration of
	 *  the book catalog and uses them to perform the seleceted menu action
	 * @param input
	 * @param books
	 * @return
	 */
	public static int menuOptions(int input, BookCatalog books) {
		
		int output;
		int isbn, year;
		String title, author, pub;
		
		
		switch(input) {
		case(1):
			books.displayCatalog();
			output = 0;
			break;
			
		case(2):
			System.out.println("Enter Book Title:");
			title = kbd.nextLine();
			if(books.searchForBook(title) != null)
				System.out.println("\n" + books.searchForBook(title) + "\n");
			else
				System.out.println("Book Not Found.\n");
			output = 0;
			break;
			
		case(3):
			System.out.println("Enter ISBN:");
			isbn = kbd.nextInt();
			kbd.nextLine();
			System.out.println("Enter Title:");
			title = kbd.nextLine();
			System.out.println("Enter Author:");
			author = kbd.nextLine();
			System.out.println("Enter Publisher:");
			pub = kbd.nextLine();
			System.out.println("Enter Published Year:");
			year = kbd.nextInt();
			kbd.nextLine();
			
			books.addBook(isbn, title, author, pub, year);
			
			output = 0;
			break;
			
		case(4):
			System.out.println("Enter ISBN:");
			isbn = kbd.nextInt();
			kbd.nextLine();
			System.out.println("Enter Title:");
			title = kbd.nextLine();
			System.out.println("Enter Author:");
			author = kbd.nextLine();
			System.out.println("Enter Publisher:");
			pub = kbd.nextLine();
			System.out.println("Enter Published Year:");
			year = kbd.nextInt();
			kbd.nextLine();
			
			books.updateBook(isbn, title, author, pub, year);
			
			output = 0;
			break;
			
		case(5):
			System.out.println("Enter Book Title:");
			books.removeBook(kbd.nextLine());
			output = 0;
			break;
			
		case(6):
			ArrayList<Book> pubCatalog = new ArrayList<>();
			System.out.println("Enter Publisher:");
			pub = kbd.nextLine();
			System.out.println();
			pubCatalog = books.getBooksByPublisher(pub);
			Iterator<Book> pubBooks = pubCatalog.listIterator();
			while(pubBooks.hasNext()) {
				System.out.println(pubBooks.next() + "\n");
			}
			
			output = 0;
			break;
			
		case(7):
			books.sortByTitle();
			System.out.println();
			output = 0;
			break;
			
		case(8):
			System.out.println("Data Saved\n");
			books.Save(inputFile);
			output = 0;
			break;
			
		case(9):
			System.out.println("Data Saved, Goodbye.");
			books.Save(inputFile);
			output = -1;
			break;
		
		default:
			System.out.println("Invalid menu option");
			output = 0;
			break;
		}
		
		if(input != 9) {
			System.out.println("Press Enter to Continue.");
			kbd.nextLine();
		}
		return output;
	}
}