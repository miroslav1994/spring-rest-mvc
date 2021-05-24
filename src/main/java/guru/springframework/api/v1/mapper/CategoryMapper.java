package guru.springframework.api.v1.mapper;

import guru.springframework.api.v1.model.CategoryDTO;
import guru.springframework.domain.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO categoryToCategoryDTO(Category category);
}
