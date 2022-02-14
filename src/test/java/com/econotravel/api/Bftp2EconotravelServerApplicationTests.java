package com.econotravel.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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
                .andExpect(jsonPath("$[0].name", equalTo("Paseo en bicicleta por el Montseny")))
                .andExpect(jsonPath("$[1].name", equalTo("Descubre la Barcelona Modernista de noche")))
                .andDo(print());
    }

    private void addSampleExperiences() {
        List<Experience> experiences = List.of(
                new Experience("Paseo en bicicleta por el Montseny", "Disfruta de un hermoso paseo en bicicleta por el increíble Parque Natural del Montseny.", "Disfruta de un hermoso paseo en bicicleta por el increíble Parque Natural del Montseny. Una escapada veraniega perfecta para parejas, " +
                        "familias y amigos que nos permitirá conocer nuevos y sorprendentes lugares. El recorrido que os proponemos comienza con una larga subida con algunos descansos, combinando " +
                        "asfalto y pistas anchas, culminando en un mirador con magníficas vistas del Vallés y el mar. Desde aquí continuaremos la bajada combinando senderos, pistas y algún tramo de carretera " +
                        "y terreno mixto para visitar la zona de Santa Fe, donde descubriremos la Ermita y el Bosque de las Secuoyas. Para finalizar, acudiremos al restaurante María Rosa de Palautordera, donde disfrutaremos " +
                        "de una excelente comida casera con butifarra blanca y negra y munxetes del Montseny.", 250, 5,
                        "Montaña, bicicleta, excursión larga.", "https://cdn2.civitatis.com/espana/viladrau/tour-bicicleta-electrica-parque-montseny-grid.jpg"),

                new Experience("Descubre la Barcelona Modernista de noche", "La mejor forma de descubrir las maravillas modernistas que se esconden en el barcelonés distrito del Eixample",
                        "Desplazarse a pie es una de las mejores formas de descubrir las maravillas modernistas que se esconden en el barcelonés distrito del Eixample, " +
                                "ubicado en el centro de la ciudad. " +
                                "En esta excursión de cuatro horas, descubriremos los principales emblemas del modernismo y visitaremos los templos y " +
                                "edificios más célebres del arquitecto Gaudí. \n" +
                                "El tour incluye visita guiada al interior de la Casa Batlló y la Sagrada Familia, así como parada para cenar en el restaurante típico " +
                                "catalán Can Masiá, donde disfrutaremos de las mejores carnes de la región acompañadas de vinos de las tierras del Baix Empordá. El restaurante también ofrece opciones vegetarianas y veganas así como menú " +
                                "para niños. Cava aparte. \n", 200, 4, "Ciudad, a pie, excursión larga", "https://media.tacdn.com/media/attractions-splice-spp-674x446/09/57/77/a3.jpg")
        );

        experienceRepository.saveAll(experiences);
    }

    @Test
    void createsNewExperiences() throws Exception {

        mockMvc.perform(post("/api/experiences")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"Paseo en bicicleta por el Montseny\"}")
        ).andExpect(status().is(200));

        var experiences = experienceRepository.findAll();

        assertThat(experiences, contains(
                hasProperty("name", is("Paseo en bicicleta por el Montseny"))
        ));
    }

    @Test
    void allowsToEditAnExperience() throws Exception {
        Experience experience = experienceRepository.save(new Experience("Descubre la costa en barco de vela", "../img/barcoDeVela.png", "Disfruta de un hermoso paseo acuático en barco de vela por la increíble costa de Barcelona. Una escapada veraniega apta incluso para los días más calurosos del año. " +
                "Descubre los encantadores alrededores de la ciudad de Barcelona y visita desde el mar sus más impresionantes playas y calas. Comenzaremos la excursión en el Puerto de Barcelona, desde donde partiremos hacia el norte para visitar playas como la Mar Bella, la Playa de la Mora y la Playa de los Pescadores. A bordo de la " +
                "embarcación podremos disfrutar de una selección de quesos y embutidos catalanes acompañada de cava brut y zumos de frutas. Asimismo, " +
                "pararemos cerca de la Playa de Montgat para realizar una actividad de buceo de superficie que nos permitirá apreciar la diversidad de la fauna marítima local y su ecosistema. Finalizaremos la excursión en el mismo puerto del que partimos.",
                280,
                5,
                "Actividad disponible para todas las edades. Pasarela para silla de ruedas disponible bajo reserva.",
                "Playa, barco, excursión larga."));

        mockMvc.perform(put("/api/experiences/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\": \"" + experience.getId() + "\", \"name\": \"Descubre la costa de Barcelona\"," + " \"image\": \"../img/montseny.png\"," +
                        " \"descripcion\": \"Disfruta de un hermoso paseo acuático en barco de vela por la increíble costa de Barcelona\"," +
                        "\"price\": 200," +
                        "\"time\": \"2h\"," +
                        "\"category\": \"Excursión larga\"}")
        ).andExpect(status().isOk());


        List<Experience> experiences = experienceRepository.findAll();

        assertThat(experiences, hasSize(1));
        assertThat(experiences.get(0).getName(), equalTo("Descubre la costa de Barcelona"));
        assertThat(experiences.get(0).getImgUrl(), equalTo("../img/montseny.png"));
        assertThat(experiences.get(0).getDescripcion(), equalTo("Disfruta de un hermoso paseo acuático en barco de vela por la increíble costa de Barcelona"));
        assertThat(experiences.get(0).getPrice(), equalTo(200.0));
        assertThat(experiences.get(0).getTime(), equalTo("2h"));
        assertThat(experiences.get(0).getCategory(), equalTo("Excursión larga"));


    }

    @Test
    void allowsToDeleteAnExperience() throws Exception {
        Experience experience = experienceRepository.save(new Experience("Descubre la costa en barco de vela", "paseo acuático en barco de vela por la increíble costa de Barcelona", "Disfruta de un hermoso paseo acuático en barco de vela por la increíble costa de Barcelona. Una escapada veraniega apta incluso para los días más calurosos del año. Descubre los encantadores alrededores de la ciudad de Barcelona y visita desde el mar sus más impresionantes playas y calas. Comenzaremos la excursión en el Puerto de Barcelona, desde donde partiremos hacia el norte para visitar playas como la Mar Bella, la Playa de la Mora y la Playa de los Pescadores. A bordo de la embarcación podremos disfrutar de una selección de quesos y embutidos catalanes acompañada de cava brut y zumos de frutas. Asimismo, pararemos cerca de la Playa de Montgat para realizar una actividad de buceo de superficie que nos permitirá apreciar la diversidad de la fauna marítima local y su ecosistema. Finalizaremos la excursión en el mismo puerto del que partimos.", 280, 5, "Actividad disponible para todas las edades. Pasarela para silla de ruedas disponible bajo reserva.", ""));
        mockMvc.perform(delete("/api/experiences/" + experience.getId()))
                .andExpect(status().is(200));

        assertThat(experienceRepository.findById(experience.getId()), equalTo(Optional.empty()));
    }
}