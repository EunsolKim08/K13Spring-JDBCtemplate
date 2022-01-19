package springboard.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import springboard.model.JDBCTemplateDAO;
import springboard.model.SpringBbsDTO;

public class WriteActionCommand implements BbsCommandImpl{
	
	@Override
	public void execute(Model model) {
		//Model에 저장된 값을 Map컬렉션으로 변환한다.
		Map<String, Object> paramMap = model.asMap();
		//첫번째로 request 내장객체를 가져온다.
		HttpServletRequest req =
				(HttpServletRequest)paramMap.get("req");
		//두번째로 작성페이에서 전송한 모든 폼값이 저장된 DTO객체를 가져온다.
		SpringBbsDTO springBbsDTO =
				(SpringBbsDTO)paramMap.get("springBbsDTO");
		//폼값 확인용 로그
		System.out.println("springBbsDTO.title="+springBbsDTO.getTitle());
		
		JDBCTemplateDAO dao = new JDBCTemplateDAO();
		dao.write(springBbsDTO);
	
		//dao.close();
	}

}