package model;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id @Column(name = "bookId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    @Column(name = "bookName")
    private String bookName;
    @Column(name = "author")
    private String author;
    @Column(name = "price")
    private int price;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "book")
    private BookDetail bookDetail;

    public Book(String bookName,String author,int price){
        this.bookName=bookName;
        this.author=author;
        this.price=price;
    }
    public Book(String bookName,String author,int price,BookDetail bookDetail){
        this.bookName=bookName;
        this.author=author;
        this.price=price;
        this.bookDetail=bookDetail;
    }

    public Book() {

    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public BookDetail getBookDetail() {
        return bookDetail;
    }

    public void setBookDetail(BookDetail bookDetail) {
        this.bookDetail = bookDetail;
    }
}
