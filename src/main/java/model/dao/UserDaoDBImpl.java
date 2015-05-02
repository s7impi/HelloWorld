package model.dao;

/**
 * Created by Marz on 2015-05-03.
 */
import org.hibernate.criterion.Restrictions;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class UserDaoDBImpl extends HibernateDaoSupport implements UserDaoDB {

    public void update(UserDB userDB) {
        getHibernateTemplate().update(userDB);
    }

    public void delete(UserDB userDB) {
        getHibernateTemplate().delete(userDB);
    }

    public UserDB findByUserId(Long id) {

        return (UserDB) getHibernateTemplate().load(UserDB.class, id);

    }

    public UserDB findByUserName(String userName) {

        return (UserDB) getSession().createCriteria(UserDB.class)
                .add(Restrictions.eq("name", userName))
                .uniqueResult();

    }


    public void save(UserDB userDB) {
        getHibernateTemplate().save(userDB);

    }


}
