import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Data {

    @JsonProperty("Fibonacci")
    private List Fibonacci;
    @JsonProperty("Conway")
    private List Conway;

    public Data() {
    }

    public Data(List Fibonacci, List Conway) {
        this.Conway = Conway;
        this.Fibonacci = Fibonacci;
    }

    @JsonProperty("Fibonacci")
    public List getFibonacci() {
        return this.Fibonacci;
    }

    @JsonProperty("Fibonacci")
    public void setFibonacci(List Fibonacci) {
        this.Fibonacci = Fibonacci;
    }

    @JsonProperty("Conway")
    public List getConway() {
        return this.Conway;
    }

    @JsonProperty("Conway")
    public void setConway(List Conway) {
        this.Conway = Conway;
    }

    @Override
    public String toString() {

        int maxSize = Math.max(Conway.size(), Fibonacci.size());
        StringBuilder result = new StringBuilder();

        result.append("|");
        result.append(" ".repeat(Fibonacci
                .get(Fibonacci.size() - 1).toString().length() / 2));
        result.append("Fibonacci");
        result.append(" ".repeat(Fibonacci
                .get(Fibonacci.size() - 1).toString().length() / 2));

        int fibSize = result.length() - 1;

        result.append("|");
        result.append(" ".repeat(Conway
                .get(Conway.size() - 1).toString().length() / 2));
        result.append("Conway");
        result.append(" ".repeat(Conway
                .get(Conway.size() - 1).toString().length() / 2));

        int conSize = result.length() - fibSize - 2;

        result.append("|");
        appendLine(result, fibSize, conSize);

        for (int i = 0; i < maxSize; i++) {
            result.append(System.lineSeparator());
            result.append("|");

            if (i >= Fibonacci.size()) {
                int spcCon = (conSize - Conway.get(i).toString().length()) / 2;
                result.append(" ".repeat(fibSize));
                result.append("|");
                result.append(" ".repeat(spcCon));
                result.append(Conway.get(i));
                result.append(" ".repeat(conSize -
                        (Conway.get(i).toString().length() + spcCon)));
                result.append("|");
                appendLine(result, fibSize, conSize);

                continue;
            }
            if (i >= Conway.size()) {
                int spcFib = (fibSize - Fibonacci
                        .get(i).toString().length()) / 2;
                repeat(result, fibSize, conSize, i, spcFib);
                result.append("|");
                appendLine(result, fibSize, conSize);
                continue;
            }

            int spcFib = (fibSize - Fibonacci
                    .get(i).toString().length()) / 2;
            int spcCon = (conSize - Conway
                    .get(i).toString().length()) / 2;

            repeat(result, fibSize, spcCon, i, spcFib);
            result.append(Conway.get(i));
            result.append(" ".repeat(conSize -
                    (Conway.get(i).toString().length() + spcCon)));
            result.append("|");
            appendLine(result, fibSize, conSize);

        }
        return result.toString();
    }

    private void appendLine(StringBuilder result,
                            int fibSize, int conSize) {
        result.append(System.lineSeparator());
        result.append("-".repeat(conSize + fibSize + 3));
    }


    private void repeat(StringBuilder result,
                        int fibSize, int conSize,
                        int i, int spcFib) {
        result.append(" ".repeat(spcFib));
        result.append(Fibonacci.get(i));
        result.append(" ".repeat(fibSize -
                (Fibonacci.get(i).toString().length() + spcFib)));
        result.append("|");
        result.append(" ".repeat(conSize));
    }
}
