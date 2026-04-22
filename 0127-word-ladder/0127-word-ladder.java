class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> neighbours = new HashMap<>();
        neighbours.put(beginWord, new ArrayList<>());
        for(String word : wordList){
            List<String> currentWord = new ArrayList<>();
            neighbours.put(word, new ArrayList<>());
            for(String key : neighbours.keySet()){
                if(transformable(key, word)){
                    List<String> values = neighbours.get(key);
                    values.add(word);
                    neighbours.put(key, values);
                    currentWord.add(key);
                }
            }
            neighbours.put(word, currentWord);
        }
        Queue<String> processQueue = new LinkedList<>();
        Queue<String> candidates = new LinkedList<>();
        Set<String> processed = new HashSet<>();
        processQueue.offer(beginWord);
        int dist = 1;
        while(processQueue.size() > 0){
            String wordToProcess = processQueue.poll();
            List<String> currNeighbours = neighbours.get(wordToProcess);
            processed.add(wordToProcess);
            for(String neighbour : currNeighbours){
                if(!processed.contains(neighbour)){
                    if(endWord.equals(neighbour)){
                        return dist + 1;
                    }
                    candidates.offer(neighbour);
                }
            }
            if(processQueue.size() == 0){
                processQueue.addAll(candidates);
                candidates.clear();
                dist++;
            }
        }
        return 0;
    }

    public boolean transformable(String key, String word){
        if(key.length() != word.length()){
            return false;
        }
        int count = 0;
        for(int i = 0; i < key.length(); i++){
            if(key.charAt(i) != word.charAt(i)){
                count++;
                if(count > 1){
                    break;
                }
            }
        }
        return count == 1;
    }
}