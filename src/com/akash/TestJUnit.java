package com.akash;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by akash on 2/19/17.
 */


public class TestJUnit {
    @Test
    public void testMin(){
        Solution test = new Solution();
        char a[][]= {{'1', '2', '3','a'},
                {'4', '8', '7','b'},
                {'9', '5', '6','c'}};

        assertEquals("Starting point is (0,0) and mincostpath is 2",test.findShortestDistance(a,'1','7'));
    }

    @Test
    public void dynamic(){
        DynamicSolution test = new DynamicSolution();
        char a[][]= {{'1', '2', '3','a'},
                {'4', '8', '7','b'},
                {'9', '5', '6','c'}};
        assertEquals("Starting point is (0,0) and mincostpath is 3",test.findShortestCost(a,'1','b'));
    }

}
