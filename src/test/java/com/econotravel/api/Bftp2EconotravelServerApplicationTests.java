package com.econotravel.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class Bftp2EconotravelServerApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ExperienceRepository experienceRepository;

    @BeforeEach
    void setUp() {
        experienceRepository.deleteAll();
    }

    @Test
    void returnsTheExistingExperiences() throws Exception {

        addSampleExperiences();

        mockMvc.perform(get("/api/experiences"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*]", hasSize(2)))
                .andExpect(jsonPath("$[0].name", equalTo("Paseo por el Montseny")))
                .andExpect(jsonPath("$[1].name", equalTo("Visita a la sagrada familia")))
                .andDo(print());
    }

    private void addSampleExperiences() {
        List<Experience> experiences = List.of(
                new Experience("Paseo por el Montseny", 250, 5, "Montaña, bicicleta, excursión larga.", "https://cdn2.civitatis.com/espana/viladrau/tour-bicicleta-electrica-parque-montseny-grid.jpg"),
                new Experience("Visita a la sagrada familia", 200, 4, "Ciudad, a pie, excursión larga", "https://media.tacdn.com/media/attractions-splice-spp-674x446/09/57/77/a3.jpg")
        );

        experienceRepository.saveAll(experiences);
    }

    @Test
    void createsNewExperiences() throws Exception {

        mockMvc.perform(post("/api/experiences")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"Paseo en Bici por el Montseny\"}")
        ).andExpect(status().is(200));

        var experiences = experienceRepository.findAll();

        assertThat(experiences, contains(
                hasProperty("name", is("Paseo en Bici por el Montseny"))
        ));
    }

    @Test
    void allowsToCreateANewExperience() throws Exception {
        mockMvc.perform(post("/experiences/new")
                        .param("name", "Paseo en Bici por el Montseny")
                        .param("price", String.valueOf(250))
                        .param("time", String.valueOf(5))
                        .param("category", "Montaña, bicicleta, excursión larga")
                        .param("imageUrl", "")

                )
                .andExpect(status().is(200));

        List<Experience> existingExperiences = (List<Experience>) experienceRepository.findAll();
        assertThat(existingExperiences, contains(allOf(
                hasProperty("name", equalTo("Paseo en bici por el Montseny")),
                hasProperty("price", equalTo(250)),
                hasProperty("time", equalTo(5)),
                hasProperty("categoria", equalTo("Montaña, bicileta, excursión larga"))
        )));
    }

}
