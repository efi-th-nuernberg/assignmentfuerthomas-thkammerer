
class CenterTextFormatter extends TextFormatter {

    public CenterTextFormatter( String name, String input ) {
        super( name, input );
    }

    public void format( int lineLength ) {
        output.clear();
        int curIndex = 0;
        while (curIndex < input.length()) {
            String curLine = getNextLine(curIndex, lineLength);
            int stopIndex = curIndex + curLine.lastIndexOf(' ');

            if (isLastLine(curIndex, lineLength)) {
                stopIndex = input.length();
            }
            
            int numBlanks = lineLength / 2 - ( stopIndex - curIndex ) / 2;
            StringBuffer curStr = new StringBuffer();
            while( numBlanks > 0 ) {
                curStr.append(' ');
                numBlanks--;
            }
            curStr.append( input.substring(curIndex, stopIndex) );

            output.add( curStr );
            curIndex = stopIndex + 1;
        }
    }
}