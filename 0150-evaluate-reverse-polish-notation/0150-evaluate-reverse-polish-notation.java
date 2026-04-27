class Solution {
    public int evalRPN(String[] tokens) {
        String plus = "+";
        String minus = "-";
        String multi = "*";
        String divide = "/";
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        for(int i = 0; i < tokens.length; i++){
            if(plus.equals(tokens[i])){
                int second = numbers.pop();
                int first = numbers.pop();
                numbers.push(second + first);
            } else if(minus.equals(tokens[i])){
                int second = numbers.pop();
                int first = numbers.pop();
                numbers.push(first - second);
            } else if(multi.equals(tokens[i])){
                int second = numbers.pop();
                int first = numbers.pop();
                numbers.push(second * first);
            } else if(divide.equals(tokens[i])){
                int second = numbers.pop();
                int first = numbers.pop();
                numbers.push(first / second);
            } else {
                numbers.push(Integer.parseInt(tokens[i]));
            }
        }
        int result = numbers.pop();
        return result;
    }
}