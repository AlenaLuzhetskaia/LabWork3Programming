package exception;

public class NeznaykaException extends Exception {
    private String name;

    public NeznaykaException(String name) {
        this.name = name;
    }

    public String getMessage() {
        return name + " и так прячется";
    }
}