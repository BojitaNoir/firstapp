package mx.edu.utez.firstapp.models.user;

import mx.edu.utez.firstapp.models.crud.DaoRepository;

import java.util.List;

public class DaoUser implements DaoRepository<user> {

    @Override
    public List<user> findAll() {
        return null;
    }

    @Override
    public user findOne(Long id) {
        return null;
    }

    @Override
    public boolean save(user object) {
        return false;
    }

    @Override
    public boolean update(user object) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}