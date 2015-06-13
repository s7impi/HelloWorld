package model.client;

import model.entity.Games;

import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Date;

/**
 * @author asmolik
 */
@XmlRootElement
public class Game {
    private int gameID;
    private String name;
    private String snippet;
    private String designer;
    private String publisher;
    private Date yearPublished;
    private String numberOfPlayers;
    private String description;
    private String playingTime;
    private String category;
    private String subdomain;
    private String suggestedAge;

    public Game() {

    }

    public Game(Games games) {

    }

    public int getgameID() {
        return gameID;
    }

    public void setgameID(int gameID) {
        this.gameID = gameID;
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

    public Date getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(Date yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(String numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlayingTime() {
        return playingTime;
    }

    public void setPlayingTime(String playingTime) {
        this.playingTime = playingTime;
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

    public String getSuggestedAge() {
        return suggestedAge;
    }

    public void setSuggestedAge(String suggestedAge) {
        this.suggestedAge = suggestedAge;
    }
}
