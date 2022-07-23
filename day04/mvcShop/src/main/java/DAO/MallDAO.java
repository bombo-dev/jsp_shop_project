package DAO;

import DTO.CategoryDTO;
import DTO.ProductDTO;

import java.util.List;

public interface MallDAO {

    List<ProductDTO> hitProductView();
    List<ProductDTO> newProductView();
    List<ProductDTO> bestProductView();
    List<ProductDTO> pspecProductView(String pspec);
    List<ProductDTO> categoryProductView(String category);
}
