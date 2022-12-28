package com.sy.spring04.gallery.dao;

import java.util.List;

import com.sy.spring04.gallery.dto.GalleryDto;

public interface GalleryDao {
	public void insert(GalleryDto dto);
	public GalleryDto getData(int num);
	public void delete(int num);
	public List<GalleryDto> getList(GalleryDto dto);
	public int getCount(GalleryDto dto);
}
