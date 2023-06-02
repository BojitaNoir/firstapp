package mx.edu.utez.firstapp.models.user;

import mx.edu.utez.firstapp.models.crud.DaoRepository;
import mx.edu.utez.firstapp.utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoUser implements DaoRepository<User> {
private Connection conn;
private PreparedStatement pstm;
private ResultSet rs;
    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try{

            conn = new MySQLConnection().connect();
            String query ="SELECT * FROM users;";
            pstm = conn.prepareStatement(query);
            rs=pstm.executeQuery();
            while (rs.next()){
                User User = new User();
                User.setId(rs.getLong("id"));
                User.setName(rs.getString("name"));
                User.setLastname(rs.getString("lastname"));
                User.setSurname(rs.getString("surname"));
                User.setBirthday(rs.getString("birthday"));
                User.setUsernarme(rs.getString("username"));
                User.setStatus(rs.getString("status"));
                users.add(User);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoUser.class.getName())
                    .log(Level.SEVERE,"Error FindAll"+ e.getMessage());
        }finally {
            close();
        }
        return users;
    }

    @Override
    public User findOne(Long id) {
        return null;
    }

    @Override
    public boolean save(User object) {
        return false;
    }

    @Override
    public boolean update(User object) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
    public void close(){
        try {
            if(conn!=null) conn.close();
            if (pstm!=null) pstm.close();
            if(rs!=null) pstm.close();
        }catch (SQLException e){

        }
    }
}