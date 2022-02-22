package com.econotravel.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/experiences")
// NO INCLUIR NUNCA LA CABECERA CrossOrigin en un proyecto real
@CrossOrigin
public class ExperienceController {

    private final ExperienceRepository experienceRepository;

    @Autowired
    public ExperienceController(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    @GetMapping
    public List<Experience> allExperiences() {
        return experienceRepository.findAll();
    }

    @PostMapping
    public Experience createExperience(@RequestBody Experience experience) {
        return experienceRepository.save(experience);
    }

    @GetMapping("/{id}")
    public Experience findExperience(@PathVariable Long id){
        return experienceRepository.findById(id).orElseThrow(null);
    }

    @GetMapping("/edit/{id}")
    public Experience updateExperienceById(Model model, @PathVariable Long id){
        Experience experience1 = experienceRepository.findById(id).get();
        model.addAttribute("experience", experience1);
        model.addAttribute("name", "Edit experience");
        return experienceRepository.save(experience1);
    }


    @DeleteMapping("/delete/{id}")
    public Experience deleteExperienceById(@PathVariable Long id) {
        Experience experience = experienceRepository.findById(id).get();
        experienceRepository.deleteById(id);
        return experience;
    }
}
