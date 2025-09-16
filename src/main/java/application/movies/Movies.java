package application.movies;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import application.genres.Genres;
import application.producer.Producer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "movies")
@Setter
@Getter
@NoArgsConstructor
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "id_genre")
    private Genres genre;

    @ManyToMany
    @JoinTable(
        name = "movies_producers",
        joinColumns = @JoinColumn(name = "movie_id"),
        inverseJoinColumns = @JoinColumn(name = "producer_id")
    )
    private Set<Producer> producers;

    public Movies(MoviesDTO data) {
        this.setId(data.id());
        this.setTitle(data.title());
        this.setGenre(new Genres(data.genre()));
        this.setProducers(data.producers().stream().map(Producer::new).collect(Collectors.toSet()));
    }

    public Movies(MoviesInsertDTO data) {
        this.setTitle(data.title());
        Genres genre = new Genres();
        genre.setId(data.genreId());
        this.setGenre(genre);
        
        Set<Producer> producers = data.producersIds().stream().map(p -> new Producer(p)).collect(Collectors.toSet());
        this.setProducers(producers);
    }
}
