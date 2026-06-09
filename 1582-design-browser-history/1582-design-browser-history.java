class BrowserHistory {
    ListNode currentPage;
    public BrowserHistory(String homepage) {
        this.currentPage = new ListNode(homepage);
    }
    
    public void visit(String url) {
        ListNode node = new ListNode(url);
        currentPage.next = node;
        node.prev = currentPage;
        currentPage = currentPage.next;
    }
    
    public String back(int steps) {
        while(currentPage.prev != null && steps > 0){
            currentPage = currentPage.prev;
            steps--;
        }
        return currentPage.val;
    }
    
    public String forward(int steps) {
        while(currentPage.next != null && steps > 0){
            currentPage = currentPage.next;
            steps--;
        }
        return currentPage.val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */

class ListNode {
    String val;
    ListNode next;
    ListNode prev;

    public ListNode() {

    }

    public ListNode(String val) {
        this.val = val;
    }
}