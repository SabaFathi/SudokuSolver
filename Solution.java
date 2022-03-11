import java.util.Scanner;

public class Solution{
    
    //private static long startTime, endTime;
    private static int countSolution = 0;
    
    public static void main(String[] args){
        byte[][] input = new byte[9][9];
        Sudoku sudoku;
        
        getInput(input);
        sudoku = new Sudoku(input);
        //startTime = System.currentTimeMillis();
        solve(0, 0, sudoku);
        
    }
    
    private static void getInput(byte[][] input){
        Scanner scanner = new Scanner(System.in);
        
        for(int i=0 ; i<input.length ; i++){
            for(int j=0 ; j<input[i].length ; j++){
                input[i][j] = scanner.nextByte();
            }
        }
        
        scanner.close();
    }
    
    private static void solve(int rowIndex, int colIndex, Sudoku sudoku){
        if( sudoku.isComplete() ){
            countSolution ++;
            System.out.println("solution " + countSolution + " :");
            sudoku.print();
            //endTime = System.currentTimeMillis();
            //long elapseTime=endTime-startTime;
            //System.out.println(elapseTime);
            //System.exit(0);
            return;
        }
        if( colIndex>=9 ){
            //colIndex = 0;
            //rowIndex ++;
            solve(rowIndex+1, 0, sudoku);
            return;
        }
        if( rowIndex>=9 ){
            return;
        }
        
        if( sudoku.isEmpty(rowIndex, colIndex) ){
            for(byte value=1 ; value<10 ; value++){
                sudoku.setCell(rowIndex, colIndex, value);
                //System.out.println("\t" + value);
                if( sudoku.row(rowIndex) && sudoku.column(colIndex) && sudoku.square((int)(rowIndex/3)*3, (int)(colIndex/3)*3) ){
                    solve(rowIndex, colIndex+1, sudoku);
                    //System.out.println("condition was true");
                }
                //sudoku.setCell(rowIndex, colIndex, (byte)0);
            }
            sudoku.setCell(rowIndex, colIndex, (byte)0);
        }else{
            solve(rowIndex, colIndex+1, sudoku);
        }
    }
    
}