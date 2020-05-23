package categorie;

import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class CategorieAccessoire extends Categorie{
    private static final AtomicInteger count = new AtomicInteger(0);

    public CategorieAccessoire( String title) {
        super( title);
    }
}
