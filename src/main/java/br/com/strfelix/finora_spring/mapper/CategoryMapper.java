package br.com.strfelix.finora_spring.mapper;

import br.com.strfelix.finora_spring.model.Category;
import br.com.strfelix.finora_spring.model.Goal;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCategoryFromDto(Category source, @MappingTarget Category target);
}
