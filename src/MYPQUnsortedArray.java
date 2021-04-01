import java.util.Arrays;

public class MYPQUnsortedArray implements MyPQ<Integer, String> {
    private Entry[] entries = new Entry[1];
    private int nextPosition = 0;

    @Override
    public void insert(Integer k, String v) {
        boolean isFullArray = this.entries[this.entries.length] != null;
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


    public MYPQUnsortedArray(Entry[] entries, int capacity) {
        this.entries = entries;
        this.capacity = capacity;
    }

    public int size() {
        int size = 0;
        for (int i = 0; i < capacity; i++) {
            if (entries[i] != null)
                size++;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return nextPosition == 0;
    }


    public boolean checkArrayFull(Entry[] entry) {
        for (int i = 0; i < capacity; i++) {
            if (entry[i] == null) {
                return false;
            }
        }
        return true;
    }

    public Entry[] getEntries() {
        return entries;
    }

    public void setEntries(Entry[] entries) {
        this.entries = entries;
    }
}
