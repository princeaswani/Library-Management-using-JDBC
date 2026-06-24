package org.example;


public class book{
    private int Bookid;
    private String Bookname;
    private String author;
    private Boolean isIssued;
    private String bookType;

    public int getBookid() {
        return Bookid;
    }

    public void setBookid(int bookid) {
        Bookid = bookid;
    }

    public String getBookname() {
        return Bookname;
    }

    public void setBookname(String bookname) {
        Bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public book(int bookid, String bookname, String author, String bookType) {
        Bookid = bookid;
        Bookname = bookname;
        this.author = author;
        this.isIssued = false;
        this.bookType = bookType;
    }


    public Boolean getIssued() {
        return isIssued;
    }

    public void setIssued(Boolean issued) {
        isIssued = issued;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public void displayBook(){
        System.out.println("Book id : "+ Bookid);
        System.out.println("Name : "+ Bookname);
        System.out.println("Author : "+ author);
        System.out.println("Status : "+(isIssued ? "Issued" : "Available"));
    }
//    public abstract void displayBookType();


}
