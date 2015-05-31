package model.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by Marz on 2015-05-31.
 */
@Entity
public class Games {
    private int idgames;
    private String shortDescription;
    private String longDescription;
    private float price;
    private float promotionPrice;
    private Date promotionDeadline;
    private String name;
    private String categoriesName;
    private String snippet;
    private String designer;
    private String numberOfPlayers;
    private String playingTime;
    private String subdomain;
    private String suggestedAge;
    private Date yearPublished;
    private Collection<CartsHasGames> cartsHasGamesByIdgames;
    private Categories categoriesByCategoriesName;
    private Collection<OrdersHasGames> ordersHasGamesByIdgames;
    private Collection<Reviews> reviewsesByIdgames;
    private Collection<TransactionsHasGames> transactionsHasGamesByIdgames;

    @Id
    @GeneratedValue
    @Column(name = "idgames", nullable = false, insertable = true, updatable = true)
    public int getIdgames() {
        return idgames;
    }

    public void setIdgames(int idgames) {
        this.idgames = idgames;
    }

    @Basic
    @Column(name = "short_description", nullable = false, insertable = true, updatable = true, length = 255)
    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @Basic
    @Column(name = "long_description", nullable = true, insertable = true, updatable = true, length = 2048)
    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    @Basic
    @Column(name = "price", nullable = false, insertable = true, updatable = true, precision = 0)
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Basic
    @Column(name = "promotion_price", nullable = false, insertable = true, updatable = true, precision = 0)
    public float getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(float promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    @Basic
    @Column(name = "promotion_deadline", nullable = true, insertable = true, updatable = true)
    public Date getPromotionDeadline() {
        return promotionDeadline;
    }

    public void setPromotionDeadline(Date promotionDeadline) {
        this.promotionDeadline = promotionDeadline;
    }

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "categories_name", nullable = false, insertable = true, updatable = true, length = 45)
    public String getCategoriesName() {
        return categoriesName;
    }

    public void setCategoriesName(String categoriesName) {
        this.categoriesName = categoriesName;
    }

    @Basic
    @Column(name = "snippet", nullable = true, insertable = true, updatable = true, length = 45)
    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    @Basic
    @Column(name = "designer", nullable = true, insertable = true, updatable = true, length = 45)
    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    @Basic
    @Column(name = "number_of_players", nullable = true, insertable = true, updatable = true, length = 45)
    public String getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(String numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    @Basic
    @Column(name = "playing_time", nullable = true, insertable = true, updatable = true, length = 45)
    public String getPlayingTime() {
        return playingTime;
    }

    public void setPlayingTime(String playingTime) {
        this.playingTime = playingTime;
    }

    @Basic
    @Column(name = "subdomain", nullable = true, insertable = true, updatable = true, length = 45)
    public String getSubdomain() {
        return subdomain;
    }

    public void setSubdomain(String subdomain) {
        this.subdomain = subdomain;
    }

    @Basic
    @Column(name = "suggested_age", nullable = true, insertable = true, updatable = true, length = 45)
    public String getSuggestedAge() {
        return suggestedAge;
    }

    public void setSuggestedAge(String suggestedAge) {
        this.suggestedAge = suggestedAge;
    }

    @Basic
    @Column(name = "year_published", nullable = true, insertable = true, updatable = true)
    public Date getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(Date yearPublished) {
        this.yearPublished = yearPublished;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Games games = (Games) o;

        if (idgames != games.idgames) return false;
        if (Float.compare(games.price, price) != 0) return false;
        if (Float.compare(games.promotionPrice, promotionPrice) != 0) return false;
        if (shortDescription != null ? !shortDescription.equals(games.shortDescription) : games.shortDescription != null)
            return false;
        if (longDescription != null ? !longDescription.equals(games.longDescription) : games.longDescription != null)
            return false;
        if (promotionDeadline != null ? !promotionDeadline.equals(games.promotionDeadline) : games.promotionDeadline != null)
            return false;
        if (name != null ? !name.equals(games.name) : games.name != null) return false;
        if (categoriesName != null ? !categoriesName.equals(games.categoriesName) : games.categoriesName != null)
            return false;
        if (snippet != null ? !snippet.equals(games.snippet) : games.snippet != null) return false;
        if (designer != null ? !designer.equals(games.designer) : games.designer != null) return false;
        if (numberOfPlayers != null ? !numberOfPlayers.equals(games.numberOfPlayers) : games.numberOfPlayers != null)
            return false;
        if (playingTime != null ? !playingTime.equals(games.playingTime) : games.playingTime != null) return false;
        if (subdomain != null ? !subdomain.equals(games.subdomain) : games.subdomain != null) return false;
        if (suggestedAge != null ? !suggestedAge.equals(games.suggestedAge) : games.suggestedAge != null) return false;
        if (yearPublished != null ? !yearPublished.equals(games.yearPublished) : games.yearPublished != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idgames;
        result = 31 * result + (shortDescription != null ? shortDescription.hashCode() : 0);
        result = 31 * result + (longDescription != null ? longDescription.hashCode() : 0);
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        result = 31 * result + (promotionPrice != +0.0f ? Float.floatToIntBits(promotionPrice) : 0);
        result = 31 * result + (promotionDeadline != null ? promotionDeadline.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (categoriesName != null ? categoriesName.hashCode() : 0);
        result = 31 * result + (snippet != null ? snippet.hashCode() : 0);
        result = 31 * result + (designer != null ? designer.hashCode() : 0);
        result = 31 * result + (numberOfPlayers != null ? numberOfPlayers.hashCode() : 0);
        result = 31 * result + (playingTime != null ? playingTime.hashCode() : 0);
        result = 31 * result + (subdomain != null ? subdomain.hashCode() : 0);
        result = 31 * result + (suggestedAge != null ? suggestedAge.hashCode() : 0);
        result = 31 * result + (yearPublished != null ? yearPublished.hashCode() : 0);
        return result;
    }

    public Games() {
        price = 0;
        promotionPrice = 0;
    }

    @OneToMany(mappedBy = "gamesByGamesIdgames")
    public Collection<CartsHasGames> getCartsHasGamesByIdgames() {
        return cartsHasGamesByIdgames;
    }

    public void setCartsHasGamesByIdgames(Collection<CartsHasGames> cartsHasGamesByIdgames) {
        this.cartsHasGamesByIdgames = cartsHasGamesByIdgames;
    }

    @ManyToOne
    @JoinColumn(name = "categories_name", referencedColumnName = "name", nullable = false, updatable = false, insertable = false)
    public Categories getCategoriesByCategoriesName() {
        return categoriesByCategoriesName;
    }

    public void setCategoriesByCategoriesName(Categories categoriesByCategoriesName) {
        this.categoriesByCategoriesName = categoriesByCategoriesName;
    }

    @OneToMany(mappedBy = "gamesByGamesIdgames")
    public Collection<OrdersHasGames> getOrdersHasGamesByIdgames() {
        return ordersHasGamesByIdgames;
    }

    public void setOrdersHasGamesByIdgames(Collection<OrdersHasGames> ordersHasGamesByIdgames) {
        this.ordersHasGamesByIdgames = ordersHasGamesByIdgames;
    }

    @OneToMany(mappedBy = "gamesByGamesIdgames")
    public Collection<Reviews> getReviewsesByIdgames() {
        return reviewsesByIdgames;
    }

    public void setReviewsesByIdgames(Collection<Reviews> reviewsesByIdgames) {
        this.reviewsesByIdgames = reviewsesByIdgames;
    }

    @OneToMany(mappedBy = "gamesByGamesIdgames")
    public Collection<TransactionsHasGames> getTransactionsHasGamesByIdgames() {
        return transactionsHasGamesByIdgames;
    }

    public void setTransactionsHasGamesByIdgames(Collection<TransactionsHasGames> transactionsHasGamesByIdgames) {
        this.transactionsHasGamesByIdgames = transactionsHasGamesByIdgames;
    }
}
