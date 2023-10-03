import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.javalin.http.Handler;

import java.util.ArrayList;
import java.util.List;

public class DogsController {

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // Returns all dogs from an in-memory collection of dogs
    // (You decide the data structure)

    //java collections - List:
    private List<DogDTO> dogs = new ArrayList();

    public DogsController() {

        //adding dogs to our list

        dogs.add(new DogDTO("Thomas Hartmann", "Corgi", "female", 6));


        dogs.add(new DogDTO("Chris fra Klassen", "Shitzu", "male", 2));


        dogs.add(new DogDTO("Markus", "Pomeraner", "male", 5));


        dogs.add(new DogDTO("Jon", "ChiWAUWa", "male", 11));

    }

    public Handler getAllDogs() {
        return ctx -> {
            ctx.json(gson.toJson(dogs));
        };
    }

    //Er body vores payload? Når vi sender en post,
    //så sender vi jo altid en payload (json af dog) med.
    public Handler createDog() {
        return ctx -> {
            String body = ctx.body();

            //Laver et dog objekt som brugeren gerne vil proppe ind i vores db
            DogDTO dog = gson.fromJson(body, DogDTO.class);
            dogs.add(dog);
            ctx.status(201);    //tilføjer statuskode til hver enkelte metode, som passer
        };
    }

    //Her bruger vi pathParam, som hiver parameteren ud fra path'en (url'en).
    //I dette tilfælde er dette "id"
    //Bruger vi andet end et tal som id, så vil den kaste en exception og fejle.
    public Handler getDogById() {
        return ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            ctx.json(gson.toJson(dogs.get(id)));
            ctx.status(200);        //statuskode
        };
    }

    //updateDog er en kombination af de to ovenstående metoder.
    //Når den har fået fat i både body samt id, så kan vi update disse med "set".
    public Handler updateDog() {
        return ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            String body = ctx.body();
            DogDTO dog = gson.fromJson(body, DogDTO.class);
            dogs.set(id, dog);
            ctx.status(201);        //statuskode
        };
    }

    //Her finder vi igen dog på id, og remover dette.
    public Handler deleteDog() {
        return ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            dogs.remove(id);
            ctx.status(202);        //statuskode
        };
    }
}
