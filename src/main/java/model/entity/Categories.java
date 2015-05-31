package model.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Marz on 2015-05-31.
 */
@Entity
public class Categories {
    private String name;
    private String description;
    private Collection<Games> gamesByName;

    @Id
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description", nullable = true, insertable = true, updatable = true, length = 2048)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Categories that = (Categories) o;

        return !(name != null ? !name.equals(that.name) : that.name != null) && !(description != null ? !description.equals(that.description) : that.description != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "categoriesByCategoriesName")
    public Collection<Games> getGamesByName() {
        return gamesByName;
    }

    public void setGamesByName(Collection<Games> gamesByName) {
        this.gamesByName = gamesByName;
    }
}
