package schoolportalapi.portal.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
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


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "faculty", nullable = false)
    private Faculty faculty;
}
