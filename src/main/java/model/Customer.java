package model;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
    private String id;
    private String title;
    private String name;
    private String address;
    private String number;
    private LocalDate dob;
}
