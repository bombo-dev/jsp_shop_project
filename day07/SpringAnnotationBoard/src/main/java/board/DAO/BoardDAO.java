package board.DAO;

import board.DTO.BoardDTO;

import java.util.List;

public interface BoardDAO {
    public List<BoardDTO> listBoard();
    public BoardDTO getBoard(int num, String mode);
    public int insertBoard(BoardDTO dto);
    public int updateBoard(BoardDTO dto);
    public int deleteBoard(int num, String passwd);
}

