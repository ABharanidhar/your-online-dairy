package com.ab.myonlinedairy.service;

import java.util.List;

import com.ab.myonlinedairy.entity.Dairy;

public interface DairyService {

	public List<Dairy> getDairyEntries(int id);

	public Boolean saveDairyEntry(Dairy dairy);

	public Dairy getDairyEntry(int userId, int dairyId);

	public void softDeleteDairyEntry(int userId, int dairyId);

}
