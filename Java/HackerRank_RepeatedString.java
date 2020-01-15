class Main {
    public static void main(String[] args) {
      
      repeatedString("aba", 10);
      repeatedString2("ababa", 3);
    }

    //too long
static long repeatedString(String s, long n) {
    String pattern = s;
    long occurences = 0;
    if(s.length() > n) {
      return -1;
    }
    else if(s.length() <= n) {
      long numberOfRepeats = n / s.length();
      long remainder = n % s.length();

      for (int i = 1; i < numberOfRepeats; i++) {
        pattern = pattern.concat(s);
      }
      if(remainder > 0) {
        char[] str = s.toCharArray();
        for (int j = 0; j < remainder; j++) {
          pattern += str[j];
        }
      }

      char[] patternArr = pattern.toCharArray();
      for (int k = 0; k < patternArr.length; k++) {
        if (patternArr[k] == 'a') {
          occurences++;
        }
      }
      System.out.println(occurences);
    }
    return occurences;
  }

    //slightly refactored
  static long repeatedString2(String s, long n) {
    long occurences = 0;
    char[] str = s.toCharArray();
    if(s.length() > n) {
      for(int i = 0; i < n; i++) {
        if (str[i] == 'a') {
          occurences++;
        }
      }
      System.out.println(occurences);
      return occurences;
    }
    else if(s.length() <= n) {

      for (int k = 0; k < str.length; k++) {
        if (str[k] == 'a') {
          occurences++;
        }
      }
      long numberOfRepeats = n / s.length();
      occurences *= numberOfRepeats;

      long remainder = n % s.length();
      if(remainder > 0) {
        for (int j = 0; j < remainder; j++) {
          if(str[j] == 'a') {
            occurences++;
          }
        }
      }

      System.out.println(occurences);
    }
    return occurences;
  }
}