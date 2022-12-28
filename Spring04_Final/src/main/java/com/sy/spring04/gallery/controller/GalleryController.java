package com.sy.spring04.gallery.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sy.spring04.gallery.dto.GalleryDto;
import com.sy.spring04.gallery.service.GalleryService;

@Controller
public class GalleryController {
	
	@Autowired
	private GalleryService service;
	
	@RequestMapping("/gallery/list")
	public String list(HttpServletRequest request) {
		service.getList(request);
		return "gallery/list";
	}
	
	@RequestMapping("/gallery/uploadform")
	public String insertForm() {
		return "gallery/uploadform";
	}	
	
	@RequestMapping("/gallery/upload")
	public ModelAndView insert(GalleryDto dto, ModelAndView mView, HttpServletRequest request) {
		service.saveFile(dto, mView, request);		
		mView.setViewName("gallery/upload");
		return mView;
	}
	
	@RequestMapping("/gallery/delete")
	public String delete(int num, HttpServletRequest request) {
		service.deleteFile(num, request);
		return "redirect:/gallery/list";		
	}
}
