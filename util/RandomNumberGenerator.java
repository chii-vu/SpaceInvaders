/*
  CMPT 270 Course Material
  Copyright (c) 2003-2021
  J.P. Tremblay and Grant Cheston
  All rights reserved.

  This document contains resources for homework assigned to students of
  CMPT 270 and shall not be distributed without permission.  Posting this
  file to a public or private website, or providing this file to any person
  not registered in CMPT 270 constitutes Academic Misconduct according to
  the University of Saskatchewan Policy on Academic Misconduct.
 */

package util;

import java.util.Random;

/**
 * A random number generator that is a Singleton.
 */
public class RandomNumberGenerator {
    /** The one instance for this Singleton class. */
    private static RandomNumberGenerator instance = null;

    /**
     * @return the sole random generator
     */
    public static RandomNumberGenerator getInstance() {
        if (instance == null) {
            instance = new RandomNumberGenerator();
        }
        return instance;
    }

    /** The actual random number generator used to generate the numbers. */
    private Random random;

    /**
     * Initialize the random number generator using the current time for the seed value.
     */
    private RandomNumberGenerator() {
        random = new Random(System.currentTimeMillis());
    }

    /**
     * @return The next random int uniformly distributed amongst all possible values.
     */
    public int getInt() {
        return random.nextInt();
    }

    /**
     * @return The next random int uniformly distributed amongst 0 to n-1 (inclusive).
     */
    public int getInt(int n) {
        return random.nextInt(n);
    }

    /**
     * @return The next random long uniformly distributed amongst all possible values.
     */
    public long getLong() {
        return random.nextLong();
    }

    /**
     * @return The next random float value uniformly distributed between 0.0 and 1.0.
     */
    public float getFloat() {
        return random.nextFloat();
    }

    /**
     * @return The next random double uniformly distributed between 0.0 and 1.0.
     */
    public double getDouble() {
        return random.nextDouble();
    }
}
