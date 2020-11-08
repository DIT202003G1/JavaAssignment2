package net.frankium.sunwaydiit.assignment.Assignment2;

public class Question1 {
    public static void main(String[] args) {
    	//Testing Program, Please enable the assertion by using the "-ea" parameter when running.
	    
	    //test if assertion is on
	    boolean assertion = false;
	    assert assertion = true;
	    if (!assertion){
	    	System.out.println("Please enable your assertion for the test!");
	    	System.exit(0);
	    }
	    
	    //Test cases
	    int[][] testCases = {{1,2,3,4,5},{4,2,4,4,2},{6,5,2,3,1}};
	    int[] answers1 = {0,1,4};
	    int[] answers2 = {4,3,0};
	    for (int i = 0; i < 3; i++){
	    	//If you get an exception saying AssertionError, this means its the wrong answer
	    	assert (smallestIndex(testCases[i], 5) == answers1[i]) : "Failed for Test Case S" + i + ", expect "+ answers1[i] + ", gets " + smallestIndex(testCases[i], 5);
	    	assert (largestIndex(testCases[i], 5) == answers2[i]) : "Failed for Test Case L" + i + ", expect "+ answers2[i] + ", gets " + largestIndex(testCases[i], 5);
	    }
	    
	    System.out.println("Assertion Done with No Error.");
	    
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
