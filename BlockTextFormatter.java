
class BlockTextFormatter extends TextFormatter {

    public BlockTextFormatter( String name, String input ) {
        super( name, input );
    }

    public void format( int lineLength ) {
        output.clear();
        int curIndex = 0;
        while (curIndex < input.length()) {
            String curLine = getNextLine(curIndex, lineLength);
            int stopIndex = getIndexOfLastBlankInLine( curLine, curIndex, lineLength );
            curLine = input.substring(curIndex, stopIndex);

            if( ! isLastLine( curIndex, lineLength ) && getWordsInLine( curLine ) > 1 ) {
                int blanksToInsert = lineLength - ( stopIndex - curIndex );
                curLine = insertBlanks( curLine, blanksToInsert );
            }
                                
            output.add( curLine );
            curIndex = stopIndex + 1;
        }
    }

    protected String insertBlanks( String line, int blanksToInsert ) {
        StringBuffer curStr = new StringBuffer( line );                   
        
        while( blanksToInsert > 0 ) {
            int blankIndex = curStr.indexOf( " " ); 
            while( blankIndex < curStr.length() && curStr.charAt( blankIndex+1) == ' ') {
                blankIndex++;
            }
            while( blankIndex != -1 && blanksToInsert > 0 ) {
                curStr.insert( blankIndex, " " );
                blanksToInsert--;
                blankIndex = curStr.indexOf( " ", blankIndex+2 );
            }
        }
        return curStr.toString();    
    }
}