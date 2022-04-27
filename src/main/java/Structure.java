import java.util.List;
import java.util.Optional;

public interface Structure {
    // returns any element of the given color
    Optional<Block> findBlockByColor (String color);

    // return all items from the given material
    List<Block> findBlocksByMaterial (String material);

    // return the total number of elements that make up the structure
    int count ();
}
