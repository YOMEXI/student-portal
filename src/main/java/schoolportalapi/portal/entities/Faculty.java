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
@Table(name = "faculty")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Faculty name cannot be empty")
    @Size(max = 35,message = "Faculty name cannot be more than 35 characters")
    @Column(unique = true, nullable = false, length = 35)
    private String facultyName;

    @NotBlank(message = "Faculty code cannot be empty")
    @Size(max = 4,message = "Faculty name cannot be more than 4 characters")
    @Column(unique = true, nullable = false, length = 4)
    private String facultyCode;

    @OneToMany(mappedBy = "departments",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Department> departments;


}
