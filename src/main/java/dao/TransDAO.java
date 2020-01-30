package dao;


import ent.TRANSLATE;

import java.sql.SQLException;
import java.util.List;

public interface TransDAO {
    //create
    void add(TRANSLATE translate) throws SQLException;

    //read
    List<TRANSLATE > getAll() throws SQLException;

    TRANSLATE getById(Long id);

    //update
    void update(TRANSLATE translate);

    //delete
    void remove(TRANSLATE translate);


}
