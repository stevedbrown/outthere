package com.nthread.outthere.random;

/**
 * Created by stephenbrown on 8/25/15.
 */
public class ShiftDivider {
    public int divide(int numerator, int denom) {
        int val = 0, pow = 1;

        while ( denom < numerator ) {
            denom = denom << 1;
            pow = pow << 1;
        }

        while( pow > 0) {
            if (denom <= numerator) {
                numerator -= denom;
                val += pow;
            }
            denom = denom >> 1;
            pow = pow >> 1;
        }

        return val;
    }
}
