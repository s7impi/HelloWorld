package model.dao;

/**
 * Created by Marz on 2015-05-03.
 */
public interface UserDaoDB {
    void save(UserDB userDB);

    void update(UserDB userDB);

    void delete(UserDB userDB);

    UserDB findByUserId(Long id);
    UserDB findByUserName(String userName);
}
