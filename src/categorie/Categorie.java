package categorie;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Categorie {
    private static final AtomicInteger count = new AtomicInteger(0);

    int id;
    String title;

    public Categorie( String title) {
        this.id = id;
        this.title = title;
    }
}
