package it.sevenbits.backend.fixed_storage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FixedStorage<K, V> implements IFixedStorage<K, V> {
    private final Map<K, V> map;
    private final int capacity;
    private int size;
    private final Logger logger;

    public FixedStorage(final int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;
        this.logger = LoggerFactory.getLogger(FixedStorage.class);
    }

    @Override
    public void add(K key, V value) {
        if (map.keySet().contains(key)) {
            map.put(key, value);
            logger.info(String.format("Element with key %s was replaced.", key.toString()));
        } else if (size < capacity) {
            map.put(key, value);
            size++;
            logger.info(String.format("New element with key %s was added.", key.toString()));
        } else {
            logger.warn("Not enough space in storage for new element! Element is not added!");
        }
    }

    @Override
    public void remove(K key) {
        map.remove(key);
        logger.info(String.format("Element with key %s was removed.", key));
    }

    @Override
    public V get(K key) {
        if (map.get(key) == null) {
            logger.warn(String.format("There is no element having key %s in fixed storage!", key));
        }

        return map.get(key);
    }

    @Override
    public boolean contains(V value) {
        return map.containsValue(value);
    }

    @Override
    public Iterator<Map.Entry<K, V>> iterator() {
        return map.entrySet().iterator();
    }

    @Override
    public String toString() {
        return map.toString();
    }
}
