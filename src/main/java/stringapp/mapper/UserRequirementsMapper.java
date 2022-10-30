package stringapp.mapper;


import org.springframework.stereotype.Service;
import stringapp.domain.UserRequirements;
import stringapp.dto.UserRequirementsDto;

@Service
public class UserRequirementsMapper {

    public UserRequirements mapToRequirements(final UserRequirementsDto userRequirementsDto) {
        return new UserRequirements(
                userRequirementsDto.getId(),
                userRequirementsDto.getMin(),
                userRequirementsDto.getMax(),
                userRequirementsDto.getArr(),
                userRequirementsDto.getCount()

        );
    }

    public UserRequirementsDto userRequirementsDto(final UserRequirements userRequirements) {
        return new UserRequirementsDto(
                userRequirements.getId(),
                userRequirements.getMin(),
                userRequirements.getMax(),
                userRequirements.getArrayString(),
                userRequirements.getCountOfString()
        );

    }
}
