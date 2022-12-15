package services.implementation;
import models.Book;
import models.Library;
import models.User;
import services.LibraryServices;
import services.UserComparator;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class LibrarySerivicesImplementation implements LibraryServices {


    @Override
    public String addBooks(HashMap<Book, Integer> booksList, Book book, Integer noOfCopies) {
        if(!booksList.containsKey(book)) {
            booksList.put(book, noOfCopies);
            return "Successfully added the new book to the library";
        }
        return "Copies of this book already exist in the library";
    }

    @Override
    public String giveBookToUserBasedOnPriority(Queue<User> userPriorityQueue) {
        //use ava
        userPriorityQueue = Library.getUserPriorityQueue();
        System.out.println("Displaying the order of priority to get books from the library: ");
        System.out.printf("%-20s%-20s%-20s%-20s","USER_ID", "USER_NAME","TYPE_OF_USER", "BOOK_REQUESTING");
        System.out.println();
        System.out.println("------------------------------------------------------------------------");
        System.out.println(userPriorityQueue);
        System.out.println("the second on the priority queue is: \n" + userPriorityQueue.poll());
            return "User has collected a book based on priority";
    }

    @Override
    public String giveBookToUserBasedOnFIFO(Queue<User> userFIFOQueue) {
        userFIFOQueue = Library.getUserFIFOQueue();
        System.out.println("Displaying the order of first come first serve to get books from the library: ");
        System.out.printf("%-20s%-20s%-20s%-20s","USER_ID", "USER_NAME","TYPE_OF_USER", "BOOK_REQUESTING");
        System.out.println();
        System.out.println("------------------------------------------------------------------------");
        System.out.println(userFIFOQueue);
        System.out.println("the second on the priority queue is: \n" + userFIFOQueue.poll());
        return "User has collected a book based on first come first serve";
    }

    @Override
    public String displayAllBooks(HashMap<Book, Integer> booksAvailable) {
        System.out.printf("%-20s%-20s%-20s%-20s","BOOKID", "BOOK TITLE","BOOK AUTHOR", "NO_OF_COPIES");
        System.out.println();
        System.out.println("------------------------------------------------------------------------");
        for(Map.Entry<Book, Integer> entry: booksAvailable.entrySet()) {
            System.out.println(entry);
        }
        return "This is the list of books available in the library";
    }

//TODO change the book object argument to string
    public String checkAvailability(HashMap<Book, Integer> booksAvailable, Book book){
    if(booksAvailable.containsKey(book)){
            System.out.println(book + " is Available");
            return "This book is available";
        }
        System.out.println(book + " this book is not available");
            return "Book is taken";
    }


}
