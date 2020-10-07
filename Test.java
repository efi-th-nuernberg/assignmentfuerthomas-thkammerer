
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
        ArrayList<TextFormatter> formatters = new ArrayList<>();
        formatters.add( new LeftTextFormatter( "left alligend formatter", testText ) );
        formatters.add( new RightTextFormatter( "right alligend formatter", testText ) );
        formatters.add( new CenterTextFormatter( "center alligend formatter", testText ) );
        formatters.add( new BlockTextFormatter( "block alligend formatter", testText ) );
        for( TextFormatter curFormatter : formatters ) {
            System.out.println( "\n--- " + curFormatter.getName() );
            System.out.println("123456789012345678901234567890");
            curFormatter.format(30);
            curFormatter.print( System.out );
        }
    }
}