public abstract class AbstractEntry<K,V> {
    K k;
    V v;
    public K getK() {
        return k;
    }
    public V getV() {
        return v;
    }
    public void setK(K k) {
        this.k = k;
    }
    public void setV(V v) {
        this.v = v;
    }
}
