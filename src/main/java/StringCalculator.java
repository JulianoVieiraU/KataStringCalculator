public class StringCalculator {

    public String add(String values){
        if(!values.isEmpty()) {
            if(values.contains(",")) {
                String[] valuesSplited = values.split(",");
                double sum = 0.0;
                for (String value : valuesSplited) {
                    sum += Double.parseDouble(value);
                }
                return Double.toString(Math.round(sum * 100.0) / 100.0);
            }

            return values;
        }

        return "0";
    }
}
