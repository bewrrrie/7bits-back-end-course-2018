package it.sevenbits.backend.unique_storage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UniqueStorage<T> implements IUniqueStorage<T> {
    private final List<T> list;
    private final Logger logger;

    public UniqueStorage() {
        this.list = new ArrayList<>();
        this.logger = LoggerFactory.getLogger(UniqueStorage.class);
    }

    @Override
    public void add(T element) {
        if (list.contains(element)) {
            logger.warn("Tried to add element that already contained in unique_storage!");
        } else {
            list.add(element);
            logger.info(String.format("Added element %s.", element.toString()));
        }
    }

    @Override
    public void remove(T element) {
        list.remove(element);
        logger.info(String.format("Removed element %s.", element.toString()));
    }

    @Override
    public boolean contains(T element) {
        return list.contains(element);
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
