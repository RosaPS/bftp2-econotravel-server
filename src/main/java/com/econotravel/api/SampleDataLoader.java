package com.econotravel.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;



@Component
public class SampleDataLoader {
    private ExperienceRepository experienceRepository;

    @Autowired
    public SampleDataLoader (ExperienceRepository experienceRepository){
        this.experienceRepository = experienceRepository;
    }

    @PostConstruct
    public void loadSampleData(){
        experienceRepository.saveAll(List.of(

<<<<<<< HEAD
                new Experience("Paseo en bicicleta por el Montseny", "Disfruta de un hermoso paseo en bicicleta por el increíble Parque Natural del Montseny. Una escapada veraniega perfecta" +
                        " para parejas, familias y amigos que nos permitirá conocer nuevos y sorprendentes lugares. El recorrido que os proponemos comienza con una larga subida con algunos descansos, combinando " +
                        "asfalto y pistas anchas, culminando en un mirador con magníficas vistas del Vallés y el mar. Desde aquí continuaremos la bajada combinando senderos, pistas y algún tramo de carretera y terreno " +
                        "mixto para visitar la zona de Santa Fe, donde descubriremos la Ermita y el Bosque de las Secuoyas. Para finalizar, acudiremos al restaurante María Rosa de Palautordera, donde disfrutaremos de una excelente " +
                        "comida casera con butifarra blanca y negra y munxetes del Montseny.",
                        250,
                        5,
                        "Montaña, bicicleta, excursión larga",
                        "https://www.kolotrip.com/wp-content/uploads/2019/12/mejores-viajes-en-bicicleta.jpg"  ),


                new Experience("Descubre la costa en barco de vela", "Disfruta de un hermoso paseo acuático en barco de vela por la increíble costa de Barcelona. Una escapada veraniega apta incluso para los días " +
                        "más calurosos del año. Descubre los encantadores alrededores de la ciudad de Barcelona y visita desde el mar sus más impresionantes playas y calas. \n" +
                        "Comenzaremos la excursión en el Puerto de Barcelona, desde donde partiremos hacia el norte para visitar playas como la Mar Bella, la Playa de la Mora y la Playa de los Pescadores. \n" +
                        "A bordo de la embarcación podremos disfrutar de una selección de quesos y embutidos catalanes acompañada de cava brut y zumos de frutas. Asimismo, pararemos cerca de la Playa de Montgat " +
                        "para realizar una actividad de buceo de superficie que nos permitirá apreciar la diversidad de la fauna marítima local y su ecosistema. Finalizaremos la excursión en el mismo puerto del que partimos. " +
                        "\n",280,
                        4,
                        "Barco, barco, excursión larga",
                        "https://slack-imgs.com/?c=1&o1=ro&url=https%3A%2F%2Festaticos-cdn.elperiodico.com%2Fclip%2F6b4edfb8-9dfd-4141-9a5b-0f9af229b295_16-9-aspect-ratio_default_0.jpg"),


                new Experience("Descubre la Barcelona Modernista de noche", "Desplazarse a pie es una de las mejores formas de descubrir las maravillas modernistas que se esconden en el barcelonés distrito del " +
                        "Eixample, ubicado en el centro de la ciudad. En esta excursión de cuatro horas, descubriremos los principales emblemas del modernismo y visitaremos los templos y edificios más célebres del arquitecto Gaudí. \n" +
                        "El tour incluye visita guiada al interior de la Casa Batlló y la Sagrada Familia, así como parada para cenar en el restaurante típico catalán Can Masiá, donde disfrutaremos de las mejores carnes de la región " +
                        "acompañadas de vinos de las tierras del Baix Empordá. El restaurante también ofrece opciones vegetarianas y veganas así como menú para niños. Cava aparte. \n",
                        200,
                        4,
                        "Ciudad, a pie, excursión larga",
                        "https://slack-imgs.com/?c=1&o1=ro&url=https%3A%2F%2Fmedia.istockphoto.com%2Fphotos%2Fstained-glass-windows-of-the-lower-floors-of-casa-batllo-picture-id1097254856%3Fk%3D20%26m%3D1097254856%26s%3D170667a%26w%3D0%26h%3DWYyJnOHwrPc5a2tQ7Bnbty05yMvZIMw0eIL9BFilqUA%3D"),


                new Experience("Del huerto a la mesa","Comparte con los más pequeños las maravillas de la naturaleza. En esta excursión breve de tres horas, podréis plantar vuestras propias hortalizas y verduras en el huerto de Can Gilabert, ubicado en el corazón del Montbaig. " +
                        "Durante una hora y media, aprenderéis a cuidar de vuestro propio huerto, plantaréis y abonaréis vuestras propias plantas, y también recogeréis parte de los ingredientes que los expertos chefs de Can Gilabert utilizarán para preparar la posterior cena, donde disfrutaréis " +
                        "de la experiencia de consumir productos recién recogidos de la tierra con vuestras propias manos. Actividad ideal para familiarizar a los más pequeños de la familia con el estilo de vida rural y la agricultura sostenible. Asimismo, obtendréis como obsequio una botella de " +
                        "aceite virgen extra cultivado y preparado en Can Gilabert, obra de la familia Gilabert, que lleva más de 80 años cultivando olivos. \n",
                        145,
                        3,
                        "Montaña,a pie, excursión corta",
                        "http://itparty.es/wp-content/uploads/2021/05/huertos-urbanos-940x480.jpg"),


                new Experience("Arte en la montaña sagrada ", "Disfruta de la impresionante Montaña de Montserrat donde encontraréis el Museo con las salas modernistas de Puig i Cadafalch, lugar que acoge colecciones de gran valor en el corazón de la emblemática montaña. En el Museo " +
                        "encontraréis pinturas del Renacimiento y del Barroco que conviven con autores de los siglos XIX y XX, objetos del Próximo Oriente y orfebrería. Además de disfrutar de un paseo guiado por la montaña y el Museo, esta actividad incluye tentempié variado acompañado de vino espumoso, " +
                        "cava brut o refresco. \n",
                        125,
                        2,
                        "Montaña, a pie, excursión corta", "https://slack-imgs.com/?c=1&o1=ro&url=https%3A%2F%2Fmedia.gettyimages.com%2Fphotos%2Fsanta-maria-de-montserrat-abbey-monistrol-de-montserrat-picture-id866537498%3Fs%3D2048x2048")
=======
                new Experience("Paseo en bicicleta por el Montseny", "Disfruta de un hermoso paseo en bicicleta por el increíble Parque Natural del Montseny.", "Disfruta de un hermoso paseo en bicicleta por el increíble Parque Natural del Montseny. Una escapada veraniega perfecta para parejas, familias y amigos que nos permitirá conocer nuevos y sorprendentes lugares. El recorrido que os proponemos comienza con una larga subida con algunos descansos, combinando asfalto y pistas anchas, culminando en un mirador con magníficas vistas del Vallés y el mar. Desde aquí continuaremos la bajada combinando senderos, pistas y algún tramo de carretera y terreno mixto para visitar la zona de Santa Fe, donde descubriremos la Ermita y el Bosque de las Secuoyas. Para finalizar, acudiremos al restaurante María Rosa de Palautordera, donde disfrutaremos de una excelente comida casera con butifarra blanca y negra y munxetes del Montseny.", 250,5,  "Montaña, bicicleta, excursión larga", "https://www.kolotrip.com/wp-content/uploads/2019/12/mejores-viajes-en-bicicleta.jpg"  ),


                new Experience("Descubre la costa en barco de vela", "Disfruta de un hermoso paseo acuático en barco de vela por la increíble costa de Barcelona.","Disfruta de un hermoso paseo acuático en barco de vela por la increíble costa de Barcelona. Una escapada veraniega apta incluso para los días más calurosos del año. Descubre los encantadores alrededores de la ciudad de Barcelona y visita desde el mar sus más impresionantes playas y calas. \n" +
                        "Comenzaremos la excursión en el Puerto de Barcelona, desde donde partiremos hacia el norte para visitar playas como la Mar Bella, la Playa de la Mora y la Playa de los Pescadores. \n" +
                        "A bordo de la embarcación podremos disfrutar de una selección de quesos y embutidos catalanes acompañada de cava brut y zumos de frutas. Asimismo, pararemos cerca de la Playa de Montgat para realizar una actividad de buceo de superficie que nos permitirá apreciar la diversidad de la fauna marítima local y su ecosistema. Finalizaremos la excursión en el mismo puerto del que partimos. \n",280, 4, "Playa, barco, excursión larga", "https://slack-imgs.com/?c=1&o1=ro&url=https%3A%2F%2Festaticos-cdn.elperiodico.com%2Fclip%2F6b4edfb8-9dfd-4141-9a5b-0f9af229b295_16-9-aspect-ratio_default_0.jpg"),


                new Experience("Descubre la Barcelona Modernista de noche", "La mejor forma de descubrir las maravillas modernistas que se esconden en el barcelonés distrito del Eixample", "Desplazarse a pie es una de las mejores formas de descubrir las maravillas modernistas que se esconden en el barcelonés distrito del Eixample, ubicado en el centro de la ciudad. En esta excursión de cuatro horas, descubriremos los principales emblemas del modernismo y visitaremos los templos y edificios más célebres del arquitecto Gaudí. \n" +
                        "El tour incluye visita guiada al interior de la Casa Batlló y la Sagrada Familia, así como parada para cenar en el restaurante típico catalán Can Masiá, donde disfrutaremos de las mejores carnes de la región acompañadas de vinos de las tierras del Baix Empordá. El restaurante también ofrece opciones vegetarianas y veganas así como menú para niños. Cava aparte. \n",200, 4, "Ciudad, a pie, excursión larga", "https://slack-imgs.com/?c=1&o1=ro&url=https%3A%2F%2Fmedia.istockphoto.com%2Fphotos%2Fstained-glass-windows-of-the-lower-floors-of-casa-batllo-picture-id1097254856%3Fk%3D20%26m%3D1097254856%26s%3D170667a%26w%3D0%26h%3DWYyJnOHwrPc5a2tQ7Bnbty05yMvZIMw0eIL9BFilqUA%3D"),


                new Experience("Del huerto a la mesa", "Comparte con los más pequeños las maravillas de la naturaleza.","Comparte con los más pequeños las maravillas de la naturaleza. En esta excursión breve de tres horas, podréis plantar vuestras propias hortalizas y verduras en el huerto de Can Gilabert, ubicado en el corazón del Montbaig. Durante una hora y media, aprenderéis a cuidar de vuestro propio huerto, plantaréis y abonaréis vuestras propias plantas, y también recogeréis parte de los ingredientes que los expertos chefs de Can Gilabert utilizarán para preparar la posterior cena, donde disfrutaréis de la experiencia de consumir productos recién recogidos de la tierra con vuestras propias manos. Actividad ideal para familiarizar a los más pequeños de la familia con el estilo de vida rural y la agricultura sostenible. Asimismo, obtendréis como obsequio una botella de aceite virgen extra cultivado y preparado en Can Gilabert, obra de la familia Gilabert, que lleva más de 80 años cultivando olivos. \n", 145, 3, "Montaña,a pie, excursión corta", "http://itparty.es/wp-content/uploads/2021/05/huertos-urbanos-940x480.jpg"),


                new Experience("Arte en la montaña sagrada ","Disfruta de la impresionante Montaña de Montserrat ", "Disfruta de la impresionante Montaña de Montserrat donde encontraréis el Museo con las salas modernistas de Puig i Cadafalch, lugar que acoge colecciones de gran valor en el corazón de la emblemática montaña. En el Museo encontraréis pinturas del Renacimiento y del Barroco que conviven con autores de los siglos XIX y XX, objetos del Próximo Oriente y orfebrería. Además de disfrutar de un paseo guiado por la montaña y el Museo, esta actividad incluye tentempié variado acompañado de vino espumoso, cava brut o refresco. \n", 125, 2, "Montaña, a pie, excursión corta", "https://slack-imgs.com/?c=1&o1=ro&url=https%3A%2F%2Fmedia.gettyimages.com%2Fphotos%2Fsanta-maria-de-montserrat-abbey-monistrol-de-montserrat-picture-id866537498%3Fs%3D2048x2048")
>>>>>>> d17dbdc020ad430712c2f0c358b82bef27e15dd3
        ));
    }
}