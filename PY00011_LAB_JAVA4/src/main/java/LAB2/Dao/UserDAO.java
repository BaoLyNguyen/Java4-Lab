package LAB2.Dao;


import java.util.List;

import LAB2.entity.Userr;

public interface UserDAO {
    List<Userr> findAll();
    Userr findById(String id);
    void create(Userr item);
    void update(Userr item);
    void deleteById(String id);
}
