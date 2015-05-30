package model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * klasa reprezentuj¹ca encjê games
 * Created by s7impi on 23.05.15.
 */
@Entity(name = "games")
public class Game implements Serializable {
    private static final long serialVersionUID = 913072745186891885L;
    @Id
    @Column(name = "idgames")
    private int id;
    @Column(name ="name",nullable = false)
    private String name;
    @Column(name = "snippet")
    private String snippet;
    @Column(name = "designer")
    private String designer;
    @Column(name = "year_published")
    private Date year_published;
    @Column(name = "number_of_players")
    private String number_of_players;
    @Column(name = "short_description", nullable = false)
    private String short_description;
    @Column(name = "long_description")
    private String long_description;
    @Column(name = "playing_time")
    private String playing_time;
    @Column(name = "categories_name", nullable = false)
    private String category;
    @Column(name = "subdomain")
    private String subdomain;
    @Column(name = "suggested_age")
    private String suggested_age;
    @Column(name = "price", precision = 2, nullable = false)
    private float price;
    @Column(name = "promotion_price", precision = 2, nullable = false)
    private float promotion_price;
    @Column(name = "promotion_deadline")
    private Date promotion_deadline;

    public Game(String name, String category, String short_description) {
        this.name = name;
        this.category = category;
        this.short_description = short_description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        return id != game.id;
    }

    @Override
    public int hashCode() {
        // TODOa
        return id;
    }

    public Date getYear_published() {
        return year_published;
    }

    public void setYear_published(Date year_published) {
        this.year_published = year_published;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getLong_description() {
        return long_description;
    }

    public void setLong_description(String long_description) {
        this.long_description = long_description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPromotion_price() {
        return promotion_price;
    }

    public void setPromotion_price(float promotion_price) {
        this.promotion_price = promotion_price;
    }

    public Date getPromotion_deadline() {
        return promotion_deadline;
    }

    public void setPromotion_deadline(Date promotion_deadline) {
        this.promotion_deadline = promotion_deadline;
    }

    public Game() {
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



    public String getNumber_of_players() {
        return number_of_players;
    }

    public void setNumber_of_players(String number_of_players) {
        this.number_of_players = number_of_players;
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

