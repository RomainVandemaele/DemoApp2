package be.bf.android.demoapp.persistence.threads;


import androidx.room.Dao;

import java.util.List;

import be.bf.android.demoapp.persistence.DAO.UserDAO;
import be.bf.android.demoapp.persistence.entities.User;

public class DatabaseThread extends Thread {
    private UserDAO dao;
    private List<User> users;

    public UserDAO getDao() {
        return dao;
    }

    public void setDao(UserDAO dao) {
        this.dao = dao;
    }

    @Override
    public void run() {
        User user = new User("Romain","Vandemaele");
        dao.insertAll(user);
    }
}
