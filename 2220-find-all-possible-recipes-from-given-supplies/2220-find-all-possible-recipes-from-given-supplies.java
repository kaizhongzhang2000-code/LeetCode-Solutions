class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> supplySet = new HashSet<>();
        for(String supply : supplies){
            supplySet.add(supply);
        }
        Set<Integer> made = new HashSet<>();
        List<String> result = new ArrayList<>();
        while(made.size() < recipes.length){
            int size = made.size();
            for(int i = 0; i < recipes.length; i++){
                if(made.contains(i)){
                    continue;
                }
                boolean makable = true;
                for(String ingredient : ingredients.get(i)){
                    if(!supplySet.contains(ingredient)){
                        makable = false;
                        break;
                    }
                }
                if(makable){
                    made.add(i);
                    supplySet.add(recipes[i]);
                    result.add(recipes[i]);
                }
            }
            if(made.size() == size){
                break;
            }
        }
        return result;
    }
}