package com.emp.org.service;
import java.io.IOException;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.emp.org.model.MobileModel;

public interface MobileService {
	
	List<MobileModel> getAllMobiles();

	List<MobileModel> saveMobiles(List<MobileModel> mobileModels);

	List<MobileModel> uploadMobile(List<MultipartFile> files, List<MobileModel> fileUploadDataList)
	        throws IOException;

}
