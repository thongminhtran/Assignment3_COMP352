public class MyPQSortedArray implements MyPQ<Integer,String>{
    private Entry[] entries = new Entry[1];
    int realSize = 0;

    @Override
    public Entry min() {
        if (this.isEmpty()) {
            return null;
        }
        return this.entries[0];
    }
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
        Entry entry = new Entry(k,v);
        // If the first element is null, set any entry at first index
        if(entries[0]==null){
            entries[0] = entry;
            return;
        }
        Entry[] tempEntry = entries.clone();
        //If the key is smaller than the first element
        if(entry.getK()<entries[0].getK()){
            entries[0]=entry;
            for(int i=1;i<entries.length;i++){
                entries[i] = tempEntry[i-1];
            }
        }
        else{
            for(int i=1;i<entries.length;i++){
                if(entries[i]!=null){
                    // Compare current entry to both prev and next index => put it between two index if reasonably
                    if(entry.getK()>=entries[i-1].getK()&&entry.getK()<=entries[i].getK()){
                        entries[i] = entry;
                        for(int j=i+1;j<entries.length;j++){
                            entries[j] = tempEntry[j-1];
                        }
                        break;
                    }
                } else{
                    // From the last
                    if(entry.getK()>entries[i-1].getK()){
                        entries[i] = entry;
                        break;
                    }
                }
            }
        }

    }
    @Override
    public Entry removeMin() {
        if(isEmpty()){
            return null;
        }
        Entry[] tempEntry = entries.clone();
        for(int i=0;i<this.entries.length-1;i++){
            entries[i] = tempEntry[i+1];
        }
        if(this.size()< entries.length/4){
            Entry[] newEntry = new Entry[entries.length/2];
            for(int i=0;i< entries.length/2;i++){
                newEntry[i] = entries[i];
            }
            this.entries = newEntry.clone();
        }
        return this.min();
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
        return this.entries[0] == null;
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
