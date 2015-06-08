package model.entity;

import javax.persistence.*;

/**
 * Created by Marz on 2015-05-31.
 */
@Entity
public class Reviews {
    private int idreviews;
    private String contents;
    private int mark;
    private String usersEmail;
    private int gamesIdgames;
    private Games gamesByGamesIdgames;
    private Users usersByUsersEmail;

    @Id
    @Column(name = "idreviews", nullable = false, insertable = true, updatable = true)
    public int getIdreviews() {
        return idreviews;
    }

    public void setIdreviews(int idreviews) {
        this.idreviews = idreviews;
    }

    @Basic
    @Column(name = "contents", nullable = true, insertable = true, updatable = true, length = 2048)
    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Basic
    @Column(name = "mark", nullable = false, insertable = true, updatable = true)
    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Basic
    @Column(name = "users_email", nullable = false, insertable = true, updatable = true, length = 45)
    public String getUsersEmail() {
        return usersEmail;
    }

    public void setUsersEmail(String usersEmail) {
        this.usersEmail = usersEmail;
    }

    @Basic
    @Column(name = "games_idgames", nullable = false, insertable = true, updatable = true)
    public int getGamesIdgames() {
        return gamesIdgames;
    }

    public void setGamesIdgames(int gamesIdgames) {
        this.gamesIdgames = gamesIdgames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reviews reviews = (Reviews) o;

        if (idreviews != reviews.idreviews) return false;
        if (mark != reviews.mark) return false;
        if (gamesIdgames != reviews.gamesIdgames) return false;
        if (contents != null ? !contents.equals(reviews.contents) : reviews.contents != null) return false;
        if (usersEmail != null ? !usersEmail.equals(reviews.usersEmail) : reviews.usersEmail != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idreviews;
        result = 31 * result + (contents != null ? contents.hashCode() : 0);
        result = 31 * result + mark;
        result = 31 * result + (usersEmail != null ? usersEmail.hashCode() : 0);
        result = 31 * result + gamesIdgames;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "games_idgames", referencedColumnName = "idgames", nullable = false, updatable = false, insertable = false)
    public Games getGamesByGamesIdgames() {
        return gamesByGamesIdgames;
    }

    public void setGamesByGamesIdgames(Games gamesByGamesIdgames) {
        this.gamesByGamesIdgames = gamesByGamesIdgames;
    }

    @ManyToOne
    @JoinColumn(name = "users_email", referencedColumnName = "email", nullable = false, updatable = false, insertable = false)
    public Users getUsersByUsersEmail() {
        return usersByUsersEmail;
    }

    public void setUsersByUsersEmail(Users usersByUsersEmail) {
        this.usersByUsersEmail = usersByUsersEmail;
    }
}
