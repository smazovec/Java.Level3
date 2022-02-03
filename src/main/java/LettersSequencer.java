public class LettersSequencer {

  private final char[] letterSequence = {'A', 'B', 'C'};
  private int indexOfCurrentLetter = 0;

  void nextLetter() {
    switch (indexOfCurrentLetter) {
      case 0:
        indexOfCurrentLetter = 1;
        break;
      case 1:
        indexOfCurrentLetter = 2;
        break;
      default:
        indexOfCurrentLetter = 0;
    }
  }

  char currentLetter() {
    return letterSequence[indexOfCurrentLetter];
  }

}
