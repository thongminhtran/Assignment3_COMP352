public class MYPQUnsortedArray implements MyPQ<Integer, String> {
    private Entry[] entries = new Entry[1];
    private int realSize = 0;

    @Override
    public void insert(Integer k, String v) {
        boolean isFullArray = realSize == entries.length;
        if (isFullArray) {
            Entry[] temporaryEntries = new Entry[this.entries.length * 2];
            for (int i = 0; i < this.entries.length; i++) {
                temporaryEntries[i] = this.entries[i];
            }
            this.entries = temporaryEntries.clone();
        }
        Entry entry = new Entry(k, v);
        this.entries[realSize] = entry;
        realSize++;
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
        try{
            this.removeByPosition(minPosition);
            return minEntry;
        }catch(Exception e) {
            System.out.println("Exception " + e.getMessage());
            return null;
        }
    }

    /**
     *
     * @param position: Position we want to remove
     * @throws Exception: If position passing is not valid or if array is empty
     */
    private void removeByPosition(int position) throws Exception {
        // [3,1,2] ==> [3,2] ==> position = 1;
        boolean isPositionValid = position < realSize && realSize > 0;
        if (!isPositionValid) throw new Exception("Position " + position + " is more than the real size " + realSize);
        int expectedSizeAfterRemovingItem = realSize - 1;
        boolean isExpectedSizeAfterRemovingItemLessThan25PercentageCapacity = expectedSizeAfterRemovingItem < 0.4 * this.entries.length;
        if (isExpectedSizeAfterRemovingItemLessThan25PercentageCapacity) {
            expectedSizeAfterRemovingItem = expectedSizeAfterRemovingItem / 2;
        }
        Entry[] temporaryEntries = new Entry[expectedSizeAfterRemovingItem];
        // Copy the first element
        if (position == 0) {
            // Remove first element
            for (int index = 1; index < realSize; index ++) {
                temporaryEntries[index - 1] = this.entries[index];
            }
        } else {
            int temporaryEntriesIndex = 0;
            // Copy the beginning
            for (int index = 0; index < position - 1; index ++) {
                temporaryEntries[temporaryEntriesIndex] = this.entries[index];
                temporaryEntriesIndex++;
            }
            // Copy the rest
            boolean isLastElement = position == realSize - 1;
            if (!isLastElement) {
                for (int index = position + 1; index < realSize; index ++) {
                    temporaryEntries[temporaryEntriesIndex] = this.entries[index];
                    temporaryEntriesIndex++;
                }
            }
        }
        this.entries = temporaryEntries.clone();
        realSize --; // Update real size
    }

    /**
     *
     * @param key: the key given to get the index of an entry in an array
     * @return the index of the entry, return -1 when we cannot find the entry
     */
    private int getPositionByKey(Integer key) {
        for (int i = 0; i < entries.length; i++) {
            if (entries[i] == null) {
                break;
            }
            if (entries[i].getK().equals(key)) {
                return i;
            }
        }
        return -1;
    }
    @Override
    /**
     * @return size of the array
     */
    public int size() {
        return realSize;
    }

    @Override
    /**
     * @return boolean true if an array is empty
     */
    public boolean isEmpty() {
        return realSize == 0;
    }
}
