package com.example.Service;

import org.springframework.beans.factory.annotation.Value;

public class FuzzySearchImplementation {

    @Value("${editDistanceLimit}")
    private int limit;

    public boolean fuzzyMatch(String name, String productName){

        int editDistance = levenshteinDistance(name,productName);

        return (editDistance < Math.max(name.length()/2, limit));
    }

    public int levenshteinDistance(String s1, String s2){

        int editDistance=s1.length();
        int row = s1.length();
        int col = s2.length();

        int [][] distanceMatrix = new int[row+1][col+1] ;
        for(int i=0; i<=row; i++){
            for(int j=0; j<=col; j++){
                if(i==0 || j==0){

                    distanceMatrix[i][j] = Math.max(i,j);

                }
                else {

                    int charCheck = 1;
                    if(s1.charAt(i-1)==s2.charAt(j-1)){
                        charCheck=0;
                    }
                    int a = distanceMatrix[i-1][j] + 1;
                    int b = distanceMatrix[i][j-1] + 1;
                    int c = distanceMatrix[i-1][j-1] + charCheck;

                    distanceMatrix[i][j] = Math.min(a,Math.min(b,c));

                }
            }
        }

        return Math.min(editDistance,distanceMatrix[row][col]);
    }

}
