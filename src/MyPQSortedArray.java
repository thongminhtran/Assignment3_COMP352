public class MyPQSortedArray {
    private Entry[] entries;
    private int capacity = 1;
    public MyPQSortedArray(){
        this.capacity = 1;
    }

    public MyPQSortedArray(Entry[] entries, int capacity) {
        this.entries = entries;
        this.capacity = capacity;
    }
    public void addEntries(Entry entry){

    }
    public int size(){
        int size = 0;
        for(int i=0;i<capacity;i++){
            if(entries[i]!=null)
                size++;
        }
        return size;
    }
    public boolean isEmpty(){
        if(this.size() ==0)
            return true;
        else{
            for(int i = 0; i< capacity; i++){
                if(entries[i]!=null)
                    return false;
            }
        }
        return true;
    }
    public void insert(Integer k, String v) {
        //TODO: I dont know how to change size of array
        Entry entry = new Entry(k,v);
        if (checkArrayFull(entries)) {
            //Double the length if the array is full
            capacity = capacity * 2;
        }
        for(int i=0;i<entries.length;i++){
            if(entries[i]==null){
                entries[i] = entry;
            }
        }
    }

    public Entry min(){
        int min = 99999;
        for(int i = 0; i< capacity; i++){
            if(min>entries[i].getKey())
                min = entries[i].getKey();
        }
        for(int j = 0; j< capacity; j++){
            if(entries[j].getKey()==min)
                return entries[j];
        }
        return null;
    }
    public void removeMin(){
        for(int i = 0; i< capacity; i++){
            if(entries[i].getKey()==min().getKey()&&entries[i].getValue()==min().getValue())
                entries[i] = null;
        }
        if(this.size()<capacity/4){
            this.capacity = capacity/2;
        }
    }
    public boolean checkArrayFull(Entry[] entry) {
        for (int i = 0; i < capacity; i++) {
            if (entry[i] == null) {
                return false;
            }
        }
        return true;
    }

    public void printArray(){
        for(int i=0;i<this.size();i++){
            System.out.println(entries[i].getKey()+" "+entries[i].getValue());
        }
    }
    public Entry[] getEntries() {
        return entries;
    }

    public void setEntries(Entry[] entries) {
        this.entries = entries;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
