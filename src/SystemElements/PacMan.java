package SystemElements;

import Engine.Points;
import Engine.Map;
import Engine.Graph;
import Engine.GraphNode;

/**
 *
 * @author franreno
 */
public class PacMan extends Movement{

    private boolean powerStatus;
    private boolean alive;
    private int lifes;
    private Points points;
    private GraphNode previousNode;
    
    public PacMan(Graph G, Map m, Points p) {
        super(G,m);
        this.powerStatus = false;
        this.alive = true;
        this.lifes = 3;
        this.points = p;
        setVelocity(0,0);
        setFirstPosition();
    }
    
    public GraphNode getPacManNode() {
        return this.gn;
    }
    
    @Override
    protected void setFirstPosition() {
        boolean flag = false;
        while(!flag) {
            this.gn = this.G.getRandomGraphNode();
            if(this.gn.getBlockValue() != 2)
                flag = true;
        }
        this.previousNode = this.gn;
        this.pos = this.gn.getPos();
        updadtePacManOnMap();
    }
    
    @Override
    protected void setVelocity(int dVertical, int dHorizontal) {
        this.dpos[0] = dVertical;
        this.dpos[1] = dHorizontal;
    }
    
    private boolean verticalPositionValidation(int[][] data, int height, int x, int y) {
        if ( x + this.dpos[0] > height-2 ) {
            return false;
        }
        else if( data[x + this.dpos[0]][y] == 4 ) {
            return false;
        }
        else
            return true;
    }
    
    private boolean horizontalPositionValidation(int[][] data, int width, int x, int y) {
        if ( y + this.dpos[1] > width-2 || y + this.dpos[1] < 0)
            return false;
        else if( data[x][y + this.dpos[1]] == 4 )
            return false;
        else
            return true;
    }
    
    public void updatePacMan() {
        int[][] data = this.map.getData();
        int height = this.map.getHeight();
        int width = this.map.getWidth();
        
        if(this.points.getPowerTimer() != 0)
            this.points.decreasePowerTimer();
        
        
        if(this.dpos[0] != 0) {
            if(verticalPositionValidation(data, height, this.pos[0], this.pos[1]))
                updadtePacManOnMap();
        }
        
        if(this.dpos[1] != 0) {
            if(horizontalPositionValidation(data, width, this.pos[0], this.pos[1]))
                updadtePacManOnMap();
        }
        
    }
    
    public void updateVelocity(char ch) {
        switch(ch) {
            case 'w' -> {
                setVelocity(-1, 0);
            }
            case 's' -> {
                setVelocity(1, 0);
            }
            case 'd' -> {
                setVelocity(0, 1);
            }
            case 'a' -> {
                setVelocity(0, -1);
            }
        }
    }
    
    private void checkEatenValue(int value) {
        if(value >= 100) 
            value -=100;
        
        switch(value) {
            // Ate normal Food
            case 1 -> this.points.hasEaten(1);
            // Ate super food
            case 2 -> this.points.hasEaten(2);
            // Ate fruit
            case 3 -> this.points.hasEaten(3);
        }
    }
     
    private void updadtePacManOnMap() {
        
        // Clear last position
        if(this.previousNode.getBlockValue() < 10 ) {
            this.map.setValueAtMap(0, this.gn);
        } else {
            this.map.setValueAtMap(this.previousNode.getBlockValue(), gn);
        }
        
        this.pos[0] += this.dpos[0];
        this.pos[1] += this.dpos[1];
        
        // Get new node
        this.gn = this.G.getGraphNode( this.map.getWidth()*this.pos[0] + this.pos[1] );
        checkEatenValue(this.gn.getBlockValue());
        
        // Set new position
        this.map.setValueAtMap(10, this.gn);
    }
}
