package categorie;

public class CategorieMedicament  extends Categorie{
    boolean avecOuSansOrdonance;

    public CategorieMedicament( String title, boolean avecOuSansOrdonance) {
        super( title);
        this.avecOuSansOrdonance = avecOuSansOrdonance;
    }


}
