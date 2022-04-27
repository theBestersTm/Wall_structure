import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Wall implements Structure {

    private static final Function<Block, Stream<Block>> MAP_TO_BLOCK = (block -> block instanceof CompositeBlock ? ((CompositeBlock) block).getBlocks().stream() : Stream.of(block));

    private List<Block> blocks;

    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return blocks.stream().flatMap(MAP_TO_BLOCK).filter(block -> block.getColor().equals(color)).findFirst();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return blocks.stream().flatMap(MAP_TO_BLOCK).filter(block -> block.getMaterial().equals(material)).collect(Collectors.toList());
    }

    @Override
    public int count() {
        return (int) blocks.stream().flatMap(MAP_TO_BLOCK).count();
    }
}
