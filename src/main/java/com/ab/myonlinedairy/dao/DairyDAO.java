package com.ab.myonlinedairy.dao;

import java.util.Date;
import java.util.List;

import com.ab.myonlinedairy.entity.Dairy;

public interface DairyDAO {

	public List<Dairy> getDairyEntries(int id);

	public void saveDairyEntry(Dairy dairyEntry);

	public Dairy getDairyEntry(int userId, int dairyId);

	public void softDeleteDairyEntry(int userId, int dairyId);

	public boolean checkDuplicateRecords(int addedBy, Date entryOn);

}
