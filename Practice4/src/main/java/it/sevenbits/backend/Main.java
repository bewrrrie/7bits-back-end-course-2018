package it.sevenbits.backend;

import it.sevenbits.backend.fixed_storage.FixedStorage;
import it.sevenbits.backend.unique_storage.UniqueStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    final static private int FIXED_CAPACITY = 5;


    private static boolean check(
        final UniqueStorage<Planet> uniqueStorage,
        final FixedStorage<String, Planet> fixedStorage
    ) {
        boolean result = true;

        for (Map.Entry<String, Planet> entry : fixedStorage) {
            result &= uniqueStorage.contains(entry.getValue());
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println("Test UniqueStorage.");
        String[] names = new String[] {"Pluto!", "Mars", "Earth", "Neptune", "Venus"};

//      Test UniqueStorage
        UniqueStorage<Planet> uniqueStorage = new UniqueStorage<>();

        for (String name : names) {
            uniqueStorage.add(new Planet(name));
        }
        System.out.println(String.format("UniqueStorage contains planets: %s.", uniqueStorage));

        Planet colorado = new Planet("Colorado");
        Planet saturn = new Planet("Saturn");
        uniqueStorage.add(colorado);
        uniqueStorage.add(saturn);

        if (!(uniqueStorage.contains(colorado) && uniqueStorage.contains(saturn))) {
            System.out.println("Something wrong with addition!");
        }
        System.out.println(String.format("After addition: %s.", uniqueStorage));

        System.out.println("Trying to add Saturn again...");
        uniqueStorage.add(saturn);
        uniqueStorage.remove(colorado);
        uniqueStorage.remove(saturn);

        if (uniqueStorage.contains(colorado) || uniqueStorage.contains(saturn)) {
            System.out.println("Something wrong with removing!");
        }
        System.out.println(String.format("UniqueStorage contains planets: %s.", uniqueStorage));


//      Test FixedStorage
        System.out.println("\nTest FixedStorage.");
        FixedStorage<String, Planet> fixedStorage = new FixedStorage<>(FIXED_CAPACITY);
        List<String> ids = new ArrayList<>();

        for (String name : names) {
            Planet p = new Planet(name);
            fixedStorage.add(p.getId(), p);
            ids.add(p.getId());
        }

        System.out.println(String.format("FixedStorage contains planets: %s.", fixedStorage));
        System.out.println("Trying to add new element...");
        fixedStorage.add(colorado.getId(), colorado);

        System.out.println("Trying to replace existing element...");
        fixedStorage.add(ids.get(0), saturn);

        if (fixedStorage.contains(colorado) || !fixedStorage.contains(saturn)) {
            System.out.println("Something wrong with addition!");
        }
        System.out.println(String.format("After addition: %s.", fixedStorage));

        System.out.println("Removing Saturn...");
        fixedStorage.remove(saturn.getId());

        if (fixedStorage.contains(saturn)) {
            System.out.println("Something wrong with removing!");
        }
        System.out.println(String.format("UniqueStorage contains planets: %s.", fixedStorage));


        System.out.println(
            String.format("\nChecking if UniqueStorage contains" +
                           " all elements of FixedStorage...\n Result: %b.",
                          check(uniqueStorage, fixedStorage))
        );
    }
}
