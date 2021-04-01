import java.util.Map;

public class Entry implements Map.Entry<Integer,String> {
    private Integer K;
    private String V;
    public Entry(Integer k,String v) {
        K = k;
        V = v;
    }

    public void setK(Integer k) {
        K = k;
    }

    public void setV(String v) {
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
        return V;
    }

    @Override
    public String setValue(String value) {
        this.V = value;
        return null;
    }


}
