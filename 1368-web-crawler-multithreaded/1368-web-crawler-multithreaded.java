/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */
class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        String hostname = startUrl.split("/")[2];
        Set<String> visited = ConcurrentHashMap.newKeySet();
        Set<String> current = ConcurrentHashMap.newKeySet();
        current.add(startUrl);
        ExecutorService executor = new ThreadPoolExecutor(10, 50, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10000));
        CompletionService<List<String>> completionService = new ExecutorCompletionService<>(executor);
        while(current.size() > 0){
            for(String url : current){
                Future<List<String>> future = completionService.submit(() -> htmlParser.getUrls(url));
                visited.add(url);
            }
            int size = current.size();
            current.clear();
            for(int i = 0; i < size; i++){
                try{
                    Future<List<String>> completedFuture = completionService.take();
                    List<String> crawledStrings = completedFuture.get();
                    for(String crawledString : crawledStrings){
                        if(!visited.contains(crawledString) && hostname.equals(crawledString.split("/")[2])){
                            current.add(crawledString);
                        }
                    }
                } catch(Exception e) {
                    continue;
                }
            }
        }
        executor.shutdown();
        return new ArrayList<>(visited);
    }
}