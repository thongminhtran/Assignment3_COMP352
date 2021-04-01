public class LinkedList {
    public Entry data;
    public Entry data2;
    public LinkedList nextLink;
    public LinkedList(Entry data1,Entry data2){
        this.data = data1;
        this.data2 = data2;
    }
    class LinkList{
        private LinkedList first;
        public LinkList(){
            first = null;
        }
        public boolean isEmpty(){
            return first == null;
        }
        public void insert(Entry data1,Entry data2){
            LinkedList link = new LinkedList(data1,data2);
            link.nextLink = first;
            first = link;
        }
    }
}
