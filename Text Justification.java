class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> s = new ArrayList<String>();
        int idx = 0;
        List<Integer> space = new ArrayList<>();
        StringBuilder line = new StringBuilder();
        for(int i=0; i<words.length; i++){
            if(line.length()==0 || line.length()+words[i].length()<maxWidth){
                line = createLine(line, words[i], space);
                if(line.length()==maxWidth){
                    s.add(line.toString());
                    line=new StringBuilder();
                    space=new ArrayList<>();
                }
                else{
                    if(i==words.length-1){
                        s.add(leftJust(line, maxWidth).toString());
                    }
                }
            }
            else{
                line = addSpace(line,maxWidth,space);
                s.add(line.toString());
                space=new ArrayList<>();
                line = createLine(new StringBuilder(), words[i], space);
                if(i==words.length-1)
                    s.add(leftJust(line, maxWidth).toString());
            }
        }
        return s;

    }
    public StringBuilder createLine(StringBuilder line, String words, List<Integer> space){
        if(line.length()==0){
            line.append(words);
        }
        else{
            line.append(" ");
            space.add(line.length()-1);
            line.append(words);
        }
        return line;
    }
    public StringBuilder leftJust(StringBuilder line, int width){
        while(line.length()<width){
            line.append(" ");
        }
        return line;
    }
    public StringBuilder addSpace(StringBuilder line, int width, List<Integer> space){
        if(space.size()==0){
            return leftJust(line,width);
        }
        int prev = 0;
        int j=0;
        while(line.length()<width){
            if(j==0){
                line.insert(space.get(j++), " ");
            }
            else{
                line.insert(space.get(j++)+prev, " ");
            }
            if(j==space.size()){
                j=0;
            }
            prev++;
        }
        return line;
    }
}
