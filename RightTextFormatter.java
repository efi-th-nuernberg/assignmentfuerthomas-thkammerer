class RightTextFormatter extends TextFormatter{


    // Konstruktor
    public RightTextFormatter( String name, String input ) {
        super( name, input );
    }

    public void format( int lineLength ) {        
        output.clear();
        int curIndex = 0;
        while (curIndex < input.length()) {
            String curLine = getNextLine(curIndex, lineLength);
            int stopIndex = getIndexOfLastBlankInLine( curLine, curIndex, lineLength );            
            curLine = input.substring(curIndex, stopIndex);

            int blanksToInsert = lineLength - ( stopIndex - curIndex );
            curLine = insertBlanksInFront( curLine, blanksToInsert );        
            output.add( curLine );
            curIndex = stopIndex + 1;
        }
    }
}