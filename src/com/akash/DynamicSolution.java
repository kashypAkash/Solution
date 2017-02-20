package com.akash;

/**
 * Created by akash on 2/19/17.
 */

public class DynamicSolution {

    public static String findShortestCost(char a[][], char source, char dest)
    {
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

        int i, j;
        int tc[][]=new int[X][Y];

        for (i = 0; i <sourceY; i++)
            for(j =0;i<X;j++)
                tc[i][j]=0;

        for(i = 0; i < sourceX;i++)
            for(j=0;j<Y;j++)
                tc[i][j]=0;

        tc[sourceX][sourceY] = 0;

        for (i = sourceX+1; i <X; i++)
            tc[i][sourceY] = tc[i-1][sourceY] + 1;

        for (j = sourceY+1; j <Y; j++)
            tc[sourceX][j] = tc[sourceX][j-1] + 1;


        for (i = sourceX+1; i <X; i++)
            for (j = sourceY+1; j <Y; j++)
                tc[i][j] = min(tc[i-1][j-1],
                        tc[i-1][j],
                        tc[i][j-1]) + 1;

        return String.format("Starting point is (%d,%d) and mincostpath is %d",sourceX,sourceY,tc[destX][destY]);
    }

    private static int min(int x, int y, int z)
    {
        if (x < y)
            return (x < z)? x : z;
        else
            return (y < z)? y : z;
    }

}
