package br.edu.ifpi.booknote.dao;

import java.util.List;

public interface DAO<T> {

    public void deletar(T p);

    public T getById(int p);

    public List<T> getAll();

}
