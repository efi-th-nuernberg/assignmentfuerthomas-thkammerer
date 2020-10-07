import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

class TextFormatter implements Formatter {

    TextFormatter(String name, String input) {
        this.name = name;
        this.input = input;
        this.output = new ArrayList<>();
    }

    public String getName() {
        return name;
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

    protected boolean isLastLine(int curIndex, int lineLength) {
        return (input.length() - curIndex) < lineLength;
    }

    protected String getNextLine(int startIndex, int lineLength) {
        int stopIndex = startIndex + lineLength;
        if (stopIndex >= input.length()) {
            stopIndex = input.length() - 1;
        }
        return input.substring(startIndex, stopIndex);
    }

    private String name; 
    protected Formatter formatter;
    protected String input;
    protected ArrayList<StringBuffer> output;
}