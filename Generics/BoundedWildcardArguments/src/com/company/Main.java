package com.company;

public class Main {

    public static void main(String[] args) {
	    // create two dimensional arrays
        TwoD[] twoD = {new TwoD(1, 2),
        new TwoD(6, 8),
        new TwoD(-12, 34),
        new TwoD(-23, -57)};

        // Create coordinates object to hold two dimensional arrays
        Coords<TwoD> twoDCoords = new Coords<>(twoD);
        BoundedWildcard.showXY(twoDCoords);

        // create fourDimensional arrays
        FourD[] fourD = {new FourD(1, 2, 3, 4),
                         new FourD(6, 8, 14, 2),
                         new FourD(-1, 2, -9, 11),
                         new FourD(10, 5, -12, 2)};

        // Create Coordinates objects which holds four dimensional arrays
        Coords<FourD> fourDCoords = new Coords<>(fourD);
        BoundedWildcard.showXY(fourDCoords);
        BoundedWildcard.showXYZ(fourDCoords);
        BoundedWildcard.showAll(fourDCoords);
    }
}
