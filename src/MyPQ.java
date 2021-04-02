public interface MyPQ<K,V> {
    public void insert(K k, V v) throws Exception;
    public AbstractEntry<K,V> min();
    public AbstractEntry<K,V> removeMin();
    public int size();
    public boolean isEmpty();
}
