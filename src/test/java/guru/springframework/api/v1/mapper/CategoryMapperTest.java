package guru.springframework.api.v1.mapper;

import guru.springframework.api.v1.model.CategoryDTO;
import guru.springframework.domain.Category;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CategoryMapperTest {

    public static final String NAME = "Joe";
    public static final long ID = 1L;
    CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    @Test
    public void categoryTOCategoryDTO() throws Exception {

        Category category = new Category();
        category.setName(NAME);
        category.setId(ID);

        CategoryDTO categoryDTO = CategoryMapper.INSTANCE.categoryToCategoryDTO(category);

        assertEquals(Long.valueOf(ID), categoryDTO.getId());
        assertEquals(NAME, categoryDTO.getName());
    }
}
