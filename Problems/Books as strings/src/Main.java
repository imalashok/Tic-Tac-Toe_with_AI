class Book {

    private String title;
    private int yearOfPublishing;
    private String[] authors;

    public Book(String title, int yearOfPublishing, String[] authors) {
        this.title = title;
        this.yearOfPublishing = yearOfPublishing;
        this.authors = authors;
    }

    @Override
    public String toString() {

        String bookString = "title=" + title + ",yearOfPublishing=" + yearOfPublishing + ",authors=[";
        bookString += String.join(",", authors);
        bookString += "]";

        return bookString;
    }
}