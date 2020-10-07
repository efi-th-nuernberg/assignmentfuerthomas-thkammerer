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
        output.add( input );
    }

    public void print(PrintStream outputStream) {
        for (String curStr : output) {
            outputStream.println(curStr);
        }
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (String curStr : output) {
            builder.append(output);
            builder.append('\n');
        }
        return builder.toString();
    }

    protected String getNextLine(int startIndex, int lineLength) {
        int stopIndex = startIndex + lineLength;
        if (stopIndex >= input.length()) {
            stopIndex = input.length() - 1;
        }
        return input.substring(startIndex, stopIndex);
    }

    protected int getIndexOfLastBlankInLine( String line, int curIndex, int lineLength ) {
        int stopIndex = curIndex + line.lastIndexOf(' ');
        if (isLastLine(curIndex, lineLength)) {
            stopIndex = input.length();
        }
        return stopIndex;
    }

    protected boolean isLastLine(int curIndex, int lineLength) {
        return (input.length() - curIndex) < lineLength;
    }

    protected String insertBlanks( String line, int blanksToInsert ) {
        StringBuffer curStr = new StringBuffer();
        while( blanksToInsert > 0 ) {
            curStr.append(' ');
            blanksToInsert--;
        }
        curStr.append( line );
        return curStr.toString();
    }

    protected int getWordsInLine( String line ) {
        int numWords = 1;
        int curIndex = line.indexOf(' ', 0);
        while (curIndex >= 0) {
            numWords++;
            curIndex = line.indexOf(' ', curIndex + 1);
        }
        return numWords;
    }

    private String name; 
    protected Formatter formatter;
    protected String input;
    protected ArrayList<String> output;
}