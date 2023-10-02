package datapeople;

public enum Country {
    VN("V"),
    US("U"),
    JP("J");

    private final String code;

    private Country(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
