public class MyPQSortedArray implements MyPQ<Integer, String> {
    private Entry[] entries = new Entry[1];

    @Override
    public Entry min() {
        if (this.isEmpty()) {
            return null;
        }
        return this.entries[0];
    }

    @Override
    public void insert(Integer k, String v) {
        Entry entry = new Entry(k, v);
        if (isEmpty()) {
            entries[0] = entry;
            return;
        }
        boolean isFullArray = this.entries[this.entries.length - 1] != null;
        if (isFullArray) {
            upSize();
        }
        int positionShouldBeInserted = findPositionOfEntryLessThanNewValue(k);
        try {
            insertWithPosition(positionShouldBeInserted, entry);
        } catch (Exception e) {
            System.out.println("Exception when insert a new value " + e.getMessage());
        }
    }

    @Override
    public Entry removeMin() {
        if (isEmpty()) {
            return null;
        }
        int expectedSize = size() - 1;
        Entry minEntry = this.min();
        int currentCapacity = this.entries.length;
        boolean isSizeLessThan25Percentage = expectedSize < 0.25 * currentCapacity;
        if (isSizeLessThan25Percentage) {
            currentCapacity = currentCapacity / 2;
        }
        Entry[] tempEntry = new Entry[currentCapacity];
        // Remove first element
        for (int i = 0; i < size() - 1; i++) {
            entries[i] = tempEntry[i + 1];
            tempEntry[i] = this.entries[i + 1];
        }
        this.entries = tempEntry.clone();

        return minEntry;
    }

    @Override
    public int size() {
        int size = 0;
        for (int i = 0; i < entries.length; i++) {
            if (entries[i] == null) {
                break;
            } else {
                size++;
            }
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return this.entries[0] == null;
    }

    /**
     * Find the position to insert the value in the array
     *
     * @param newValueK: value that I want to insert
     * @return -1 if empty array, otherwise is the index I want to insert
     */
    private int findPositionOfEntryLessThanNewValue(int newValueK) {
        if (isEmpty()) return -1;
        for (int index = 0; index < this.entries.length; index++) {
            Entry currentEntry = this.entries[index];
            if (currentEntry != null) {
                // Continue to check
                if (currentEntry.getK() >= newValueK) {
                    return index;
                }
            }
        }
        // If reach here and not return, it means this is the largest value, I will insert at the end
        return size();
    }

    private void upSize() {
        Entry[] temporaryEntries = new Entry[this.entries.length * 2];
        for (int i = 0; i < this.entries.length; i++) {
            temporaryEntries[i] = this.entries[i];
        }
        this.entries = temporaryEntries.clone();
    }

    /**
     * @param positionShouldBeInserted: position want to be inserted
     * @param entry                     that I want to insert
     * @throws Exception when position is not valid to insert
     */
    private void insertWithPosition(int positionShouldBeInserted, Entry entry) throws Exception {
        boolean isPositionValid = positionShouldBeInserted <= size() && positionShouldBeInserted > -1;
        if (!isPositionValid) throw new Exception("Position inserted is not valid!");
        Entry[] tempEntries = this.entries.clone();
        if (positionShouldBeInserted == 0) {
            entries[0] = entry;
            for (int i = 1; i < entries.length; i++) {
                entries[i] = tempEntries[i - 1];
            }
        } else {
            int countingIndex = 0;
            // Copy the beginning
            for (int index = 0; index < positionShouldBeInserted; index++) {
                entries[countingIndex] = tempEntries[index];
                countingIndex++;
            }
            entries[positionShouldBeInserted] = entry;
            // Copy the rest
            boolean isLastElement = positionShouldBeInserted == size() - 1;
            if (!isLastElement) {
                for (int index = positionShouldBeInserted + 1; index < size(); index++) {
                    entries[countingIndex] = tempEntries[index];
                    countingIndex++;
                }
            }
        }
    }
}
