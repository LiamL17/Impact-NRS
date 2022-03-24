package NRS;

import org.junit.Test;

import java.text.ParseException;
import java.util.*;

import static org.junit.Assert.*;

public class NRSTest {
    NRS nrs = new NRS();

    @Test
    public void outputTest() {
        List<Integer> list = Collections.emptyList();
        assertEquals("", nrs.summarizeCollection(list));

        list = Collections.singletonList(1);
        assertEquals("1", nrs.summarizeCollection(list));

        list = Arrays.asList(1, 3, 4, 5, 7);
        assertEquals("1, 3-5, 7", nrs.summarizeCollection(list));

        list = Arrays.asList(-1, 0, 1, 3, 4, 5, 7);
        assertEquals("[-1,1], 3-5, 7", nrs.summarizeCollection(list));

        list = Arrays.asList(-4, -3, -2, 1, 3, 4, 5, 7);
        assertEquals("[-4,-2], 1, 3-5, 7", nrs.summarizeCollection(list));

        list = Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
        assertEquals("1, 3, 6-8, 12-15, 21-24, 31", nrs.summarizeCollection(list));

        list = Arrays.asList(5, 2, 3, 4, 6, 0, 12, 11, 13, 14, 91, 25, 48, -2);
        assertEquals("[-2], 0, 2-6, 11-14, 25, 48, 91", nrs.summarizeCollection(list));
    }

    @Test
    public void collectTest() {
        List<Integer> list = (List<Integer>) nrs.collect("");
        assertEquals(Collections.emptyList(), list);

        list = (List<Integer>) nrs.collect("1");
        assertEquals(Collections.singletonList(1), list);

        list = (List<Integer>) nrs.collect("-1,1");
        assertEquals(Arrays.asList(-1,1), list);

        list = (List<Integer>) nrs.collect("1,   3, 4   ");
        assertEquals(Arrays.asList(1,3,4), list);

        assertThrows(NumberFormatException.class, () -> nrs.collect("a"));

        assertThrows(NumberFormatException.class, () -> nrs.collect("--1"));

        assertThrows(NumberFormatException.class, () -> nrs.collect("1,2,3,a"));

        list = (List<Integer>) nrs.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
        assertEquals(Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31), list);
    }
}
