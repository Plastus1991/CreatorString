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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column()
    private Long id;


    @Column(name = "MIN_STRING")
    private int min;


    @Column(name = "MAX_STRING")
    private int max;


    @Column(name = "ARRAY_STRINGS")
    private char[] arrayString;


    @Column(name = "COUNT_OF_STRINGS")
    private int countOfString;



}
