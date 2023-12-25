public class Movie {

    private String title;

    public Movie(String title) {
        this.title = title;
    }

    public void watchMovie(){

        //The method getClass is on java.lang.object. This method returns class type information about the runtime
        //instance on which this method is executing. From that, we can get the name of the class using the getSimpleName
        //method. We use method chaining for convenience.

        String instanceType = this.getClass().getSimpleName();
        System.out.println(title + " is a " + instanceType + " film");

    }

    public static Movie getMovie(String type, String title){

        return switch (type.toUpperCase().charAt(0)){
            case 'A' -> new Adventure(title);
            case 'C' -> new Comedy(title);
            case 'S' -> new ScienceFiction(title);
            default -> new Movie(title);
        };

        //This kind of method, that returns a new instance object, is known as a factory method in software programming
        //design patterns.
        //Factory methods give us a way to get an object, without having to know the details of how to create a new one,
        //or specify the exact class we want.

    }
}

class Adventure extends Movie{

    public Adventure(String title) {
        super(title);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        //The format specifier %s is used to replace any String, which is not as commonly used as others.
        System.out.printf(" .. %s%n".repeat(3),
            "Pleasant Scene",
            "Scary Music",
            "Something Bad Happens");
    }
}
class Comedy extends Movie{

    public Comedy(String title) {
        super(title);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        //The format specifier %s is used to replace any String, which is not as commonly used as others.
        System.out.printf(" .. %s%n".repeat(3),
                "Something funny happens",
                "Something even funnier happens",
                "Happy Ending");
    }
}

class ScienceFiction extends Movie{

    public ScienceFiction(String title) {
        super(title);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        //The format specifier %s is used to replace any String, which is not as commonly used as others.
        System.out.printf(" .. %s%n".repeat(3),
                "Bad Aliens do Bad Stuff",
                "Space guys chase Aliens",
                "Planet blows up");
    }
}
