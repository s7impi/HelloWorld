package model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import java.io.Serializable;

/**
 * Created by s7impi on 23.05.15.
 */

@NamedQuery(name="model.entity.Game.getAllGames",
            query="SELECT g FROM Game g ")
@Entity
public class Game implements Serializable {
    private static final long serialVersionUID = 913072745186891885L;
    @Id
    private String id;
    private String name;
    private String snippet;
    private String designer;
    private String publisher;
    private String year_published;
    private String number_of_players;
    private String description;
    private String playing_time;
    private String category;
    private String subdomain;
    private String suggested_age;

    public Game() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        return !(id != null ? !id.equals(game.id) : game.id != null);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getYear_published() {
        return year_published;
    }

    public void setYear_published(String year_published) {
        this.year_published = year_published;
    }

    public String getNumber_of_players() {
        return number_of_players;
    }

    public void setNumber_of_players(String number_of_players) {
        this.number_of_players = number_of_players;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPlaying_time() {
        return playing_time;
    }

    public void setPlaying_time(String playing_time) {
        this.playing_time = playing_time;
    }

    public String getSubdomain() {
        return subdomain;
    }

    public void setSubdomain(String subdomain) {
        this.subdomain = subdomain;
    }

    public String getSuggested_age() {
        return suggested_age;
    }

    public void setSuggested_age(String suggested_age) {
        this.suggested_age = suggested_age;
    }
}

