package service;

import BL.UTIL;
import dao.TransDAO;
import ent.TRANSLATE;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class TransService extends UTIL implements TransDAO {
    Connection connection = getConnection();


    @Override
    public void add(TRANSLATE translate) throws SQLException {
        PreparedStatement preparedStatement = null;

        //String sql = "INSERT INTO TRANSLATE (id, rus_word, eng_word, comment) VALUES(?, ?, ?, ?)";
        String sql = "INSERT INTO TRANSLATE (rus_word, eng_word, comment) VALUES( ?, ?, ?)";


        try {
            preparedStatement = connection.prepareStatement(sql);
            //preparedStatement.setLong(1,translate.getId());
            preparedStatement.setString(1, translate.getRus_word());
            preparedStatement.setString(2, translate.getEng_word());
            preparedStatement.setString(3, translate.getComment());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement!=null) {
                preparedStatement.close();
            } if(connection !=null) {
            connection.close();;
        }
    }}

    @Override
    public List<TRANSLATE> getAll() throws SQLException {
        List<TRANSLATE> translateList = new ArrayList<>();

        String sql = "id, rus_word, eng_word, comment";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                TRANSLATE translate = new TRANSLATE();
                translate.setId(resultSet.getInt("id"));
                translate.setRus_word(resultSet.getString("rus_word"));
                translate.setRus_word(resultSet.getString("eng_word"));
                translate.setRus_word(resultSet.getString("comment"));

                translateList.add(translate);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement!=null) {
                statement.close();
            } if(connection !=null) {
                connection.close();;
            }}

        return translateList;

    }

    @Override
    public TRANSLATE getById(Long id) {
        return null;
    }

    @Override
    public void update(TRANSLATE translate) {

    }

    @Override
    public void remove(TRANSLATE translate) {

    }
}
