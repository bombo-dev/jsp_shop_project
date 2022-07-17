package DAO;

import DTO.CategoryDTO;

import java.util.List;

public interface CategoryDAO {
    List<CategoryDTO> listCategory();
    int insertCategory(CategoryDTO dto);
}
