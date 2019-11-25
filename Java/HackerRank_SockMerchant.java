// John works at a clothing store. He has a large pile of socks that he must pair by color for sale.
// Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.

// For example, there are n = 7 socks with colors ar = [1, 2, 1, 2, 1, 3, 2]. There is one pair of color 1 and one of color 2. There are three odd socks left, one of each color. The number of pairs is 2.

// Function Description
// Complete the sockMerchant function in the editor below.
// It must return an integer representing the number of matching pairs of socks that are available.

// sockMerchant has the following parameter(s):
// * n: the number of socks in the pile
// * ar: the colors of each sock

// Input Format
// The first line contains an integer n, the number of socks represented in ar.
//  The second line contains n space-separated integers describing the colors ar[i] of the socks in the pile.

// Constraints
// * 1 <= n <= 100
// * 1 <= ar[i]<= 100 where 0 <= i <= n

// Output Format
// Return the total number of matching pairs of socks that John can sell.


import java.util.*;
import java.util.stream.*;

class Main {

  //Method without HashMap
  static int sockMerchant(int[] ar) {
    //counts the number of paired socks
    int count = 0;
    int i = 0;

    //sorted array needed to find pairs of same colored socks
    Arrays.sort(ar);

    //iterate through number of socks in ar
    while(i < ar.length-1) {

      //if the current sock matches the color of the next sock, add one to the paired sock count
      if(ar[i] == ar[i+1]) {
        count++;

        //move on to the next sock after this current matched pair
        i += 2;

      }

      //if there pair does not match, move onto the next sock
      else {
        i += 1;
      }
    }

    //output the number of sock pairs
    return count;
  }

  //Method with HashMap
  static int sockMerchant2(int[] ar) {

    //creates an empty HashMap
    HashMap<Integer, Integer> pairs = new HashMap<>();

    //iterates through the socks in ar
    for(int i = 0; i < ar.length; i++) {

      int num = ar[i];

      //if the current sock color already exists in the HashMap, increase count of that current sock color
      if(pairs.containsKey(num)){
          pairs.put(num, pairs.get(num)+1);
      }

      //otherwise create that key and have the current sock color value be 1
      else
      {
          pairs.put(num, 1);
      }
    }

    //initialize the pair count to zero
    int count = 0;

    //go through HashMap
    for(Integer key : pairs.keySet()) {
      //for every value in HashMap, divide by two for a pair and round down (eliminating the sock colors that are not paired), setting count to this result
      count += Math.floor(pairs.get(key)/2);
    }

    //output the number of sock pairs
    return count;
  }

  //test case
  public static void main(String[] args) {
    // System.out.println("Hello world!");
    int[] ar = {44, 55, 11, 15, 4, 72, 26, 91, 80, 14, 43, 78, 70, 75, 36, 83, 78, 91, 17, 17, 54, 65, 60, 21, 58, 98, 87, 45, 75, 97, 81, 18, 51, 43, 84, 54, 66, 10, 44, 45, 23, 38, 22, 44, 65, 9, 78, 42, 100, 94, 58, 5, 11, 69, 26, 20, 19, 64, 64, 93, 60, 96, 10, 10, 39, 94, 15, 4, 3, 10, 1, 77, 48, 74, 20, 12, 83, 97, 5, 82, 43, 15, 86, 5, 35, 63, 24, 53, 27, 87, 45, 38, 34, 7, 48, 24, 100, 14, 80, 54};

    //print pair count
    System.out.println(sockMerchant(ar));
  }
}
