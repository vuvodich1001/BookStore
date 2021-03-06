package com.uit.entity;
// Generated Jun 16, 2021 9:11:22 PM by Hibernate Tools 4.3.1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * OrderDetail generated by hbm2java
 */
@Entity
@Table(name="ORDER_DETAIL"
    ,schema="DOAN_NEW"
)
public class OrderDetail  implements java.io.Serializable {


     private OrderDetailId id;
     private Book book;
     private BookOrder bookOrder;
     private Long quantity;
     private Double subtotal;

    public OrderDetail() {
    }

	
    public OrderDetail(OrderDetailId id, Book book, BookOrder bookOrder) {
        this.id = id;
        this.book = book;
        this.bookOrder = bookOrder;
    }
    public OrderDetail(OrderDetailId id, Book book, BookOrder bookOrder, Long quantity, Double subtotal) {
       this.id = id;
       this.book = book;
       this.bookOrder = bookOrder;
       this.quantity = quantity;
       this.subtotal = subtotal;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="orderId", column=@Column(name="ORDER_ID", nullable=false, precision=10, scale=0) ), 
        @AttributeOverride(name="bookId", column=@Column(name="BOOK_ID", nullable=false, precision=10, scale=0) ) } )
    public OrderDetailId getId() {
        return this.id;
    }
    
    public void setId(OrderDetailId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="BOOK_ID", nullable=false, insertable=false, updatable=false)
    public Book getBook() {
        return this.book;
    }
    
    public void setBook(Book book) {
        this.book = book;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ORDER_ID", nullable=false, insertable=false, updatable=false)
    public BookOrder getBookOrder() {
        return this.bookOrder;
    }
    
    public void setBookOrder(BookOrder bookOrder) {
        this.bookOrder = bookOrder;
    }

    
    @Column(name="QUANTITY", precision=10, scale=0)
    public Long getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    
    @Column(name="SUBTOTAL", precision=126, scale=0)
    public Double getSubtotal() {
        return this.subtotal;
    }
    
    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }




}


