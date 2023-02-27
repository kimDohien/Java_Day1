package kr.kh.spring.utils;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {
	public static String uploadFile(String uploadPath, String originalName, byte[] 	
			fileData)throws Exception{
		//UUID생성(32자 문자 & 4개의 하이픈- 랜덤으로 총 36자 생성)
		UUID uid = UUID.randomUUID();
		//originalName : 원본 파일명 (fi_ori_name)
		//savedName : 서버에 저장할 파일명 (fi_name)
		String savedName = uid.toString() +"_" + originalName;
		//savedPath : 서버에 저장할 경로 ( 년/월/일 ) 
		//uploadPath : 저장할 서버 폴더 위치 
		String savedPath = calcPath(uploadPath);
		//빈 파일 생성 : 서버에 업로드 될 빈파일을 생성
		File target = new File(uploadPath + savedPath, savedName);
		//복사를 해서 서버에 업로드
		FileCopyUtils.copy(fileData, target);
		//서버에 업로드된 파일의 경로와 파일명
		// /2023/02/27/uuid_flower.jpg
		// 역슬래시가 아니라 그냥 슬래시인 이유는 url을 보낼때는 기본슬래시 (os마다 차이있음)
		String uploadFileName = makeIcon(uploadPath, savedPath, savedName);
		return uploadFileName;
	}
	
	//uploadPath안에 업로드한 날짜를 기준으로 폴더가 없으면 생성, 있으면 건너뛰고 
	//최종적으로 경로를 만들어주는 메소드
	private static String calcPath(String uploadPath) {
		//현재 날짜 정보를 가져온다
		Calendar cal = Calendar.getInstance();
		// file.Seperator : 운영체제에 따라서 구분하는 폴더기호 
		// \\2023(문자열을 저장할때는 \\~\\~)
		String yearPath = File.separator+cal.get(Calendar.YEAR);
		//month는 연도에다가 역슬래시 붙여주고 자릿수 맞춰줌(decimalFormat)
		//ex)\\2023\\02
		String monthPath = yearPath + File.separator 
            + new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
		//ex)\\2023\\02\\27
		String datePath = monthPath + File.separator 
            + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		// \\2023, \\2023\\02, \\2023\\02\\27를 이용하여 폴더를 생성
		makeDir(uploadPath, yearPath, monthPath, datePath);
		//최종적으로 datePath만 리턴함(\\2023\\02\\27)
		return datePath;
 
	}
	//가변인자...
	private static void makeDir(String uploadPath, String... paths) {
		//파일하나 생성.DatePath를 기준으로 폴더하나 생성하고 , 폴더가 존재하면 만들필요 업
		if(new File(paths[paths.length-1]).exists())
			return;
		for(String path : paths) {
			File dirPath = new File(uploadPath + path);
			//경로에 폴더가 존재하지않으면 폴더를 생성
			if( !dirPath.exists())
				dirPath.mkdir();
		}
	}
	
	//경로를 역슬래시에서 정방향슬래시로 바꿔주는 역할을함
	private static String makeIcon(String uploadPath, String path, String fileName)
        	throws Exception{
		// \\2023\\02\\27\\uuid_flower.jpg 
		// -> /2023/02/27/uuid_flower.jpg로 바꿔줌(역슬래시를 기본슬래시로)
		String iconName = path + File.separator + fileName;
		return iconName.replace(File.separatorChar, '/');
	}
}
