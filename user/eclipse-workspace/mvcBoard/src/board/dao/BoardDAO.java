package board.dao;

import java.util.List;

import board.dto.BoardDTO;

public interface BoardDAO {
	public List<BoardDTO> listBoard();
	public BoardDTO getBoard(int num, String mode);
	public int insertBoard(BoardDTO dto);
	public int updateBoard(BoardDTO dto);
	public int deleteBoard(int num, String passwd);
}
