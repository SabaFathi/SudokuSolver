class Sudoku{
    
    private byte[][] body;
    
    //constructor method:
    public Sudoku(byte[][] input){
        body = new byte[9][9];
        
        for(int i=0 ; i<9 ; i++){
            for(int j=0 ; j<9 ; j++){
                setCell(i, j, input[i][j]);
            }
        }
    }
    
    //setter method:
    void setCell(int rowIndex, int colIndex, byte value){
        body[rowIndex][colIndex] = value;
    }
    
    //getter method:
    void print(){
        for(int i=0 ; i<9 ; i++){
            for(int j=0 ; j<9 ; j++){
                System.out.print(" | " + body[i][j]);
            }
            System.out.println(" |");
        }
        System.out.println("");
    }
    
    //checker method:
    boolean row(int rowIndex){
        boolean flag = true;
        short[] counter = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        
        for(int j=0 ; j<9 ; j++){
            try{
                if( (++ counter[ body[rowIndex][j]-1 ]) > 1 ){
                    flag = false;
                    break;
                }
            }catch(ArrayIndexOutOfBoundsException exp){
                //System.out.println(exp + " --> index = -1");
            }
        }
        
        return flag;
    }
    
    boolean column(int colIndex){
        boolean flag = true;
        short[] counter = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        
        for(int i=0 ; i<9 ; i++){
            try{
                if( (++ counter[ body[i][colIndex]-1 ]) > 1 ){
                    flag = false;
                    break;
                }
            }catch(ArrayIndexOutOfBoundsException exp){
                //System.out.println(exp + " --> index = -1");
            }
        }
        
        return flag;
    }
    
    boolean square(int startRow, int startCol){
        boolean flag = true;
        short[] counter = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        
        if( (startRow%3)!=0 || (startCol%3)!=0 ){
            System.out.println("programming error : wrong index to check square!");
            return false;
        }
        
        for(int i=startRow ; i<startRow+3 ; i++){
            for(int j=startCol ; j<startCol+3 ; j++){
                try{
                    if( (++ counter[ body[i][j]-1 ]) > 1 ){
                        flag = false;
                        break;
                    }
                }catch(ArrayIndexOutOfBoundsException exp){
                    //System.out.println(exp + " --> index = -1");
                }
            }
        }
        
        return flag;
    }
    
    boolean isComplete(){
        boolean flag = true;
        
        for(int i=0 ; i<9 ; i++){
            for(int j=0 ; j<9 ; j++){
                if( body[i][j]==0 ){
                    flag = false;
                    break;
                }
            }
            if( !flag ){
                break;
            }
        }
        
        return flag;
    }
    
    boolean isEmpty(int rowIndex, int colIndex){
        //System.out.println( rowIndex +"\t"+ colIndex);////////////////////////////////////////////////////
        return ( body[rowIndex][colIndex]>0 ? false : true );
    }
    
}