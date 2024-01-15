package ma.emsi.backendevents;

import ma.emsi.backendevents.entitie.Events;
import ma.emsi.backendevents.entitie.User;
import ma.emsi.backendevents.enums.EventCategory;
import ma.emsi.backendevents.enums.UserRole;
import ma.emsi.backendevents.repository.EventsRepository;
import ma.emsi.backendevents.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.util.List;

@SpringBootApplication
public class BackendEventsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendEventsApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(EventsRepository eventsRepository) {
        return args -> {
            eventsRepository.saveAll(
                    List.of(
                            Events.builder().eventName("WAC vs RCA").eventCategory(EventCategory.SPORT).eventCity("Casablanca").eventPlace("Complexe sportif de Mohammed V").eventDate(Date.valueOf("2023-10-12")).eventPrice(50).imgUrl("https://www.google.com/url?sa=i&url=https%3A%2F%2Ffr.media7.ma%2Fregarder-le-match-wydad-vs-raja-en-direct%2F&psig=AOvVaw1YEhCNNFPX9uBwcY34bM_e&ust=1705074731764000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCMD6x8vY1YMDFQAAAAAdAAAAABAD").eventDetails("Le derby tant attendu entre Raja Club Athletic et Wydad Athletic Club se tiendra au Stade Mohamed V à Casablanca le 15 Novembre 2023. Ne manquez pas cette confrontation intense entre les deux rivaux historiques du football marocain. Les portes ouvrent à 18h30, et le coup d'envoi est prévu à 20h00. Achetez vos billets dès maintenant!").build(),
                            Events.builder().eventName("Film Nayda \"Kabarha Tsghar\"").eventCategory(EventCategory.CINEMA).eventCity("Rabat").eventPlace("Megarama RABAT").eventDate(Date.valueOf("2023-12-10")).eventPrice(80).imgUrl("https://static.lematin.ma/files/services/cinema/2023/10/b7ac670754bd22e0c5527ebb68083acf.jpg").eventDetails("Film Nayda \"Kabarha Tsghar\" à Megarama RABAT").build(),
                            Events.builder().eventName("Spectacle EN RODAGE").eventCategory(EventCategory.THEATER).eventCity("Casablanca").eventPlace("COMPLEXE CULTUREL Anfa").eventDate(Date.valueOf("2023-11-20")).eventPrice(70).imgUrl("https://comedihaclub.com/wp-content/uploads/2023/11/SITE_3840x2460-2-scaled.jpg").eventDetails("Même après cinq One-man show, un livre et une série sur son quotidien avec sa fille, Maxim Martin n’a pas fini de se dévoiler. En rodage de son 6e show et malgré sa nouvelle vie plus saine,").build()
                    )
            );
            eventsRepository.findAll().forEach(e -> {
                System.out.println(e.getEventName());
            });
        };
    }




}
