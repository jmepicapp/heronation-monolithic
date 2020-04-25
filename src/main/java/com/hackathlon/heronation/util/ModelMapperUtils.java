package com.hackathlon.heronation.util;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.data.domain.Page;

/**
 * The Class ModelMapperUtils.
 */
public class ModelMapperUtils {

    /** The model mapper. */
    private static ModelMapper modelMapper = new ModelMapper();

    /**
     * Model mapper property setting are specified in the following block. Default
     * property matching strategy is set to Strict see {@link MatchingStrategies}
     * Custom mappings are added using {@link ModelMapper#addMappings(PropertyMap)}
     */
    static {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    /**
     * Hide from public usage.
     */
    private ModelMapperUtils() {
    }

    /**
     * <p>
     * Note: outClass object must have default constructor with no arguments
     * </p>
     * .
     *
     * @param <D>      type of result object.
     * @param <T>      type of source object to map from.
     * @param entity   entity that needs to be mapped.
     * @param outClass class of result object.
     * @return new object of <code>outClass</code> type.
     */
    public static <D, T> D map(final T entity, Class<D> outClass) {
        return modelMapper.map(entity, outClass);
    }

    /**
     * <p>
     * Note: outClass object must have default constructor with no arguments
     * </p>
     * .
     *
     * @param <D>        type of objects in result list
     * @param <T>        type of entity in <code>entityList</code>
     * @param entityList list of entities that needs to be mapped
     * @param outCLass   class of result list element
     * @return list of mapped object with <code><D></code> type.
     */
    public static <D, T> List<D> mapAll(final Collection<T> entityList, Class<D> outCLass) {
        return entityList.stream().map(entity -> map(entity, outCLass)).collect(Collectors.toList());
    }

    /**
     * <p>
     * Note: outClass object must have default constructor with no arguments
     * </p>
     * .
     *
     * @param <D>            type of objects in result list
     * @param <T>            type of entity in <code>entityList</code>
     * @param entityIterable list of entities that needs to be mapped
     * @param outCLass       class of result list element
     * @return list of mapped object with <code><D></code> type.
     */
    public static <D, T> List<D> mapAll(final Iterable<T> entityIterable, Class<D> outCLass) {
        return StreamSupport.stream(entityIterable.spliterator(), false).map(entity -> map(entity, outCLass))
                .collect(Collectors.toList());
    }

    /**
     * Maps {@code source} to {@code destination}.
     *
     * @param <S>         the generic type
     * @param <D>         the generic type
     * @param source      object to map from
     * @param destination object to map to
     * @return the d
     */
    public static <S, D> D map(final S source, D destination) {
        modelMapper.map(source, destination);
        return destination;
    }

}

