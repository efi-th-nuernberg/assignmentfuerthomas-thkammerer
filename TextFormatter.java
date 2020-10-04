class TextFormatter {

  private static final String text = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy "
      + "eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et "
      + "accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem "
      + "ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod "
      + "tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et "
      + "justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est "
      + "Lorem ipsum dolor sit amet.";

  public static void main(String[] args) {
    TextFormatter formatter = new TextFormatter(30);
    System.out.println("123456789012345678901234567890123456789012345678901234567890");
    formatter.print(text);
  }

  // Konstruktor
  public TextFormatter(int maxLineLength) {
    this.maxLineLength = maxLineLength;

  }

  // Ausgabe
  public void print(String aText) {

    int curIndex = 0;
    while (curIndex < aText.length()) {
      String curLine = getNextLine(aText, curIndex);
      int stopIndex = curIndex + curLine.lastIndexOf(' ');

      if (isLastLine(aText, curIndex)) {
        stopIndex = aText.length() - 1;
      }

      System.out.println(aText.substring(curIndex, stopIndex));
      curIndex = stopIndex + 1;
    }
  }

  private boolean isLastLine(String aText, int curIndex) {
    return (aText.length() - curIndex) < maxLineLength;
  }

  private String getNextLine(String aText, int startIndex) {
    int stopIndex = startIndex + maxLineLength;
    if (stopIndex >= aText.length()) {
      stopIndex = aText.length() - 1;
    }
    return aText.substring(startIndex, stopIndex);
  }

  private int maxLineLength;

}