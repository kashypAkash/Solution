package com.akash;

/**
 * Created by akash on 2/19/17.
 */

public class Solution {

    public static String findShortestDistance(char[][] a,char source,char dest){
        int sourceX=-1,sourceY=-1,destX=-1,destY=-1;
        int X=a.length;
        int Y=a[0].length;
        for(int i=0;i<X;i++){
            for(int j=0;j<Y;j++){
                if(a[i][j]==source){
                    sourceX=i;
                    sourceY=j;
                }
                if(a[i][j]==dest){
                    destX=i;
                    destY=j;
                }
            }
        }
        Double result=findShortestDistanceUtil(a,sourceX,sourceY,destX,destY);
        if(result==Double.POSITIVE_INFINITY){
            return String.format("Invalid");
        }
        else {
            return String.format("Starting point is (%d,%d) and mincostpath is %d",sourceX,sourceY,result.intValue());
        }
    }

    public static double findShortestDistanceUtil(char[][] a,int currX,int currY,int destX,int destY){

        int X=a.length;
        int Y=a[0].length;
        if(currX<0||currY<0||currX>X||currY>Y){
            return Double.POSITIVE_INFINITY;
        }
        else if(currX==destX&&currY==destY){

            return 0;
        }
        else{
            return 1+min(findShortestDistanceUtil(a,currX+1,currY,destX,destY),findShortestDistanceUtil(a,currX,currY+1,destX,destY),findShortestDistanceUtil(a,currX+1,currY+1,destX,destY));
        }
    }

    public static double min(double a,double b,double c){
        if(a<=b && a<=c){
            return a;
        }
        else if(b<=c){
            return b;
        }
        else{
            return c;
        }
    }
}

