package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.sql.SQLException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws SQLException {
        Scanner sc =new Scanner(System.in);
        Library lib = new Library();

        int choice;

        do{
            System.out.println("=====Library Management System========");
            System.out.println("1) Add Book");
            System.out.println("2) Display Books");
            System.out.println("3) Display Available Books");
            System.out.println("4) Search Book by ID");
            System.out.println("5) Search Book by Book Name");
            System.out.println("6) Issue Book");
            System.out.println("7) Return Book");
            System.out.println("8) Remove Book from Library");
            System.out.println("9) EXIT");
            System.out.println("Enter Choice: ");

            choice = sc.nextInt();

            switch (choice){
//                We are Adding Book Here
                case 1:

                    System.out.println("Enter Book ID: ");
                    int id=sc.nextInt();

                    System.out.println("Enter Book Name: ");
                    sc.nextLine();
                    String bn=sc.nextLine();

                    System.out.println("Enter Author : ");
                    String ath=sc.nextLine();

                    System.out.println("Select Book Type : ");
                    String bookType=sc.nextLine();
                    book b =new book(id,bn,ath, bookType);
                    lib.addBook(b);

                    break;

                case 2:
                    lib.displayBooks();
                    break;

                case 3:
                    lib.displayAvailableBooks();
                    break;

                case 4:
                    System.out.print("Enter Book ID : ");
                    int searchId = sc.nextInt();
                    book foundbook = lib.searchBookById(searchId);
                    if(foundbook != null){
                        foundbook.displayBook();
                    } else {
                        System.out.println("Book Not Found");
                    }
                    break;

                case 5:
                    System.out.print("Enter Book ID : ");
                    String searchBook = sc.next();
                    book foundTitlebook=lib.searchBookByTitle(searchBook);
                    if(foundTitlebook != null){
                        foundTitlebook.displayBook();
                    } else {
                        System.out.println("Book Not Found");
                    }
                    break;

                case 6:
                System.out.print("Enter Book ID : ");
                int issueId = sc.nextInt();
                lib.issueBook(issueId);
                break;

                case 7:
                    System.out.print("Enter Book ID : ");
                    int returnId = sc.nextInt();
                    lib.returnBook(returnId);
                    break;

                case 8:
                    System.out.print("Enter Book ID : ");
                    int removeId = sc.nextInt();
                    lib.removeBook(removeId);
                    break;

                case 9:
                    System.out.println("Thank You!");
                    break;





                default:
                    System.out.println("Please Enter Valid Input....");

            }

        }while(choice != 9);
        System.out.println("Thanks For Using Our Library.");
    }
}







////                    Displaying All Books
//                case 2:
//                        lib.displayBooks();
//                    break;
//
////                    Displaying Available Books
//                            case 3:
//                            lib.displayAvailBooks();
//                    break;
//
////                    Searching Book by ID
//                            case 4:
//                            System.out.println("Enter book ID to find : ");
//int sid = sc.nextInt();
//
//                    lib.searchByID(sid);
//                    break;
//
////                    Searching Book by Book Name
//                            case 5:
//                            System.out.println("Enter Book Name to find : ");
//                    sc.nextLine();
//String sname = sc.nextLine();
//
//                    lib.searchByName(sname);
//                    break;
//
////                    Issuing the Book from Library
//                            case 6:
//                            System.out.println("Enter Book ID to issue the book : ");
//int iid = sc.nextInt();
//
//                    lib.issueBook(iid);
//                    break;
//
////                    Returning the Book To Library
//                            case 7:
//                            System.out.println("Enter Book ID to return the book : ");
//int rid= sc.nextInt();
//
//                    lib.returnBook(rid);
//                    break;
//
////                    Removing Book From Library
//                            case 8:
//                            System.out.println("Removing Old Books from Library...");
//                    System.out.println("Enter Book ID that you want to remove from our Library : ");
//int rbid = sc.nextInt();
//
//                    lib.removeBook(rbid);
//                    break;
//
//                            case 9:
//                            System.out.println("Exiting");
//                    break;