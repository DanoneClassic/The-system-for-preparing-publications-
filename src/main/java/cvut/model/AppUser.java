package cvut.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

import static jakarta.persistence.GenerationType.*;

@Entity
@Table(name = "app_user")
@NamedQueries({
        @NamedQuery(name = "app_user.findByUsername", query = "SELECT u FROM AppUser u WHERE u.username = :username")
})
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@ToString
public class AppUser {

    @GeneratedValue(strategy = AUTO)
    @Id
    private Long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name="email", nullable = false, unique = true)
    private String email;


    public AppUser(String firstname, String lastname, String username, String password, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.email = email;
    }

}
