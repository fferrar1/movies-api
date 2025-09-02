package application.movies;

import application.genres.Genres;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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

    public Movies(MoviesDTO data) {
        this.setId(data.id());
        this.setTitle(data.title());
        this.setGenre(new Genres(data.genre()));
    }

    public Movies(MoviesInsertDTO data) {
        this.setTitle(data.title());
        Genres genre = new Genres();
        genre.setId(data.genreId());
        this.setGenre(genre);
    }
}
