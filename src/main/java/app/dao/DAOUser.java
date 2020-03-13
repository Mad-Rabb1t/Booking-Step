package app.dao;

import app.entity.User;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

public class DAOUser implements DAO<User> {

    @Override
    public Optional<User> get(int id) {
        return Optional.empty();
    }

    @Override
    public Collection<User> getAll() {
        return null;
    }

    @Override
    public Collection<User> getAllBy(Predicate<User> p) {
        return null;
    }

    @Override
    public void create(User data) {

    }

    @Override
    public void delete(int id) {

    }
}
