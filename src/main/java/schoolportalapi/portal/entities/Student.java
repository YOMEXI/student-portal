package schoolportalapi.portal.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "Firstname cannot be empty")
    @Size(max = 40,message = "Firstname  cannot be more than 40 characters")
    @Column(nullable = false, length = 40)
    private String firstName;
    @NotBlank(message = "Lastname cannot be empty")
    @Size(max = 40,message = "Lastname  cannot be more than 40 characters")
    @Column(nullable = false, length = 40)
    private String lastName;
    @Size(max = 40,message = "Middlename  cannot be more than 40 characters")
    @Column(length = 40)
    private String middleName;

    @NotBlank(message = "phone number cannot be empty")
    @Column(nullable = false, length = 20)
    private Integer phone;
    @NotBlank(message = "registration Number cannot be empty")
    @Column(nullable = false, length = 40)
    private String registrationNumber;
    @Column()
    private String matricNo;

    @NotBlank(message = "state cannot be empty")
    @NotBlank
    @Size(max = 50)
    @Column(length = 150,nullable = false)
    private String state;
    @NotBlank(message = "lga cannot be empty")
    @Size(max = 100)
    @Column(length = 100,nullable = false)
    private String lga;
    @NotBlank(message = "course cannot be empty")
    @Size(max = 100)
    @Column(length = 100,nullable = false)
    private String course;

    @NotBlank(message = "gender cannot be empty")
    @Size(max = 15)
    @Column(length = 15,nullable = false)
    private String gender;

    @Email(message = "Email is not valid", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
    @NotEmpty(message = "Email cannot be empty")
    @NotBlank
    @Size(max = 50)
    @Column(unique = true, nullable = false, length = 100)
    private String email;
    @Column(length = 20)
    private Integer emergencyContact;





}
