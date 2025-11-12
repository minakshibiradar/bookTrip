package com.mbb.Book.Trip.model;

import com.mbb.Book.Trip.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

  //default constructor
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Data
@Builder
public class Customer {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private int customerId;

      private String name;

      private int age;

      @Column(unique = true,nullable = false)
      private String emailId;

      @Enumerated(value = EnumType.STRING)
      private Gender gender;


      // cascading on all crud operation
      //one means customer and many means booking like one user can make multiple bookings.

      @OneToMany(cascade = CascadeType.ALL)
      @JoinColumn
      List<Booking> bookings = new ArrayList<>();
      //join table with the foreign key using this annotation
//  @JoinColumn(name="Customer_id") we can create like this to give the name to foreign key column as per own


//    Whenever is the one relationship in that class only we write the above line
// that line meaning is a customer have list of bookings.


        public Customer() {
        }

        public Customer(int customerId, String name, int age, String emailId, Gender gender, List<Booking> bookings) {
              this.customerId = customerId;
              this.name = name;
              this.age = age;
              this.emailId = emailId;
              this.gender = gender;
              this.bookings = bookings;
        }

        public int getCustomerId() {
              return customerId;
        }

        public void setCustomerId(int customerId) {
              this.customerId = customerId;
        }

        public String getName() {
              return name;
        }

        public void setName(String name) {
              this.name = name;
        }

        public int getAge() {
              return age;
        }

        public void setAge(int age) {
              this.age = age;
        }

        public String getEmailId() {
              return emailId;
        }

        public void setEmailId(String emailId) {
              this.emailId = emailId;
        }

        public Gender getGender() {
              return gender;
        }

        public void setGender(Gender gender) {
              this.gender = gender;
        }

        public List<Booking> getBookings() {
              return bookings;
        }

        public void setBookings(List<Booking> bookings) {
              this.bookings = bookings;
        }
  }
