package com.emp.org.service;
import java.io.IOException;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.emp.org.model.TravelModel;

public interface TravelService {

	List<TravelModel> getAllTravels();

	List<TravelModel> saveTravels(List<TravelModel> travelModels);

	List<TravelModel> uploadTravel(List<MultipartFile> files, List<TravelModel> fileUploadDataList)
	        throws IOException;
}
