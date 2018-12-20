package it.sevenbits.backend.fixed_storage;

import java.util.Map;

public interface IFixedStorage<K, V> extends Iterable<Map.Entry<K, V>> {
    void add(K key, V value);
    void remove(K key);
    V get(K key);
    boolean contains(V value);
}
