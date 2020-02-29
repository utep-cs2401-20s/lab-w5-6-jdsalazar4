public class SnakeGame {
    private boolean game[][];
    private int headPosition[];

    //Constructor for creating the empty gameboard
    public SnakeGame(){
        game = new boolean[][]{{false}};
    }

    //constructor for finding the positions head
    public SnakeGame (boolean[][] board, int x, int y){
        int row= board[0].length;
        int col = board.length;
        this.game = new boolean[col][row];
        for(int i=0; i<board.length; i++){
            for(int j=0; i< row; j++ ){
                game[i][j]= board[i][j];
            }
        }
        this.headPosition = new int[2];
        headPosition[0]=x;
        headPosition[1]=y;
    }

    //initiating exhaustive and recursive Checks
    private static int exhaustiveChecks;

    private static int recursiveChecks;


    // this method is goint to check the board to see if it finds any parts to the snake
    public int neighbors(int rows , int cols){
        int neighbor=0;
        if(cols != headPosition[1] && rows != headPosition[0]){
            if(rows + 1>= 0 && rows +1 < game.length){//checking down
                if (game[rows + 1][cols]== true){
                    neighbor +=1;
                }
            }
            if(rows -1 >= 0 && rows -1 < game.length  ){//checking up
                if(game[rows -1][cols]== true){
                    neighbor+=1;
                }
            }
            if(cols + 1 >=0 && cols +1 < game.length){// checking right
                if(game[rows][cols +1]==true ){

                }
            }
            if(cols -1 >=0 && cols -1 < game.length){// checking left
                if(game[rows][cols -1]== true){

                }
            }


        }

        return neighbor;
    }







    public int[] findTailExhaustive(){
        resetCounters();
        int[] snakeResult = {0,0,0};
        int snakelength=0;//tracking the length of the snake
        int TailsCol=-1;
        int TailsRow=-1;








        //nested for loop for using findTailExhaustive
        for(int i=0; i< game.length; i++ ){
            for(int j=0; j< game[0].length; j++){
                exhaustiveChecks ++;//exhaustive counter
                if(game[i][j]==true){
                    snakelength +=1;

                    if (neighbors(i,j )==1 && headPosition[0]!= i || headPosition[1] != j){
                       TailsRow= i;
                       TailsCol= j;

                    }
                }

            }

        }
        snakeResult[0]= TailsRow;
        snakeResult[1]= TailsCol;
        snakeResult[2]= snakelength;

        return snakeResult;
    }

    //method for findTailRecursive
    public int[] findTailRecursive(int[] currentPosition, int[]previousPosition){
        resetCounters();
        int Snakeslength=0;
        int rows = previousPosition[0];
        int cols = previousPosition[1];
        int[] currentP = new int[2];
        int[] snakeResult = {0,0,0};//finding X, Y and snake Length
        int tailsRow=0;
        int tailsCol=0;

        if(rows + 1>= 0 && rows +1 < game.length){
            if (game[rows + 1][cols]== true){
                if((rows+1) != previousPosition[0] || cols != previousPosition[1]) {
                    Snakeslength = Snakeslength + 1;
                    if ((neighbors(rows + 1, cols) < 2) && (rows + 1) != headPosition[0] || cols != headPosition[1]) {
                        snakeResult[0] = rows + 1;
                        snakeResult[1] = cols;
                        snakeResult[2] = Snakeslength;
                        return snakeResult;

                    }
                    currentP[0] = rows + 1;
                    currentP[1] = cols;
                    recursiveChecks++;//counting for recursive checks
                    findTailRecursive(currentPosition, currentP);
                }
            }
        }
        if(rows -1 >= 0 && rows -1 < game.length  ){
            if(game[rows -1][cols]== true){
                if((rows-1) != previousPosition[0] || cols != previousPosition[1]) {
                    Snakeslength = Snakeslength + 1;
                    if ((neighbors(rows - 1, cols) < 2) && (rows - 1) != headPosition[0] || cols != headPosition[1]) {
                        snakeResult[0] = rows - 1;
                        snakeResult[1] = cols;
                        snakeResult[2] = Snakeslength;
                        return snakeResult;

                    }
                    currentP[0] = rows - 1;
                    currentP[1] = cols;
                    recursiveChecks++;//counting for recursive checks
                    findTailRecursive(currentPosition, currentP);
                }
            }
        }


        if(cols + 1 >=0 && cols +1 < game.length){
            if(game[rows][cols +1]==true ){
                if(rows != previousPosition[0] || (cols+1) != previousPosition[1]) {
                    Snakeslength = Snakeslength + 1;
                    if ((neighbors(rows, cols + 1) < 2) && (rows != headPosition[0] || (cols + 1) != headPosition[1])) {
                        snakeResult[0] = rows;
                        snakeResult[1] = cols + 1;
                        snakeResult[2] = Snakeslength;
                        return snakeResult;

                    }
                    currentP[0] = rows;
                    currentP[1] = cols + 1;
                    recursiveChecks++;//counting for recursive checks
                    findTailRecursive(currentPosition, currentP);
                }
            }
        }
        if(cols -1 >=0 && cols -1 < game.length){
            if(game[rows][cols -1]== true){
                if(rows != previousPosition[0] || (cols-1) != previousPosition[1]) {
                    Snakeslength = Snakeslength + 1;
                    if ((neighbors(rows, cols - 1) < 2) && (rows != headPosition[0] || (cols - 1) != headPosition[1])) {
                        snakeResult[0] = rows;
                        snakeResult[1] = cols - 1;
                        snakeResult[2] = Snakeslength;
                        return snakeResult;

                    }
                    currentP[0] = rows;
                    currentP[1] = cols - 1;
                    recursiveChecks++;//counting for recursive checks
                    findTailRecursive(currentPosition, currentP);
                }
            }
        }






        return snakeResult;

    }


    public int [] findTailRecursive(){
        return findTailRecursive(headPosition, headPosition);
    }
// initiating checks/ counters
    private void resetCounters() {
        this.exhaustiveChecks=0;
        this.recursiveChecks=0;
    }

    public static int getRecursiveChecks() {
        return exhaustiveChecks;
    }

    public static int getExhaustiveChecks() {
        return recursiveChecks;
    }

}
