package application.cast;

import application.cast.artist.Artist;
import application.cast.function.Function;
import application.movies.Movies;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cast {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movies movie;
    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;
    @ManyToOne
    @JoinColumn(name = "function_id")
    private Function function;

    public Cast(CastDTO data) {
        this.setId(data.id());
        this.setMovie(new Movies(data.movie()));
        this.setArtist(new Artist(data.artist()));
        this.setFunction(new Function(data.function()));
    }
}
