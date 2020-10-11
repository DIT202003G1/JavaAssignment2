package net.frankium.sunwaydiit.assignment.Assignment2;

public class Question1 {
    public static void main(String[] args) {
    	//Testing Program
	    boolean noErr = true;
	    int[][] testCases = {{1,2,3,4,5},{4,2,4,4,2},{6,5,2,3,1}};
	    int[] answers1 = {0,1,4};
	    int[] answers2 = {4,3,0};
        for (int i = 0 ; i < 3 ; i++){
        	if (smallestIndex(testCases[i],5) != answers1[i]) {
		        System.out.println("Assertion Error - " + i + "\nExpected " + answers1[i] + ", gets " + smallestIndex(testCases[i], 5));
		        noErr = false;
	        }
        	if (largestIndex(testCases[i],5) != answers2[i]) {
		        System.out.println("Assertion Error - " + i + "\nExpected " + answers2[i] + ", gets " + smallestIndex(testCases[i], 5));
		        noErr = false;
	        }
        }
        System.out.println("Assertion completed with no error: " + noErr);
    }
    private static int smallestIndex(int[] array, int size){
        int s = array[0];
        int index = 0;
    	for (int i = 0; i < size; i++){
        	if (array[i] < s){
        		index = i;
        		s = array[i];
	        }
        }
    	return index;
    }
    private static int largestIndex(int[] array, int size){
    	int l = array[0];
        int index = 0;
    	for (int i = 0; i < size; i++){
        	if (array[i] >= l){
        		index = i;
        		l = array[i];
	        }
        }
    	return index;
    }
}
