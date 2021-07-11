public class StringCalculator {

    public String add(String values){
        if(!values.isEmpty()) {
            return sum(values);
        }

        return "0";
    }

    private String sum(String values){
        if(containsSeparator(values)) {
            String[] valuesSplited = values.split(",|\n");
            double sum = 0.0;
            for (String value : valuesSplited) {
                sum += Double.parseDouble(value);
            }

            if(sum %((int)sum) == 0) return Integer.toString((int)sum);

            return Double.toString(Math.round(sum * 100.0) / 100.0);
        }

        return values;
    }

    private boolean containsSeparator(String values){
        return values.contains(",") || values.contains("\n");
    }
}
