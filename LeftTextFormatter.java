
class LeftTextFormatter extends TextFormatter {

    public LeftTextFormatter( String name, String input ) {
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

            output.add( new StringBuffer( input.substring(curIndex, stopIndex ) ) );
            curIndex = stopIndex + 1;
        }
    }
}