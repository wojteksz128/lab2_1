import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

/**
 * Created by Wojciech Szczepaniak on 14.03.2017.
 */
public class BinarySearchTest {

    @Test
    public void testValueIsInOneElementSeq() {
        int[] seq = {1};
        int value = 1;

        SearchResult result = BinarySearch.search(value, seq);
        assertThat(result.isFound(), is(true));
        assertThat(result.getPosition(), not(-1));
    }

    @Test
    public void testValueIsNotInOneElementSeq() {
        int[] seq = {1};
        int value = 2;

        SearchResult result = BinarySearch.search(value, seq);
        assertThat(result.isFound(), is(false));
        assertThat(result.getPosition(), is(-1));
    }

    @Test
    public void testValueIsFirstElementInSeq() {
        int[] seq = {1, 2, 3};
        int value = 1;
        final int EXPECTED_VALUE = 0;

        SearchResult result = BinarySearch.search(value, seq);
        assertThat(result.isFound(), is(true));
        assertThat(result.getPosition(), is(EXPECTED_VALUE));
    }

    @Test
    public void testValueIsLastElementInSeq() {
        int[] seq = {1, 2, 3};
        int value = 3;
        final int EXPECTED_VALUE = seq.length - 1;

        SearchResult result = BinarySearch.search(value, seq);
        assertThat(result.isFound(), is(true));
        assertThat(result.getPosition(), is(EXPECTED_VALUE));
    }

    @Test
    public void testValueIsCenterElementInSeq() {
        int[] seq = {1, 2, 3};
        int value = 2;
        final int EXPECTED_VALUE = 1;

        SearchResult result = BinarySearch.search(value, seq);
        assertThat(result.isFound(), is(true));
        assertThat(result.getPosition(), is(EXPECTED_VALUE));
    }

    @Test
    public void testValueIsNotInSeq() {
        int[] seq = {1, 2, 3};
        int value = 4;
        final int EXPECTED_VALUE = -1;

        SearchResult result = BinarySearch.search(value, seq);
        assertThat(result.isFound(), is(false));
        assertThat(result.getPosition(), is(EXPECTED_VALUE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptySeq() {
        int[] seq = {};
        int value = 1;

        SearchResult result = BinarySearch.search(value, seq);
    }
}
