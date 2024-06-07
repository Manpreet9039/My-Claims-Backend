package com.emp.org.service;
import java.io.IOException;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.emp.org.model.MiscellaneousModel;



public interface MiscellaneousService {
	
	List<MiscellaneousModel> getAllMiscellaneous();

	List<MiscellaneousModel> saveMiscellaneous(List<MiscellaneousModel> miscellaneousModels);

	List<MiscellaneousModel> uploadMiscellaneous(List<MultipartFile> files, List<MiscellaneousModel> fileUploadDataList)
	        throws IOException;

}
