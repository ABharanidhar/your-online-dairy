package com.ab.myonlinedairy.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ab.myonlinedairy.dao.DairyDAO;
import com.ab.myonlinedairy.entity.Dairy;

@Service
public class DairyServiceImpl implements DairyService {

	@Autowired
	private DairyDAO dairyDAO;

	@Override
	@Transactional
	public List<Dairy> getDairyEntries(int id) {
		return dairyDAO.getDairyEntries(id);
	}

	@Override
	@Transactional
	public Boolean saveDairyEntry(Dairy dairy) {
		if (dairy.getId()==0) {
			dairy.setEntryOn(new Date());
			dairy.setLastUpdatedAt(new Date());
			boolean isDuplicate = dairyDAO.checkDuplicateRecords(dairy.getAddedBy(), dairy.getEntryOn());
			if (isDuplicate) {
				return false;
			}
		}

		dairy.setIsCurrent(true);
		dairy.setLastUpdatedAt(new Date());
		
		dairyDAO.saveDairyEntry(dairy);

		return true;
	}

	@Override
	@Transactional
	public Dairy getDairyEntry(int userId, int dairyId) {
		return dairyDAO.getDairyEntry(userId, dairyId);
	}

	@Override
	@Transactional
	public void softDeleteDairyEntry(int userId, int dairyId) {
		dairyDAO.softDeleteDairyEntry(userId, dairyId);
	}
}
