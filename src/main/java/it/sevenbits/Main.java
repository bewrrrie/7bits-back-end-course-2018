package it.sevenbits;

import it.sevenbits.geom.Segment;

public class Main {

    public static void main(String[] args) {
        Segment[] segments = {
                new Segment(0, 1, 2, 1),
                new Segment(3, 9, -16, 0),
                new Segment(1, 2, 9, 0)
        };

        for (Segment segment : segments) {
            System.out.printf("Current segment length is %6f\n", segment.getLength());
        }
    }
}
