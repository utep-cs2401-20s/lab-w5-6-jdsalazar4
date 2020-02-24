public class SnakeGame {
    private boolean game[][];
    private int position[];

    //Constructor for creating the empty gameboard
    public SnakeGame(){
        this.game = new boolean[1][1];
    }

    //constructor for finding the positions head
    public SnakeGame (boolean[][] game, int x, int y){
        this.game = game;
        position[0]=x;
        position[1]=y;
    }

    private static int exhaustiveChecks;

    private static int recursiveChecks;

    public int[] findTailExhaustive(int x, int y){
        int[] snakeResult = {0,0,0};
        int neighbor=0;

        for(int i=0; i< game.length; i++){
            for(int j=0; j< game.length; j++){
                
            }
        }
    }

}
