/**
 * Created by jli on 5/28/15.
 */
public enum Currency {
    PENNY(1, "P"),
    NICKLE(2, "N"),
    DIME(3, "d");

    private int code;
    private String value;

    private Currency(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public static Currency fromCode(int code) {
        switch(code) {
            case 1: return PENNY;
            case 2: return NICKLE;
            case 3: return DIME;
            default: return PENNY;
        }
    }

}
