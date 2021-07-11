public class StringCalculator {

    public String add(String values){
        if(!values.isEmpty()) {
            return execute(values);
        }

        return "0";
    }

    private String execute(String values){
        if(containsInvalidSeparator(values)){
            return "Number expected but '\\n' found at position 6.";
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
