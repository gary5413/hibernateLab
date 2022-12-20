package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "BookDeatil")
public class BookDetail {
    @GenericGenerator(name = "generator",strategy = "foreign",
    parameters = @org.hibernate.annotations.Parameter(name = "property",value = "book"))
    @Id @GeneratedValue(generator = "generator")
    @Column(name = "ID")
    private int id;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "publisherAddress")
    private String publisherAddress;
    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Book book;

    public BookDetail(){

    }
    public BookDetail(String publisher,String publisherAddress){
        this.publisher=publisher;
        this.publisherAddress=publisherAddress;
        this.book=book;
    }
    public BookDetail(String publisher,String publisherAddress,Book book){
        this.publisher=publisher;
        this.publisherAddress=publisherAddress;
        this.book=book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublisherAddress() {
        return publisherAddress;
    }

    public void setPublisherAddress(String publisherAddress) {
        this.publisherAddress = publisherAddress;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
