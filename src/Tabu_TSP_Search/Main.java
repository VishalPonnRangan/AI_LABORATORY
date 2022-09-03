/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tabu_TSP_Search;

/**
 *
 * @author ganesh
 */
public class Main {


    public static void main(String[] args) {

        int[][] m = new int[][]{{0, 1, 3, 4, 5},
                    {1, 0, 1, 4, 8},
                    {3, 1, 0, 5, 1},
                    {4, 4, 5, 0, 2},
                    {5, 8, 1, 2, 0}};

        int size = 10;
        while (size < 200) {
            Matrix matrix = new Matrix(size);
            TabuSearch tabuSearch = new TabuSearch(matrix);
            Long start = System.currentTimeMillis();
            tabuSearch.invoke();
            Long stop = System.currentTimeMillis() - start;
            System.out.println(String.format("Size: %d\t Time: %d ",size,stop));
            size +=10;
        }


    }
}