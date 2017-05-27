package org.del.controller;

import org.del.dao.FasilitasDao;
import org.del.dao.FasilitasDao;
import org.del.models.Fasilitas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FasilitasController {
	
	FasilitasDao fDao;
	
	@Autowired
	public void setFasilitasDao(FasilitasDao fDao){
		this.fDao=fDao;
	}
	
	@RequestMapping("/fasilitas")
	public String Fasilitas(Model model){
		model.addAttribute("fasilitas", fDao.listFasilitas());
		model.addAttribute("newFasilitas", new Fasilitas());
		
		return "fasilitas";
		
	}
	
	@RequestMapping(value ="/tambahf", method = RequestMethod.POST)
	public String tambahkan(Model model, Fasilitas fasilitas){
		model.addAttribute("newFasilitas", fDao.tambah(fasilitas));
		
		return "redirect:/fasilitas";
	}

}
