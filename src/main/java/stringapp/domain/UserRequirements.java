package stringapp.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "USER_REQUIREMENTS")

public class UserRequirements {

    @NotNull
    @GeneratedValue
    @Id
    @Column(name = "id", unique = true)
    private Long id;

    @NotNull
    @Column(name = "MIN_STRING")
    private int min;

    @NotNull
    @Column(name = "MAX_STRING")
    private int max;

    @NotNull
    @Column(name = "ARRAY_STRINGS")
    private char[] arrayString;

    @NotNull
    @Column(name = "COUNT_OF_STRINGS")
    private int countOfString;



}
