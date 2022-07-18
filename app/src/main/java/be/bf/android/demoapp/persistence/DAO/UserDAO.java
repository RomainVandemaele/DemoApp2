package be.bf.android.demoapp.persistence.DAO;

import android.icu.text.TimeZoneNames;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
import java.util.Map;

import be.bf.android.demoapp.persistence.entities.User;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface UserDAO {

    @Query("SELECT * FROM user")
    Single<List<User>> getAll();

    //query checked at compile time
    @Query("SELECT * FROM user WHERE user_id IN (:userIds)")
    Single<List<User>>  loadAllByIds(int[] userIds);

    //Observable queries
    @Query("SELECT * FROM user WHERE user_id = :id")
    public Flowable<User> loadUserById(int id);


    @Query("SELECT * FROM user WHERE  first_name = :firstName AND last_name= :lastName")
    Single<User> findByBName(String firstName, String lastName);

    @Query("SELECT first_name FROM User")
    List<String> loadFirstName();
    //public Map<User, List<Book>> loadUserAndBookNames();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public Completable insertAll(User ... users);


    @Delete
    Completable deleteUser(User user);

    @Update
    Completable update(User user);

}
