package stringapp.controller;


import lombok.RequiredArgsConstructor;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import stringapp.domain.UserRequirements;
import stringapp.dto.UserRequirementsDto;
import stringapp.mapper.UserRequirementsMapper;
import stringapp.userRequirementsService.UserRequirementsService;

import java.io.FileNotFoundException;


@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/app")
public class UserRequirementsController {

    private final UserRequirementsMapper userRequirementsMapper;
    private final UserRequirementsService userRequirementsService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createRequirements(@RequestBody UserRequirementsDto userRequirementsDto) {
        UserRequirements userRequirements = userRequirementsMapper.mapToRequirements(userRequirementsDto);
        userRequirementsService.saveUserRequirements(userRequirements);

    }

    @GetMapping(value = "/{id}")
    public void saveInFile(@PathVariable Long id) {
        userRequirementsService.saveStringInfile(id);
    }
}
