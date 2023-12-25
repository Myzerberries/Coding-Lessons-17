import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Movie theMovie = new Adventure("Star Wars");
        //When we run the calling code below, we get "Star wars is a Movie film", because the runtime instance of the
        //movie variable is the Movie class. It's the object we created in this main method, which means it's really
        //an instance of a Movie.
        theMovie.watchMovie();

        //Because Adventure is really a type of Movie, we can simply replace the new Movie statement with new Adventure.
        //Inheritance lets us say Adventure is a Movie- and assign an Adventure object to a Movie variable.

        //After we run this code, the watchMovie method is run on the Adventure class.
        //This is because at runtime, the method that gets run is determined by the Java Virtual machine based on the
        //runtime object and not this variable type.
        //This is an example of polymorphism.

        //We declared a variable type Movie and assigned it an object that's really an Adventure type of Movie.
        //And when we called watchMovie on that, the behavior was the Adventure movie's behavior.

        //The method that's on the Adventure class calls Movie's method, which is why we see the first statement, "Star
        //Wars is an Adventure film".

//        Movie theMovie2 = Movie.getMovie("Science", "Star Wars");
//        theMovie2.watchMovie();

        Scanner s = new Scanner(System.in);
        while(true){
            System.out.print("Enter Type (A for Adventure, C for Comedy, " + "S for Science Fiction" +
                    ", or Q to quit): ");

            String type = s.nextLine();
            if("Qq".contains(type)){
                break;
            }
            System.out.print("Enter Movie Title: ");
            String title = s.nextLine();
            Movie movie = Movie.getMovie(type, title);
            movie.watchMovie();
        }

    }

    //The above was polymorphism in action.

    //It's the ability to execute different behavior, for different types, which are determined at runtime.

    //And yet we did it with just two statements, in the main method: Movie movie = Movie.getMove(type, title);
    //movie.watchMovie();

    //Polymorphism enables you to write generic code, based on the base class, or a parent class.

    //And this code, in the main method, is extendable, meaning it doesn't have to change, as new subclasses become
    //available.

    //This code can handle any instances that are a Movie, or subclass of a movie, that are returned from the factory method.

}

//Polymorphism

//Simply stated, polymorphism means many forms.

//How does this apply to code?

//Polymorphism lets us write code to call a method, but at runtime, this method's behavior can be different, for different
//objects.

//This means the behavior that occurs, while the program is executing, depends on teh runtime type of the object.

//And the runtime type, might be different from teh declared type in code.

//The declared type has to have some kind of relationship to the runtime type, and inheritance is one way to establish
//this relationship.

//In the examples shown, we will have 3 subclasses of movie, each a different kind of movie.

//We'll have an Adventure film, a Comedy, and a Science Fiction movie.

//These are different categories, so we'll use these as subclasses.

//All of these will override and implement unique behavior, for the watchMovie method.