package at.htl.entities;

public class Submition {

    public String pathToZip;
    public LeocodeStatus status;
    public String author;

    public Submition() {
        this.status = LeocodeStatus.CREATED;
    }

    public Submition(String pathToZip, String author) {
        this();
        this.pathToZip = pathToZip;
        this.author = author;
    }

    public Submition(String pathToZip, LeocodeStatus status, String author) {
        this.pathToZip = pathToZip;
        this.status = status;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Submition{" +
                "pathToZip='" + pathToZip + '\'' +
                ", status=" + status +
                ", author='" + author + '\'' +
                '}';
    }
}
