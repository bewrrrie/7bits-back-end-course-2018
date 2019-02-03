package it.sevenbits.backend.list;

import java.util.List;

public class ListOperator {
    public <T extends Comparable<T>> T max(final List<T> list, final int start, final int end) {
        T max = list.get(start);

        for (int i = start; i < end; i++) {
            if (list.get(i).compareTo(max) > 0) {
                max = list.get(i);
            }
        }

        return max;
    }

    public <T> void changeElementsPosition(final List<T> list, final int i, final int j) {
        T tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }
}
