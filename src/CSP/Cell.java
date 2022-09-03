/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CSP;

/**
 *
 * @author ganesh
 */
import java.util.ArrayList;



public class Cell {
    boolean current = false;
    boolean found = false;
    int value = 0;
    int row;
    int column;
    ArrayList<Integer> possibleNumbers;

    public Cell(boolean current,int row,int column,boolean found,int value,ArrayList<Integer> possibleNumbers){
        this.current = current;
        this.row = row;
        this.column = column;
        this.found = found;
        this.value = value;
        this.possibleNumbers = possibleNumbers;
    }


}