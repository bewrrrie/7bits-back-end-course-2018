package it.sevenbits;

import it.sevenbits.geom.Segment;

public class Main {

    public static void main(String[] args) {
        Segment[] segments = {
                new Segment(0, 1, 2, 1),
                new Segment(3, 9, -16, 0),
                new Segment(1, 2, 9, 0)
        };
        double maxLength = 0d;

        for (Segment segment : segments) {
            double currentLength = segment.getLength();
            if (currentLength > maxLength) {
                maxLength = currentLength;
            }

            System.out.printf("Current segment length is %6f\n", currentLength);
        }

        System.out.printf("Maximal length is %6f", maxLength);
    }
}
