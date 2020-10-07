import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

class TextFormatter implements Formatter {

<<<<<<< HEAD
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
=======
    private static final String testText = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy "
      + "eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et "
      + "accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem "
      + "ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod "
      + "tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et "
      + "justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est "
      + "Lorem ipsum dolor sit amet.";

    public static void main( String[] args ) {
        TextFormatter formatter = new TextFormatter( testText );

        System.out.println( "\n--- Left alligned");
        System.out.println("123456789012345678901234567890123456789012345678901234567890");
        formatter.format_left_alligned( 30 );
        formatter.print();

        System.out.println( "\n--- Right alligned");
        System.out.println("123456789012345678901234567890123456789012345678901234567890");
        formatter.format_right_alligned( 30 );
        formatter.print();

        System.out.println( "\n--- Center alligned");
        System.out.println("123456789012345678901234567890123456789012345678901234567890");
        formatter.format_center_alligned( 30 );
        formatter.print();

        System.out.println( "\n--- Block alligned");
        System.out.println("123456789012345678901234567890123456789012345678901234567890");
        formatter.format_block_alligned( 30 );
        formatter.print();
    }

    // Konstruktor
    public TextFormatter( String text ) {
        this.input = text;
        this.output = new ArrayList<>();
    }

    public void format_left_alligned( int maxLineLength ) {
        output.clear();
        int curIndex = 0;
        while ( curIndex < input.length() ) {
            String curLine = getNextLine(curIndex, maxLineLength);
            int stopIndex = curIndex + curLine.lastIndexOf( ' ' );

            if ( isLastLine(curIndex, maxLineLength ) ) {
                stopIndex = input.length();
            }
            output.add( new StringBuffer( input.substring( curIndex, stopIndex ) ) );
            curIndex = stopIndex + 1;
        }
    }

    public void format_right_alligned( int maxLineLength ) {        
        output.clear();
        int curIndex = 0;
        while ( curIndex < input.length() ) {
            String curLine = getNextLine(curIndex, maxLineLength);
            int stopIndex = curIndex + curLine.lastIndexOf(' ');

            if ( isLastLine( curIndex, maxLineLength ) ) {
                stopIndex = input.length();
            }
            
            int numBlanks = maxLineLength - ( stopIndex - curIndex );
            StringBuffer curStr = new StringBuffer();
            while( numBlanks > 0 ) {
                curStr.append( ' ' );
                numBlanks--;
            }
            curStr.append( input.substring( curIndex, stopIndex ) );
            output.add( curStr );
            curIndex = stopIndex + 1;
        }
    }

    public void format_center_alligned( int maxLineLength ) {        
        output.clear();
        int curIndex = 0;
        while ( curIndex < input.length() ) {
            String curLine = getNextLine( curIndex, maxLineLength );
            int stopIndex = curIndex + curLine.lastIndexOf( ' ' );

            if ( isLastLine( curIndex, maxLineLength ) ) {
                stopIndex = input.length();
            }
            
            int numBlanks = maxLineLength / 2 - ( stopIndex - curIndex ) / 2;
            StringBuffer curStr = new StringBuffer();
            while( numBlanks > 0 ) {
                curStr.append(' ');
                numBlanks--;
            }
            curStr.append( input.substring( curIndex, stopIndex ) );
            output.add( curStr );
            curIndex = stopIndex + 1;
>>>>>>> 20dd298e2591688b166d7b9857218da97b83c929
        }
        return builder.toString();
    }

<<<<<<< HEAD
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
=======
    public void format_block_alligned( int maxLineLength ) {        
        output.clear();
        int curIndex = 0;
        while( curIndex < input.length() ) {
            String curLine = getNextLine( curIndex, maxLineLength );
            int stopIndex = curIndex + curLine.lastIndexOf( ' ' );

            if( isLastLine( curIndex, maxLineLength ) ) {
                stopIndex = input.length();
            }
            
            StringBuffer curStr = new StringBuffer( input.substring(curIndex, stopIndex ) );
            int blankSpace = maxLineLength - ( stopIndex - curIndex );
            
            if( ! isLastLine( curIndex, maxLineLength ) ) {
                while( blankSpace > 0 ) {
                    int blankIndex = curStr.indexOf( " " ); 
                    while( blankIndex < curStr.length() && curStr.charAt( blankIndex +1 ) == ' ') {
                        blankIndex++;
                    }
                    while( blankIndex != -1 && blankSpace > 0 ) {
                        curStr.insert( blankIndex, " " );
                        blankSpace--;
                        blankIndex = curStr.indexOf( " ", blankIndex+2 );
                    }
                }
            }                        
            output.add( curStr );
            curIndex = stopIndex + 1;
        }
    }

    public void print() {
        for( StringBuffer curStr : output ) {
            System.out.println( curStr );
        }
    }

    private boolean isLastLine( int curIndex, int maxLineLength ) {
        return ( input.length() - curIndex ) < maxLineLength;
    }

    private String getNextLine( int startIndex, int maxLineLength ) {
>>>>>>> 20dd298e2591688b166d7b9857218da97b83c929
        int stopIndex = startIndex + maxLineLength;
        if( stopIndex >= input.length() ) {
            stopIndex = input.length() - 1;
        }
<<<<<<< HEAD
        return input.substring(startIndex, stopIndex);
    }

    protected Formatter formatter;
    protected String input;
    protected ArrayList<StringBuffer> output;
    private String name; 
=======
        return input.substring( startIndex, stopIndex );
    }

    private String input;
    private ArrayList<StringBuffer> output;
>>>>>>> 20dd298e2591688b166d7b9857218da97b83c929
}