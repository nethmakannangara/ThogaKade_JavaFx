package model;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
    String id;
    String title;
    String name;
    String address;
    String number;
    LocalDate dob;
}
