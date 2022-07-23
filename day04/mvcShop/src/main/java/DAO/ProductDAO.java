package DAO;

import DTO.ProductDTO;
import com.oreilly.servlet.MultipartRequest;

import java.util.List;

public interface ProductDAO {
    int insertProd(MultipartRequest mr);
    List<ProductDTO> listProd();
    ProductDTO viewProd(int pnum);
    int deleteProd(int pnum);
    int updateProd(MultipartRequest mr);
}
