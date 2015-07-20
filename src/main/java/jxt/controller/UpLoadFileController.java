
package jxt.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author tangshun 
 */
@Controller
public class UpLoadFileController {
	
	@Autowired  
    private HttpServletRequest request;  

	@RequestMapping("toUpload")
	public String toUpload() {
		return "user/upload";
	}

	@RequestMapping("fileUpload")
	public String fileUpload(@RequestParam("file") MultipartFile file) {
		// 判断文件是否为空
		if (!file.isEmpty()) {
			try {
				// 文件保存路径
				String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/" ;
				// 转存文件
				File dir=new File(filePath);
				if(!dir.exists()){
					dir.mkdirs();
				}
				file.transferTo(new File(filePath+ file.getOriginalFilename()));
//				file.getContentType()
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 重定向
		return "redirect:/user/list";
	}

	@RequestMapping("filesUpload")
	public String filesUpload(@RequestParam("files") MultipartFile[] files) {
		// 判断file数组不能为空并且长度大于0
		if (files != null && files.length > 0) {
			// 循环获取file数组中得文件
			for (int i = 0; i < files.length; i++) {
				MultipartFile file = files[i];
				// 保存文件
				fileUpload(file);
			}
		}
		// 重定向
		return "redirect:/user/list";
	}
	
	
	 @RequestMapping("list")  
	    public ModelAndView list() {  
	        String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/";  
	        ModelAndView mav = new ModelAndView("/user/list");  
	        File uploadDest = new File(filePath);  
	        String[] fileNames = uploadDest.list();
	        mav.addObject("files", fileNames);
	        for (int i = 0; i < fileNames.length; i++) {  
	            //打印出文件名  
	            System.out.println(fileNames[i]);  
	        }  
	        return mav;  
	    } 

}
