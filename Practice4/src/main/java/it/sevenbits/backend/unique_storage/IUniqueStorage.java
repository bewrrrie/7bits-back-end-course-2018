package it.sevenbits.backend.unique_storage;

public interface IUniqueStorage<T> extends Iterable<T> {
    void add(T element);
    void remove(T element);
    boolean contains(T element);
}
