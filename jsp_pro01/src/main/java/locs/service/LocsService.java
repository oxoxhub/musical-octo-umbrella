package locs.service;

import java.util.List;

import locs.model.LocsDAO;
import locs.model.LocsDTO;

public class LocsService {

	private LocsDAO dao;
	
	public LocsService() {
		dao = new LocsDAO();
	}
	
	public List<LocsDTO> getAll() {
		List<LocsDTO> datas = dao.searchAll();
		return datas;
	}

	public LocsDTO getLocsId(String id) {
		boolean isNumber = id.matches("\\d+");
		if(isNumber) {
			int locsId = Integer.parseInt(id);
			return _getLocsId(locsId);
		}
		return null;
	}
	
	public LocsDTO getLocsId(int id) {
		return _getLocsId(id);
	}
	
	private LocsDTO _getLocsId(int id) {
		LocsDTO data = dao.searchLocsId(id);
		return data;
	}

	public LOCS_SERVICE_STATUS addLocs(LocsDTO data) {
		dao = new LocsDAO();
		LOCS_SERVICE_STATUS status = LOCS_SERVICE_STATUS.SUCCESS;
		
		if(getLocsId(data.getLocId()) != null) {
			status = LOCS_SERVICE_STATUS.LOC_ID_DUPLICATED;
		}
		
		if(!_existCountry(data.getCtyId())) {
			status = LOCS_SERVICE_STATUS.CTY_ID_NOT_EXISTS;
		}
		
		switch (status) {
		case SUCCESS:
			if(dao.insertlocs(data)) {
				dao.commit();
			} else {
				status = LOCS_SERVICE_STATUS.FAILED;
				dao.rollback();
			}
			break;
		default:
			dao.close();
		}
				
		return status;
	}
	
	private boolean _existCountry(String id) {
		boolean result = dao.existCountry(id);
		return result;
	}
}
