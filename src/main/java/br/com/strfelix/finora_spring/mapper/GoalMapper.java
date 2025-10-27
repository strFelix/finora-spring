package br.com.strfelix.finora_spring.mapper;

import br.com.strfelix.finora_spring.model.Goal;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface GoalMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateGoalFromDto(Goal source, @MappingTarget Goal target);
}
