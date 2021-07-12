import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public String add(String values){
        if(!values.isEmpty()) {
            if(missingLastPosition(values)) return "Number expected but EOF found.";

            return execute(values);
        }

        return "0";
    }

    private boolean missingLastPosition(String values){
        return values.endsWith(",");
    }

    private String execute(String values){
        if(containsInvalidSeparator(values)){
            Matcher matches_1 = Pattern.compile(",\n").matcher(values);

            if(matches_1.find()){
                String pos = Integer.toString(matches_1.start()+1);
                return "Number expected but '\\n' found at position "+pos+".";
            }

            Matcher matches_2 = Pattern.compile("\n,").matcher(values);

            if(matches_2.find()){
                String pos = Integer.toString(matches_2.start()+1);
                return "Number expected but '\\n' found at position "+pos+".";
            }
        }

        if(containsSeparator(values)) {
            return sum(values);
        }

        return values;
    }

    private String sum(String values){
        String[] valuesSplited = values.split(",|\n");
        double sum = 0.0;
        for (String value : valuesSplited) {
            sum += Double.parseDouble(value);
        }

        if(sum %((int)sum) == 0) return Integer.toString((int)sum);

        return Double.toString(Math.round(sum * 100.0) / 100.0);
    }

    private boolean containsSeparator(String values){
        return values.contains(",") || values.contains("\n")
                && !values.contains(",\n") || !values.contains("\n,");
    }

    private boolean containsInvalidSeparator(String values) {
        return values.contains(",\n") || values.contains("\n,");
    }
}
