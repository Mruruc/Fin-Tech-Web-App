package com.mruruc.repository;


import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CRUDRepository<T,ID> {
    default boolean save(T t) throws SQLException {
        return false;
    }

    default ID create(T t) throws SQLException {
        return null;
    }

    List<T> getAll() throws SQLException;
    Optional<T> findById(ID id) throws SQLException;

    T update(ID id, T t) throws SQLException;

    ID delete(ID id) throws SQLException;


    boolean isExists(ID id) throws SQLException;
}
