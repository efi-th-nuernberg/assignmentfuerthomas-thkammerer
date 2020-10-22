
import java.util.ArrayList;

class Test {

    private static final String testText = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy "
      + "eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et "
      + "accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem "
      + "ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod "
      + "tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et "
      + "justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est "
      + "Lorem ipsum dolor sit amet.";


    public static void main(String[] args) {

        int lineLength = 25;
        ArrayList<TextFormatter> formatters = new ArrayList<>();
        formatters.add( new LeftTextFormatter( "left alligend formatter", testText ) );
        formatters.add( new RightTextFormatter( "right alligend formatter", testText ) );
        formatters.add( new CenterTextFormatter( "center alligend formatter", testText ) );
        formatters.add( new BlockTextFormatter( "block alligend formatter", testText ) );
        
        for( TextFormatter curFormatter : formatters ) {
            System.out.println( "\n--- " + curFormatter.getName() );
            
            for( int i = 1; i <= lineLength; i++ ) {
                System.out.print( i % 10 );
            }
            System.out.println();
            curFormatter.format( lineLength );
            curFormatter.print( System.out );
        }
    }
}