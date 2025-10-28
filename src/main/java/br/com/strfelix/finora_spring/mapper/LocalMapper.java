package br.com.strfelix.finora_spring.mapper;

import br.com.strfelix.finora_spring.model.Goal;
import br.com.strfelix.finora_spring.model.Local;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface LocalMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateGoalFromDto(Local source, @MappingTarget Local target);
}
