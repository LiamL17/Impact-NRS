package NRS;

import java.util.*;
import java.util.stream.Collectors;

public class NRS implements NumberRangeSummarizer {

    /**
     * Returns a list of integers extracted from a string.
     *
     * @param input a string with comma separated integer values
     * @return      a list of integers
     */
    public Collection<Integer> collect(String input) {
        input = input.replaceAll(" ", "");

        List<Integer> list = new ArrayList<>();
        if (input.equals("")) {
            return Collections.emptyList();
        }

        list = Arrays.stream(input.split(","))
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());

        return list;
    }

    /**
     * @author Liam Louw
     *
     * Returns a string with comma seperated values or ranges.
     *
     * @param input collection of integers
     * @return      the string of each of the integers grouped into ranges
     */
    public String summarizeCollection(Collection<Integer> input) {

        StringBuilder sb = new StringBuilder();
        List<Integer> list = (List<Integer>) input;

        list = list.stream().sorted().collect(Collectors.toList());

        if (list.size() == 1) {
            return "" + list.get(0);
        }

        if (list.size() == 0) {
            return "";
        }

        int prev = list.get(0), start = prev;
        for(int next: list.subList(1, list.size())) {
            if(prev + 1 != next) {
                if (start < 0) {
                    sb.append("[").append(start);
                    if(start != prev) {
                        sb.append(prev - start > 1 ? ".." : ", ")
                                .append(prev);
                    }
                    sb.append("]");
                } else {
                    sb.append(start);
                    if(start != prev) {
                        sb.append(prev - start > 1 ? "-" : ", ")
                                .append(prev);
                    }
                }
                sb.append(", ");
                start = next;
            }
            prev = next;
        }
        sb.append(start);
        return sb.toString();
    }
}
