package com.school.manager.manager.repository;

public interface IEntityGeneric<TEntity> {

    TEntity get(Integer idEntity);

    void add(TEntity tEntity);

    void put(TEntity tEntity);

    void delete(Integer idEntity);

}
