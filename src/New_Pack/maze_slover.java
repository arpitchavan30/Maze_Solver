package New_Pack;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class maze_slover extends JFrame {
    private int[][] maze = {
            {1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,1,0,1,0,0,0,0,0,1,0,1},
            {1,0,0,0,0,1,0,1,0,1,0,1,1},
            {1,0,1,0,1,0,1,0,0,0,1,0,1},
            {1,0,0,0,0,0,1,1,0,1,0,1,1},
            {1,0,1,0,0,0,0,0,0,1,0,1,1},
            {1,1,1,1,1,1,0,1,1,1,1,1,1},
            {1,0,0,0,1,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,1,0,1,0,5,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1}
    };

    public ArrayList<Integer> path = new ArrayList<>();

    public maze_slover(){
        setTitle("Maze Slover");
        setSize(640,720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DFS.searchpath(maze,1,1,path); // call function and give starting point at [1][1]
    }

    @Override
    public void paint(Graphics g){
        g.translate(50,50);

        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[0].length;j++){
                Color color;
                // add conditions for 1 color is black (obstacle)
                switch (maze[i][j]){
                    case 1: color=Color.BLACK; break;
                    case 5:color=Color.RED; break;
                    default: color=Color.WHITE; break;
                }
                g.setColor(color);
                g.fillRect(30*j,30*i,30,30);
                g.setColor(Color.red);
                g.drawRect(30*j,30*i,30,30);
            }
        }

        // traverse path array
        // we are saving x and y co-ordinates in arraylist,
        // so we are traversing x co-ordinates only , we will get y co-odinates ie i+1..
        for(int i=0;i<path.size();i+=2){
            int pathx = path.get(i);
            int pathy = path.get(i+1);

            // noe set color to our path or indicate a path somehow
            g.setColor(Color.GREEN);
            g.fillRect((30*pathx + 2),(30*pathy + 2),26,26);
        }
    }
    public static void main(String[] args){
        maze_slover view = new maze_slover();
        view.setVisible(true);
    }

}
