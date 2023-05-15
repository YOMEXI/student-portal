package schoolportalapi.portal.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Department name cannot be empty")
    @Size(max = 50,message = "Department name cannot be more than 50 characters")
    @Column(unique = true, nullable = false, length = 50)
    private String departmentName;


    @NotBlank(message = "Department code cannot be empty")
    @Size(max = 5,message = "Department code cannot be more than 5 characters")
    @Column(unique = true, nullable = false, length = 5)
    private String departmentCode;



    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "faculty", nullable = false)
    private Faculty faculty;


}
