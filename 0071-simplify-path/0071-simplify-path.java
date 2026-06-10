class Solution {
    public String simplifyPath(String path) {
        Deque<String> elements = new ArrayDeque<>();
        for(int i = 0; i < path.length(); i++){
            if(path.charAt(i) == '/'){
                while(i + 1 < path.length() && path.charAt(i + 1) == '/'){
                    i++;
                }
                elements.push("/");
            } else {
                String val = "" + path.charAt(i);
                while(i + 1 < path.length() && path.charAt(i + 1) != '/'){
                    i++;
                    val = val + path.charAt(i);
                }
                if (".".equals(val)) {
                    int remove = 1;
                    while(remove > 0){
                        if(elements.size() == 0){
                            break;
                        }
                        elements.pop();
                        remove--;
                    }
                } else if ("..".equals(val)){
                    int remove = 3;
                    while(remove > 0){
                        if(elements.size() == 0){
                            break;
                        }
                        elements.pop();
                        remove--;
                    }
                } else {
                    elements.push(val);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean pending = true;
        String last = "";
        while(elements.size() > 0){
            String curr = elements.pop();
            if(pending && curr.equals("/")){
                continue;
            }
            sb.insert(0, curr);
            pending = false;
            last = curr;
        }

        if(!last.equals("/")){
            sb.insert(0, "/");
        }
        return sb.toString();

    }
}