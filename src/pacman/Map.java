package pacman;


/**
 *
 * @author franreno
 */
public class Map {
    private final int level1Width = 28;
    private final int level1Height = 31;
    private final int level1Map[][] = {
        {4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4},
        {4,1,1,1,1,1,1,1,1,1,1,1,1,4,4,1,1,1,1,1,1,1,1,1,1,1,1,4},
        {4,1,4,4,4,4,1,4,4,4,4,4,1,4,4,1,4,4,4,4,4,1,4,4,4,4,1,4},
        {4,2,4,6,6,4,1,4,6,6,6,4,1,4,4,1,4,6,6,6,4,1,4,6,6,4,2,4},
        {4,1,4,4,4,4,1,4,4,4,4,4,1,4,4,1,4,4,4,4,4,1,4,4,4,4,1,4},
        {4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,4},
        {4,1,4,4,4,4,1,4,4,1,4,4,4,4,4,4,4,4,1,4,4,1,4,4,4,4,1,4},
        {4,1,4,4,4,4,1,4,4,1,4,4,4,4,4,4,4,4,1,4,4,1,4,4,4,4,1,4},
        {4,1,1,1,1,1,1,4,4,1,1,1,1,4,4,1,1,1,1,4,4,1,1,1,1,1,1,4},
        {4,4,4,4,4,4,1,4,4,4,4,4,0,4,4,0,4,4,4,4,4,1,4,4,4,4,4,4},
        {6,6,6,6,6,4,1,4,4,4,4,4,0,4,4,0,4,4,4,4,4,1,4,6,6,6,6,6},
        {6,6,6,6,6,4,1,4,4,0,0,0,0,0,0,0,0,0,0,4,4,1,4,6,6,6,6,6},
        {6,6,6,6,6,4,1,4,4,0,4,4,4,5,5,4,4,4,0,4,4,1,4,6,6,6,6,6},
        {4,4,4,4,4,4,1,4,4,0,4,5,5,5,5,5,5,4,0,4,4,1,4,4,4,4,4,4},
        {0,0,0,0,0,0,1,0,0,0,4,5,5,5,5,5,5,4,0,0,0,1,0,0,0,0,0,0},
        {4,4,4,4,4,4,1,4,4,0,4,5,5,5,5,5,5,4,0,4,4,1,4,4,4,4,4,4},
        {6,6,6,6,6,4,1,4,4,0,4,4,4,4,4,4,4,4,0,4,4,1,4,6,6,6,6,6},
        {6,6,6,6,6,4,1,4,4,0,0,0,0,0,0,0,0,0,0,4,4,1,4,6,6,6,6,6},
        {6,6,6,6,6,4,1,4,4,0,4,4,4,4,4,4,4,4,0,4,4,1,4,6,6,6,6,6},
        {4,4,4,4,4,4,1,4,4,0,4,4,4,4,4,4,4,4,0,4,4,1,4,4,4,4,4,4},
        {4,1,1,1,1,1,1,1,1,1,1,1,1,4,4,1,1,1,1,1,1,1,1,1,1,1,1,4},
        {4,1,4,4,4,4,1,4,4,4,4,4,1,4,4,1,4,4,4,4,4,1,4,4,4,4,1,4},
        {4,1,4,4,4,4,1,4,4,4,4,4,1,4,4,1,4,4,4,4,4,1,4,4,4,4,1,4},
        {4,2,1,1,4,4,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,4,4,1,1,2,4},
        {4,4,4,1,4,4,1,4,4,1,4,4,4,4,4,4,4,4,1,4,4,1,4,4,1,4,4,4},
        {4,4,4,1,4,4,1,4,4,1,4,4,4,4,4,4,4,4,1,4,4,1,4,4,1,4,4,4},
        {4,1,1,1,1,1,1,4,4,1,1,1,1,4,4,1,1,1,1,4,4,1,1,1,1,1,1,4},
        {4,1,4,4,4,4,4,4,4,4,4,4,1,4,4,1,4,4,4,4,4,4,4,4,4,4,1,4},
        {4,1,4,4,4,4,4,4,4,4,4,4,1,4,4,1,4,4,4,4,4,4,4,4,4,4,1,4},
        {4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,4},
        {4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4}
    };
    
    private void printTargetMap(int value) {
        switch(value) {
            //Empty pixel
            case 0 -> 
                System.out.print("  ");
            //Food pixel
            case 1 -> 
                System.out.print("· ");
            //Poweup pixel
            case 2 -> 
                System.out.print("@ ");
            //Fruit pixel
            case 3 -> 
                System.out.print("F ");
            //Wall pixel
            case 4 -> 
                System.out.print("■ ");
            //Ghost zone pixels
            case 5 -> System.out.print("  ");
            //Void pixels
            case 6 -> System.out.print("  ");
            
        }
    }
    
    public void printMap() {
        for(int i=0; i<level1Height; i++) {
            for(int j=0; j<level1Width; j++){
                printTargetMap(level1Map[i][j]);
            }
            System.out.print("\n");
        }
    }
    
}
