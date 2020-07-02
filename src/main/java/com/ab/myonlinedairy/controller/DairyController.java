package com.ab.myonlinedairy.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ab.myonlinedairy.entity.Dairy;
import com.ab.myonlinedairy.service.DairyService;
import com.ab.myonlinedairy.user.CustomUser;

@Controller
@RequestMapping("/dairy")
public class DairyController {

	@Autowired
	private DairyService dairyService;
	
	private final String REDIRECT_TO_HOME_URL = "redirect:/dairy/home";

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true, 10));
	}

	@GetMapping("/home")
	public String listDairyEntries(Model model, @AuthenticationPrincipal CustomUser user) {
		DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		List<Dairy> entries = dairyService.getDairyEntries(user.getUserID());
		Boolean status;

		if (entries.size() > 0 && sdf.format(LocalDate.now()).equals(entries.get(0).getEntryOn().toString())) {
			status = false;
		} else {
			status = true;
		}

		model.addAttribute("entries", entries);
		model.addAttribute("showAddButton", status);
		return "list-exisiting-entries";
	}

	@GetMapping("/newEntry")
	public String newEntry(Model model, @AuthenticationPrincipal CustomUser user) {
		Dairy entry = new Dairy();
		entry.setAddedBy(user.getUserID());
		model.addAttribute("entry", entry);

		return "add-entry";
	}

	@PostMapping("/saveEntry")
	public String saveDairyEntry(@ModelAttribute("entry") Dairy entry, Model model,
			@AuthenticationPrincipal CustomUser user) {
		Boolean status = dairyService.saveDairyEntry(entry);
		if (status) {
			return REDIRECT_TO_HOME_URL;
		} else {
			model.addAttribute("dairy", entry);
			return "edit-entry";
		}
	}

	@GetMapping("/view")
	public String viewDairyEntry(@RequestParam("dairyId") int id, Model model,
			@AuthenticationPrincipal CustomUser user) {
		Dairy dairy = dairyService.getDairyEntry(user.getUserID(), id);
		if (dairy == null) {
			//No record found" will update later
			return REDIRECT_TO_HOME_URL;
		}
		model.addAttribute("dairy", dairy);
		return "view-entry";
	}

	@GetMapping("/delete")
	public String deleteDairyEntry(@RequestParam("dairyId") int id, Model model,
			@AuthenticationPrincipal CustomUser user) {
		dairyService.softDeleteDairyEntry(user.getUserID(), id);
		return REDIRECT_TO_HOME_URL;
	}

	@GetMapping("/edit")
	public String editDairyEntry(@RequestParam("dairyId") int id, Model model,
			@AuthenticationPrincipal CustomUser user) {
		Dairy dairy = dairyService.getDairyEntry(user.getUserID(), id);
		if (dairy == null) {
			//No record found" will update later
			return REDIRECT_TO_HOME_URL;
		}
		model.addAttribute("dairy", dairy);
		return "edit-entry";
	}

}
