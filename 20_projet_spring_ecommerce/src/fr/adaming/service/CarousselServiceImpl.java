package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.ICarousselDao;
import fr.adaming.model.Caroussel;

@Service
public class CarousselServiceImpl implements ICarousselService {

	@Autowired
	private ICarousselDao carousselDao;
	
	public void setCarousselDao(ICarousselDao carousselDao) {
		this.carousselDao = carousselDao;
	}

	
	@Override
	public int addImageService(Caroussel caroussel) {
		
		return carousselDao.addImageDao(caroussel);
	}

	@Override
	public void deleteImageService(int pIdCaroussel) {
		carousselDao.deleteImageDao(pIdCaroussel);
		
	}


	@Override
	public List<Caroussel> getAllCarousselService() {
		return carousselDao.getAllCaroussel();
	}


	@Override
	public Caroussel getCarousselService(int pIdCaroussel) {
		return carousselDao.getCarousselDao(pIdCaroussel);
	}


	@Override
	public void updateImageService(Caroussel caroussel) {
		carousselDao.updateCarousselDao(caroussel);
		
	}

}
