public class NextMain {

    public static void main(String[] args) {

        Movie movie = Movie.getMovie("A", "Jaws");
        movie.watchMovie();

        Adventure jaws = (Adventure) Movie.getMovie("A", "Jaws");
        jaws.watchMovie();

        //The above, as written, declared that the method getMovie is going to return a Movie class. We didn't say it
        //was going to return an instance of the Adventure class. The compiler asks the question, can every kind of
        //Movie (Which is the return type of this method) be called an Adventure, meaning can every kind of Movie be
        //assigned to an Adventure variable? In this case, the answer is no. The Adventure reference, Jaws, would not
        //be able to handle a Comedy movie, if that got returned, for example That's because we can't say a Comedy is
        //an Adventure. But we know for sure that when we pass the letter A as the type, that we'll get an Adventure
        //movie back. But the compiler can't figure that out, without executing code, and it's not going to do that.
        //We can give the compiler more detailed instructions to get around this issue. One way to do this is casting.

        //We add to the original code, a cast- so that we cast Movie as an Adventure type, and also make a call to
        //watchMovie.

        //If we were to input "C" instead, we would get an exception: ClassCastException.

        //We got a Comedy object, when an Adventure object was expected.

        //We might ask if we can assign an object of one type to a reference with a different type?

        //Firstly, you can assign any object to a reference that is of type Object.

        Object comedy = Movie.getMovie("C", "Airplane");
        Comedy comedyMovie = (Comedy) comedy;
        comedyMovie.watchComedy();

        //We are casting and setting the object's (Comedy) variable, comedyMovie, to the value of the object comedy.
        //We also cast comedy as the Comedy object type. The reason we do this is because casting it as a Movie type is
        //too generic, and Java can't compile it. To set the variable comedyMovie equal to the value of comedy, it must
        //be cast more specifically. After doing this, we can successfully make a call to the method watchComedy() on
        //the comedyMovie object (Object instance).

        var airplane = Movie.getMovie("C", "Airplane");
        airplane.watchMovie();

        //Above we use the keyword var for the first time. So what is var?

        //var is a special contextual keyword in Java, that lets our code take advantage of Local Variable Type inference.

        //By using var as the type, we're telling Java to figure out the compile-time type for us.

        //In our usage of var, since the Movie class was declared as the return type of the static method getMovie,
        //then Java can infer that the type of this variable, airplane, should be a Movie. We can see this in the "hints"
        //that inetlliJ gives us (Movie:).

        var plane = new Comedy("Airplane");
        plane.watchComedy();

        //In the next case above, Java had an easier time to infer the type, because we're simply assigning a new instance
        //of Comedy to this variable, plane. So we can use the plane variable to execute methods specific to Comedy,
        //without compile time errors.

        //Using the var keyword is utilizing Local Variable Type Inference.

        //One of the benefits is to help with the readability of the code, and to reduce boilerplate code.

        //It's called Local Variable Type Inference for a reason, because:

        //It can't be used in field declarations on a class.

        //It can't be used in method signatures, either as a parameter type or a return type.

        //It can't be used without an assignment, because the type can't be inferred in that case.

        //It can't be assigned a null literal, again because a type can't be inferred in that case.

        //Run Time vs. Compile Time Typing:

        //We can think of compile time type as the DECLARED type.

        //This type is declared either as a variable reference, or a method return type, or a method parameter.

        //In the case of LVTI, we don't declare a type for the compiled reference type; it gets inferred, but the byte
        //code is the same, as if we had declared it.

        //In many cases, the compile time type is the declared type to the left of the assignment operator.

        //What is returned on the right side of the assignment operator, from whatever expression or method is executed,
        //sometimes can only be determined at runtime, when the code is executing conditionally, through the statements
        //in the code.

        //You can assign a runtime instance to a different compile time type only if certain rules are followed.

        //So far, we have only looked at one rule that applies: The Inheritance rule.

        //We can assign an instance to a variable of the same type, or a parent type, or a parent's parent type,
        //including java.lang.Object, the ultimate base class.

        //Why are runtime types different than compile time types?

        //Because of polymorphism.

        //Polymorphism lets us write code once, in a more generic fashion, like the code found in this project.

        //We saw earlier that using a single compile time type of Movie, actually supported four different runtime
        //types.

        //Each type was able to execute behavior unique to the class.


        //So how do we test what the runtime type of variable really is at runtime, if the declared type is something
        //else?

        //We can test to see what type the actual object is at runtime in several different ways.

        Object unknownObject = Movie.getMovie("C", "Airplane");
        if(unknownObject.getClass().getSimpleName() == "Comedy"){
            Comedy c = (Comedy) unknownObject;
            c.watchComedy();
        } else if(unknownObject instanceof Adventure){            //The instanceof operator lets you test the type of
            ((Adventure) unknownObject).watchAdventure();         //object or instance. The reference variable you are
        } else if(unknownObject instanceof  ScienceFiction syfy){ //testing is the left operand(unknownObject). The type
            syfy.watchScienceFiction();                           //you are testing for is the right operand(Adventure).
        }                                                         //It's important to note that Adventure is not in quotes,
    }                                                             //meaning we're not testing the type name, but the actual
                                                                  //type. This operator returns true if unknownObject is an
}                                                                 //instance of Adventure.

//In the else if(unknownObject instanceof ScienceFiction syfy) statement, we see an example of Patter Matching for the
//instanceof Operator.

//If the JVM can identify the object matches the type, it can extract data from the object, without casting.

//for this operator, the object can be assigned to a binding variable, which here is called syfy.

//The variable syfy(if the instanceof method returns true) is already typed as a ScienceFiction variable.

//If we were to change the arguments "C" and "Airplane" to other arguments that match other movie types, we would
//see that the RUNTIME TYPE would change- and our output would change accordingly.

