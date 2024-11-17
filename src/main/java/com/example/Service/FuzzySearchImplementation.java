package com.example.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public class FuzzySearchImplementation {


    public boolean fuzzyMatch(String name, String productName, int limit){

        int editDistance = levenshteinDistance(name.toLowerCase(),productName.toLowerCase());

        //Verifying if the product name is relevant or not based on edit distance score
        return (editDistance < Math.max(name.length()/2, limit));
    }


    /*
    * Implementation of Levenshtein Search algorithm,
    * this method returns the minimum number of changes required to
    * convert the user provided input S1 into possible match S2,
    * where S2 is the valid name of product present in the Repository
    */

    public int levenshteinDistance(String s1, String s2){

        int row = s1.length();
        int col = s2.length();

        //Matrix to calculate and store the edit distance value
        int [][] distanceMatrix = new int[row+1][col+1] ;


        for(int i=0; i<=row; i++){
            for(int j=0; j<=col; j++){
                if(i==0 || j==0){

                    //Assigning the default values for the first row and first column
                    distanceMatrix[i][j] = Math.max(i,j);

                }
                else {

                    int charCheck = 1;
                    if(s1.charAt(i-1)==s2.charAt(j-1)){
                        charCheck=0;
                    }

                    //Calculating the addition, deletion and substitution costs
                    int a = distanceMatrix[i-1][j] + 1;
                    int b = distanceMatrix[i][j-1] + 1;
                    int c = distanceMatrix[i-1][j-1] + charCheck;

                    //Assigning the minimum cost to the matrix position
                    distanceMatrix[i][j] = Math.min(a,Math.min(b,c));

                }
            }
        }

        //Returning the edit distance value, which is the last entry of the matrix
        return distanceMatrix[row][col];
    }

}
