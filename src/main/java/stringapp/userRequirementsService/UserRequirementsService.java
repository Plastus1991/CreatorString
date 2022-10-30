package stringapp.userRequirementsService;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import stringapp.domain.UserRequirements;
import stringapp.repository.UserRequirementsRepository;

@Service
@RequiredArgsConstructor
public class UserRequirementsService {


    private final UserRequirementsRepository userRequirementsRepository;

    public UserRequirements saveUserRequirements(final UserRequirements userRequirements) {
        return userRequirementsRepository.save(userRequirements);
    }
}
