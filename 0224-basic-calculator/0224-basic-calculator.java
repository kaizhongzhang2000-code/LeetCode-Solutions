class Solution {
    public record valueIndex(int value, int index){

    }
    public int calculate(String s) {
        valueIndex result = calculateVal(s, 0);
        return result.value;
    }

    public valueIndex calculateVal(String s, int index){
        int val = 0;
        boolean plus = true;
        while(index < s.length()){
            int sum = 0;
            if(s.charAt(index) == '+'){
                plus = true;
                index++;
            } else if(s.charAt(index) == '-'){
                plus = false;
                index++;
            } else if(s.charAt(index) <= '9' && s.charAt(index) >= '0'){
                while(index < s.length() && s.charAt(index) <= '9' && s.charAt(index) >= '0'){
                    sum = sum * 10 + s.charAt(index) - '0';
                    index++;
                }
            } else if(s.charAt(index) == '('){
                valueIndex localSum = calculateVal(s, index + 1);
                sum = localSum.value;
                index = localSum.index + 1;
            } else if(s.charAt(index) == ')'){
                return new valueIndex(val, index);
            } else if(s.charAt(index) == ' '){
                index++;
                continue;
            }
            val = plus ? val + sum : val - sum;
        }
        return new valueIndex(val, index);
    }
}