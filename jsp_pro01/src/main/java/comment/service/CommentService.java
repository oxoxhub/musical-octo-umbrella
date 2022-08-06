package comment.service;

import java.util.List;

import comment.model.CommentDAO;
import comment.model.CommentDTO;

public class CommentService {

	public boolean add(CommentDTO data) {
		CommentDAO dao = new CommentDAO();
		
		boolean result = dao.insertData(data);
		
		if(result) {
			dao.commit();
		} else {
			dao.rollback();
		}
		dao.close();
		
		return result;
	}
	
	public CommentDTO getData(int id) {
		CommentDAO dao = new CommentDAO();
		CommentDTO data = dao.selectData(id);
		dao.close();
		return data;
	}

	public List<CommentDTO> getDatas(int id) {
		CommentDAO dao = new CommentDAO();
		List<CommentDTO> datas = dao.selectDatas(id);
		dao.close();
		return datas;
	}

	public boolean remove(CommentDTO data) {
		CommentDAO dao = new CommentDAO();
		boolean result = dao.deleteData(data);
		
		if(result) {
			dao.commit();
		} else {
			dao.rollback();
		}
		dao.close();
		
		return result;
	}

	public boolean modify(CommentDTO data) {
		CommentDAO dao = new CommentDAO();
		boolean result = dao.updateData(data);
		
		if(result) {
			dao.commit();
		} else {
			dao.rollback();
		}
		dao.close();
		
		return result;
	}

}
