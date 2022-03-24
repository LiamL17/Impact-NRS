package NRS;

import java.util.Collection;

/**
 * @author Werner
 *
 * Implement this Interface to produce a comma delimited list of numbers,
 * grouping the numbers into a range when they are sequential.
 *
 *
 * "1,3,4,5,7"
 * Sample Input: "1,3,6,7,8,12,13,14,15,21,22,23,24,31"
 * How will we get input?
 *
 * - Command line (string, integer, separtor?)
 * - File (string, integer, separtor?)
 *
 * Will input be sorted, if not sort it for ease of calculation
 *
 * Result: "1, 3, 6-8, 12-15, 21-24, 31"
 *
 * The code will be evaluated on
 *   - functionality
 *   - style
 *   - robustness
 *   - best practices
 *   - unit tests
 */
public interface NumberRangeSummarizer {

    //collect the input
    Collection<Integer> collect(String input) throws Exception;

    //get the summarized string
    String summarizeCollection(Collection<Integer> input);

}


