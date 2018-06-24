package ipomoea.jokes;

import java.util.Random;

public class Jokes {

    private final String[] JOKES = {
            "What swims and starts with a T? - Two ducks.",
            "What can you serve, but never eat? - A tennis ball.",
            "What did zero say to eight? - Nice belt!",
            "What do pandas have that no other animal has? - Baby pandas."
    };

    public String getAJoke() {
        Random random = new Random();
        int index = random.nextInt(JOKES.length);
        return JOKES[index];
    }
}
