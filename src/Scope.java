import java.util.Map;
import java.util.HashMap;

/**
 * Created by jli on 5/26/15.
 */
public class Scope {
    public Scope(){};
    public <T> Map<String, T> getAbc() {
        return abc;
    }

    public <T> void setAbc(Map<String, T> abc) {
        this.abc = abc;
    }

    private Map abc = null;

    public int getEfg() {
        return efg;
    }

    public void setEfg(int efg) {
        this.efg = efg;
    }

    private int efg;
}
