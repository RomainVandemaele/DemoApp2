package be.bf.android.demoapp.persistence;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import be.bf.android.demoapp.persistence.DAO.UserDAO;
import be.bf.android.demoapp.persistence.entities.User;

@Database( entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDAO userDAO();
}
