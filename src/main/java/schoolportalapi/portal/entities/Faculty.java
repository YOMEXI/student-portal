package schoolportalapi.portal.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @Size(max = 4,message = "Faculty code cannot be more than 4 characters")
    @Column(unique = true, nullable = false, length = 4)
    private String facultyCode;

    @JsonIgnore
    @OneToMany(mappedBy = "faculty",fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Department> departments;


}
