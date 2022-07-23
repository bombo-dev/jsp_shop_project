package DAO;

import DTO.CategoryDTO;

import java.util.List;

public interface CategoryDAO {

    int categoryInsert(CategoryDTO dto);
    List<CategoryDTO> categoryList();
    int categoryDelete(int num);

}
