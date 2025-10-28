package br.com.strfelix.finora_spring.mapper;

import br.com.strfelix.finora_spring.model.Recurrence;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface RecurrenceMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateRecurrenceFromDto(Recurrence source, @MappingTarget Recurrence target);
}


