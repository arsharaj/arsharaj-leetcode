/*
Problem : Sentence similarity 3
Inputs :-
- sentence1 : string of words seperated by spaces
- sentence2 : string of words seperated by spaces
Output :-
- boolean : check if both the sentences are similar
*/

class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] sentence1Arr = sentence1.split(" ");
        String[] sentence2Arr = sentence2.split(" ");

        if (sentence1Arr.length < sentence2Arr.length) {
            return isSimilar(sentence1Arr, sentence2Arr);
        } else {
            return isSimilar(sentence2Arr, sentence1Arr);
        }
    }

    private boolean isSimilar(String[] smallerSentence, String[] largerSentence) {
        int smallerStart = 0;
        int smallerEnd = smallerSentence.length - 1;
        int largerStart = 0;
        int largerEnd = largerSentence.length - 1;

        while (smallerStart <= smallerEnd && largerStart <= largerEnd) {
            if (largerSentence[largerStart].equals(smallerSentence[smallerStart])) {
                largerStart++;
                smallerStart++;
            } else if (largerSentence[largerEnd].equals(smallerSentence[smallerEnd])) {
                largerEnd--;
                smallerEnd--;
            } else {
                return false;
            }
        }

        return true;
    }
}