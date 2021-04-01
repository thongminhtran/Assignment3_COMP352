import java.util.Map;

public class Entry implements Map.Entry<Integer,String> {
    private Integer K;
    private String V;
    public Entry(Integer k,String v) {
        K = k;
        V = v;

    }
    public Entry(Entry another){
        this.K = another.K;
        this.V = another.V;
    }

    @Override
    public Integer getKey() {
        return K;
    }

    @Override
    public String getValue() {
        return null;
    }

    @Override
    public String setValue(String value) {
        String temp = V;
        V = value;
        return temp;
    }

    public void setKey(Integer key){
        K = key;
    }

}
