class Solution {
    public boolean isRobotBounded(String instructions) {
        //iterate inst
        //need to keep track of direction?
        //what the end statement is
        //how I stop the loop?
        //north : +y , south : -y , east : +x , west : -x
        //0            180           90          270
        //-360         -180          -270        -90      
        //L : +90 , R: -90
        //always begins at 0,0
        
        int dir = 0;
        int[] curPos = new int[2]; //x,y
        int i = 0;
        while(i < instructions.length()){
            if(instructions.charAt(i) == 'G'){
                if(dir == 0) curPos[1] ++;
                else if(dir == 90) curPos[0] ++;
                else if(dir == 180) curPos[1] --;
                else curPos[0] --;
            }
            else{
                if(instructions.charAt(i) == 'L') {
                    dir += 90;
                    if(dir == 360) dir = 0;
                }
                else{
                    if(dir == 0) dir = 270;
                    else dir -= 90;
                }
            }
            i++;
        }
        if(curPos[0] == 0 && curPos[1] == 0) return true;
        if(dir == 0) return false;
        return true;
    }
}

 /*
 After all the instructions, if robot is at (0,0), that means the robot will be at (0,0) after every cycle, so must be true.
After all the instructions, if robot is not at (0,0) and face north, say it's at (x,y), that means after every cycle, robot moves [x-0, y-0] but its direction is still the starting direction (north), that means it will keep moving further away from (0,0) infinitely if we continue to repeat the loop, therefore false.
After all the instructions, if robot is not at (0,0) and face non-north, then it means:
if direction is east, that means robot turns right after every cycle (from north to east), so eventually it will stay in the same area instead of moving further away from (0,0) infinitely
same thing for every other non-north directions
*/
