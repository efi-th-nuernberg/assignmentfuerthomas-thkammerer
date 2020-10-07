import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

class TextFormatter implements Formatter {

    TextFormatter(String name, String input) {
        this.name = name;
        this.input = input;
        this.output = new ArrayList<>();
    }

    public void format(int lineLength) {
        output.add( new StringBuffer( input ) );
    }

    public void print(PrintStream outputStream) {
        for (StringBuffer curStr : output) {
            outputStream.println(curStr);
        }
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (StringBuffer curStr : output) {
            builder.append(output);
            builder.append('\n');
        }
        return builder.toString();
    }

    public String getLineAsString(int lineNumber) {
        return output.get(lineNumber).toString();
    }

    public List<StringBuffer> getFormatedOuptutAsList() {
        return output;
    }

    public String getName() {
        return name;
    }

    protected boolean isLastLine(int curIndex, int maxLineLength) {
        return (input.length() - curIndex) < maxLineLength;
    }

    protected String getNextLine(int startIndex, int maxLineLength) {
        int stopIndex = startIndex + maxLineLength;
        if (stopIndex >= input.length()) {
            stopIndex = input.length() - 1;
        }
        return input.substring(startIndex, stopIndex);
    }

    protected Formatter formatter;
    protected String input;
    protected ArrayList<StringBuffer> output;
    private String name; 
}