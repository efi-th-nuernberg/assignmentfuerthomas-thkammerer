
class BlockTextFormatter extends TextFormatter {

    public BlockTextFormatter( String name, String input ) {
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
            
            StringBuffer curStr = new StringBuffer(input.substring(curIndex, stopIndex));
            int blankSpace = lineLength - ( stopIndex - curIndex );
            int numBlanks = countNumberOfBlanks( curStr );
            
            if( ! isLastLine( curIndex, lineLength ) ) {
                while( blankSpace > 0 ) {
                    int blankIndex = curStr.indexOf( " " ); 
                    while( blankIndex < curStr.length() && curStr.charAt( blankIndex+1) == ' ') {
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

    private int countNumberOfBlanks( StringBuffer text ) {
        int numBlanks = 0;
        for( int curIndex = 0; curIndex < text.length(); curIndex++ ) {
            if(text.charAt(curIndex) == ' ') {
                numBlanks++;
            }
        }
        return numBlanks;
    }
}