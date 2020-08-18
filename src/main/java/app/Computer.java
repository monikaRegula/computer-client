package app;

public class Computer {

    private long id;
    private String ddrType;
    private long mHz;
    private int memorySize;


    public Computer() {
    }

    public Computer(long id, String ddrType, long mHz, int memorySize) {
        this.id = id;
        this.ddrType = ddrType;
        this.mHz = mHz;
        this.memorySize = memorySize;
    }

    public String getDdrType() {
        return ddrType;
    }

    public void setDdrType(String ddrType) {
        this.ddrType = ddrType;
    }

    public long getmHz() {
        return mHz;
    }

    public void setmHz(long mHz) {
        this.mHz = mHz;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "id=" + id +
                ", ddrType='" + ddrType + '\'' +
                ", mHz=" + mHz +
                ", memorySize=" + memorySize +
                '}';
    }
}
