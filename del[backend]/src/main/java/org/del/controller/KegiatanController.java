package org.del.controller;

import org.del.dao.KegiatanDao;
import org.del.models.Kegiatan;
import org.del.controller.HomeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class KegiatanController {
	
	private KegiatanDao kDao;
	
	@Autowired
	public void setKegiatanDao(KegiatanDao kDao){
		this.kDao=kDao;
	}
	
	@RequestMapping("/kegiatan")
	public String Kegiatan(Model model){
		model.addAttribute("kegiatan", kDao.listKegiatan());
		model.addAttribute("newKegiatan", new Kegiatan());
		return "kegiatan";
		
	}
	
	@RequestMapping(value ="/tambahK", method = RequestMethod.POST)
	public String tambahkan(Model model, Kegiatan kegiatan){
		model.addAttribute("newKegiatan", kDao.tambah(kegiatan));
		return "redirect:/kegiatan";
	}
	

}
