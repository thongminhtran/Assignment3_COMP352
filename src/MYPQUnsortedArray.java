public class MYPQUnsortedArray implements MyPQ<Integer, String> {
    private Entry[] entries = new Entry[1];
    private int nextPosition = 0;


    @Override
    public void insert(Integer k, String v) {
        boolean isFullArray = this.entries[this.entries.length-1] != null;
        if (isFullArray) {
            Entry[] temporaryEntries = new Entry[this.entries.length * 2];
            for (int i = 0; i < this.entries.length; i++) {
                temporaryEntries[i] = this.entries[i];
            }
            this.entries = temporaryEntries.clone();
        }
        Entry entry = new Entry(k, v);
        this.entries[nextPosition] = entry;
        nextPosition++;
    }

    @Override
    public Entry min() {
        if (this.isEmpty()) {
            return null;
        }
        Integer minK = entries[0].getK();
        int currentMinPosition = 0;
        for (int i = 0; i < entries.length; i++) {
            if (entries[i] == null) {
                break;
            }
            if (minK > entries[i].getK()) {
                minK = entries[i].getK();
                currentMinPosition = i;
            }
        }
        return entries[currentMinPosition];
    }

    @Override
    public Entry removeMin() {
        Entry minEntry = min();
        if (minEntry == null) {
            return null;
        }
        int minPosition = this.getPositionByKey(minEntry.getK());
      //  [1,2,3]
        // index = 0;
        // [2,3,null] // move 2,3
        // [3,2,1] ==> [3,2,null] // move no one
        // [3,1,2] ==> [3,2,null]// move 2
        for(int i=minPosition;i< entries.length;i++){
                // The last element will be null after removing the minimum entry
                if(i == this.size()-1){
                    entries[i] = null;
                }
                else if(i<entries.length-1){
                    entries[i] = entries[i+1];
                }
        }
        if(this.size()< entries.length/4){
            Entry[] tempEntry = new Entry[entries.length/2];
            for(int i=0;i< entries.length/2;i++){
                tempEntry[i] = entries[i];
            }
            this.entries = tempEntry.clone();
        }
        nextPosition--;
        return minEntry;
    }

    private int getPositionByKey(Integer key) {
        for (int i = 0; i < entries.length; i++) {
            if (entries[i] == null) {
                break;
            }
            if(entries[i].getK()==key){
                return i;
            }
        }
        return -1;
    }

    public int size() {
        int size = 0;
        for (int i = 0; i < entries.length; i++) {
            if (entries[i] != null)
                size++;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return nextPosition == 0;
    }

    public void printArray(){
        for(int i=0;i<this.size();i++){
            System.out.println(entries[i].getK()+" "+entries[i].getV());
        }
    }



    public Entry[] getEntries() {
        return entries;
    }

    public void setEntries(Entry[] entries) {
        this.entries = entries;
    }
}
