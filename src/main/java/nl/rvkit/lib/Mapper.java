package nl.rvkit.lib;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public final class Mapper {

    public static final ModelMapper MODEL_MAPPER = new ModelMapper();

    static {
        Mapper.MODEL_MAPPER.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public static <SRC, DEST> DEST map(final SRC source, Class<DEST> destClazz) {
        return Mapper.MODEL_MAPPER.map(source, destClazz);
    }

    public static <SOURCE, DEST> DEST map(final SOURCE source, DEST destination) {
        Mapper.MODEL_MAPPER.map(source, destination);
        return destination;
    }

    public static <SOURCE, DEST> List<DEST> map(final Collection<SOURCE> sourceList, Class<DEST> destClazz) {
        return sourceList.stream().map(source -> Mapper.MODEL_MAPPER.map(source, destClazz)).collect(Collectors.toList());
    }
}