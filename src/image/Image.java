package image;

import java.util.concurrent.atomic.AtomicInteger;

public class Image {
    private static final AtomicInteger count = new AtomicInteger(0);

    int id;
    String path;

    public Image(String id, String path) {

        this.id = count.incrementAndGet();;
        this.path = path;
    }

}
