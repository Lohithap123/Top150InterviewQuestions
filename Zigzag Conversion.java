class Solution {
    public String convert(String s, int numRows) {
        //if number of row equal to one return string
        if(numRows == 1)
            return s;
        int temp = s.length();
        char [][]arr = new char [numRows][temp];
        int row = 0;
        int col = 0;
        int counter = s.length();
        int t = 0;
        //condition for terminate Loop
        while(col < temp && t < counter){
            //top to bottom traverse
            while(row < numRows && t < counter){
                if(row == 0 && col != 0){
                    row++;
                    continue;
                }  
                arr[row][col] = s.charAt(t);
                t++;
                row++;
            }
            row--;
            // bottom to right traverse
            while(row > 0 && (col + 1) < temp && t < counter){
                arr[--row][++col] = s.charAt(t);
                t++;
            }

        }
        String fres = "";
        // stored the string 
        for(int i = 0 ; i < numRows ; i++){
            for(int j = 0 ; j < temp ; j++){
                if(arr[i][j] != '\u0000'){
                    fres += arr[i][j];
                }
            }
        }
        // return the output
        return fres;
    }
}
