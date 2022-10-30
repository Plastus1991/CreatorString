package stringapp.userRequirementsService;


import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import stringapp.creator.GeneratorUniqueString;
import stringapp.domain.UserRequirements;
import stringapp.repository.UserRequirementsRepository;

import java.io.*;
import java.util.LinkedList;


@Service
@RequiredArgsConstructor
public class UserRequirementsService {

    private final Logger logger = LogManager.getLogger(UserRequirementsService.class);

    private final UserRequirementsRepository userRequirementsRepository;

    public UserRequirements saveUserRequirements(final UserRequirements userRequirements) {
        return userRequirementsRepository.save(userRequirements);
    }

    public void saveStringInfile(Long id) {

        UserRequirements userRequirements = userRequirementsRepository.getById(id);
        GeneratorUniqueString generatorUniqueString = new GeneratorUniqueString(userRequirements);
        generatorUniqueString.stringGenerator();
        generatorUniqueString.getElementsBySize();
        LinkedList<String> finishList = generatorUniqueString.getFinishList();

        if(generatorUniqueString.isCountSmallerThenSizeList()) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(".\\uniqueStringFile.txt"));
                for (String s : finishList) {
                    writer.write(s + "\n");
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            logger.error("Error, can't create this number of strings");
        }


    }




}
