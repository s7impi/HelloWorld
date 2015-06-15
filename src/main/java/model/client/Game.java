package model.client;

import model.entity.Games;

import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Date;

/**
 * @author asmolik
 */
@XmlRootElement
public class Game {
    private int id;
    private String name;
    private String snippet;
    private String designer;
    private String publisher;
    private Date year_published;
    private String number_of_players;
    private String description;
    private String playing_time;
    private String category;
    private String subdomain;
    private String suggested_age;

    public Game() {

    }

    public Game(Games games) {
        id = games.getIdgames();
        name = games.getName();
        snippet = games.getSnippet();
        designer = games.getDesigner();
        year_published = games.getYearPublished();
        number_of_players = games.getNumberOfPlayers();
        description = games.getLongDescription();
        playing_time = games.getPlayingTime();
        category = games.getCategoriesName();
        subdomain = games.getSubdomain();
        suggested_age = games.getSuggestedAge();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Date getYear_published() {
        return year_published;
    }

    public void setYear_published(Date year_published) {
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

    public String getPlaying_time() {
        return playing_time;
    }

    public void setPlaying_time(String playing_time) {
        this.playing_time = playing_time;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
