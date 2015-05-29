package model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Klasa reprezentuj¹ca encjê categories
 * Created by Marz on 2015-05-29.
 */

@Entity(name = "categories")
public class Category implements Serializable {

    /**
     * nazwa kategori
     */
    @Id
    @Column(name = "name", nullable = false)
    private String name;


    /**
     * opis kategori, do 2048 znakow
     */
    @Column(name = "description", nullable = true)
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
