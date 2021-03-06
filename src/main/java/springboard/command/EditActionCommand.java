package springboard.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import springboard.model.JDBCTemplateDAO;
import springboard.model.SpringBbsDTO;

public class EditActionCommand implements BbsCommandImpl {
	
	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest req = (HttpServletRequest)map.get("req");
		
		SpringBbsDTO springBbsDTO =
				(SpringBbsDTO)map.get("springBbsDTO");
		
		JDBCTemplateDAO dao = new JDBCTemplateDAO();
		/*
		 폼값을..
		 */
		
		//DTO객체를 DAO로 전달한다.
		dao.edit(springBbsDTO);
	}

}
