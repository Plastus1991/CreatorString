package stringapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserRequirementsDto {

    private final Long id;
    private final int min;
    private final int max;
    private final char[] arr;
    private final int count;
}
