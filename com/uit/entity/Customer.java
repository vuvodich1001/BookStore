package com.uit.entity;
// Generated May 24, 2021 9:48:38 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Customer generated by hbm2java
 */
@Entity
@Table(name="CUSTOMER"
    ,schema="DOAN_NEW"
    , uniqueConstraints = @UniqueConstraint(columnNames="EMAIL") 
)
public class Customer  implements java.io.Serializable {


     private long customerId;
     private String email;
     private String fullName;
     private String address;
     private String city;
     private String country;
     private String phone;
     private String zipcode;
     private String password;
     private Date registerDate;
     private Set<BookOrder> bookOrders = new HashSet<BookOrder>(0);
     private Set<Review> reviews = new HashSet<Review>(0);

    public Customer() {
    }

	
    public Customer(long customerId, Date registerDate) {
        this.customerId = customerId;
        this.registerDate = registerDate;
    }
    public Customer(long customerId, String email, String fullName, String address, String city, String country, String phone, String zipcode, String password, Date registerDate, Set<BookOrder> bookOrders, Set<Review> reviews) {
       this.customerId = customerId;
       this.email = email;
       this.fullName = fullName;
       this.address = address;
       this.city = city;
       this.country = country;
       this.phone = phone;
       this.zipcode = zipcode;
       this.password = password;
       this.registerDate = registerDate;
       this.bookOrders = bookOrders;
       this.reviews = reviews;
    }
   
     @Id 

    
    @Column(name="CUSTOMER_ID", unique=true, nullable=false, precision=10, scale=0)
     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_generator")
    @SequenceGenerator(name="customer_generator", sequenceName = "seq_customer", allocationSize = 1)
    public long getCustomerId() {
        return this.customerId;
    }
    
    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    
    @Column(name="EMAIL", unique=true, length=30)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="FULL_NAME", length=30)
    public String getFullName() {
        return this.fullName;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    
    @Column(name="ADDRESS", length=64)
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    
    @Column(name="CITY", length=64)
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    
    @Column(name="COUNTRY", length=64)
    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }

    
    @Column(name="PHONE", length=15)
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    
    @Column(name="ZIPCODE", length=24)
    public String getZipcode() {
        return this.zipcode;
    }
    
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    
    @Column(name="PASSWORD", length=16)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="REGISTER_DATE", nullable=false, length=7)
    public Date getRegisterDate() {
        return this.registerDate;
    }
    
    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="customer")
    public Set<BookOrder> getBookOrders() {
        return this.bookOrders;
    }
    
    public void setBookOrders(Set<BookOrder> bookOrders) {
        this.bookOrders = bookOrders;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="customer")
    public Set<Review> getReviews() {
        return this.reviews;
    }
    
    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }




}


