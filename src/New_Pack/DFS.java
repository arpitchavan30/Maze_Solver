package New_Pack;

import java.util.List;

public class DFS {
    public static boolean searchpath(int [][] maze, int x, int y, List<Integer> path){
        // base case
        if(maze[y][x]==5){
            // we are at destination
            path.add(x);
            path.add(y);
            return true;
        }
        // postion is 0 ie we can move further
        if(maze[y][x]==0){
            maze[y][x]=2; // mark visited or just change value by some another val

            // check for all directions..

            //check for up
            int dx=-1;
            int dy=0;
            if(searchpath(maze,x+dx,y+dy,path)){
                path.add(x);
                path.add(y);
                return true;
            }
            //check for down
            dx=1;
            dy=0;
            if(searchpath(maze,x+dx,y+dy,path)){
                path.add(x);
                path.add(y);
                return true;
            }
            //check for left
            dx=0;
            dy=-1;
            if(searchpath(maze,x+dx,y+dy,path)){
                path.add(x);
                path.add(y);
                return true;
            }
            //check for right
            dx=0;
            dy=1;
            if(searchpath(maze,x+dx,y+dy,path)){
                path.add(x);
                path.add(y);
                return true;
            }

        }
        return false;
    }
}
