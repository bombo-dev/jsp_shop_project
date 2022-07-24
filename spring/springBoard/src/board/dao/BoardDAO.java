package board.dao;

import java.util.List;

import board.dto.BoardDTO;

public interface BoardDAO {
	public int insertBoard(BoardDTO dto);
	public int deleteBoard(int num, String passwd);
	public int updateBoard(BoardDTO dto);
	public BoardDTO getBoard(int num, String mode);
	public List<BoardDTO> listBoard();
}
