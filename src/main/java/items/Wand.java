package items;

public class Wand {
    private String wood;
    private String core;

    public Wand(String wood, String core) {
        this.wood = wood;
        this.core = core;
    }

    public String getWood() {
        return wood;
    }

    public void setWood(String wood) {
        this.wood = wood;
    }

    public String getCore() {
        return core;
    }

    public void setCore(String core) {
        this.core = core;
    }
}
