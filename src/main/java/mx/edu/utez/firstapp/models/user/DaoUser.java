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
                User.setUsername(rs.getString("username"));
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
        try{

            conn = new MySQLConnection().connect();
            String query ="SELECT * FROM users WHERE id=?;";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1,id);
            rs=pstm.executeQuery();
            User User = new User();
            if (rs.next()){

                User.setId(rs.getLong("id"));
                User.setName(rs.getString("name"));
                User.setLastname(rs.getString("lastname"));
                User.setSurname(rs.getString("surname"));
                User.setBirthday(rs.getString("birthday"));
                User.setUsername(rs.getString("username"));
                User.setStatus(rs.getString("status"));
            }
            return User;
        }catch (SQLException e){
            Logger.getLogger(DaoUser.class.getName())
                    .log(Level.SEVERE,"Error FindOne"+ e.getMessage());
        }finally {
            close();
        }
        return null;
    }
    @Override
    public boolean save(User object) {
        try{
            conn = new MySQLConnection().connect();
            String query ="INSERT INTO users (name,lastname,surname,birthday,username,status) values (?,?,?,?,?,?);";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, object.getName());
            pstm.setString(2, object.getLastname());
            pstm.setString(3,object.getSurname());
            pstm.setString(4, object.getBirthday());
            pstm.setString(5, object.getUsername());
            pstm.setString(6, object.getStatus());
            return pstm.executeUpdate()>0;
        }catch(SQLException e){

        }finally {
            close();
        }

        return false;
    }

    @Override
    public boolean update(User object) {
        try{
            conn = new MySQLConnection().connect();
            String query ="UPDATE users SET name=?,lastname=?,"+
                    "surname=?,birthday=?,username=?,status=? WHERE id=?;";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, object.getName());
            pstm.setString(2, object.getLastname());
            pstm.setString(3,object.getSurname());
            pstm.setString(4, object.getBirthday());
            pstm.setString(5, object.getUsername());
            pstm.setString(6, object.getStatus());
            pstm.setLong(7,object.getId());
            return pstm.executeUpdate()>0;
        }catch(SQLException e){

        }finally {
            close();
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        try{
            conn = new MySQLConnection().connect();
            String query ="SELECT users WHERE id=?;";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1,id);
            return pstm.executeUpdate()==1;
        }catch (SQLException e){
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE,"Error Delete"+ e.getMessage());;
        }finally {
            close();
        }
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