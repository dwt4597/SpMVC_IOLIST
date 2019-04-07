package com.biz.iolist.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.biz.iolist.mapper.DeptDao;
import com.biz.iolist.model.DeptVO;

import lombok.extern.slf4j.Slf4j;
/*
 * xml mapper방식
 */
/*
 * spring - appServlet - dept-context.xml에 service (구버전임)
 */

@Slf4j
public class DeptService {

	@Autowired
	SqlSession session;
	
	private DeptDao dDao() {
		return session.getMapper(DeptDao.class);
	}
	
	public List<DeptVO> selectAll(){
		
		log.debug("DeptService Call");
//		DeptDao dDao = session.getMapper(DeptDao.class);
		List<DeptVO> deptVO = dDao().selectAll();
		return deptVO;
	}

	public String getDCode() {
		
		// tbl_dept에서 가장 큰 코드값을 가져오는 부분
		String d_code = dDao().getDCode();
		String new_dcode = "D0001";
		if(d_code != null) { //테이블의 값이 없으면 null값이 된다.
			d_code = d_code.substring(1); // D0099에서 0번째 말고 1번째 문자부터 자른다 ( 0099  추출)
			int temp_code = Integer.valueOf(d_code.trim()) + 1;  //+1 : 99에서 100이 됨 
			//d_code(db로 부터 가져온 값이어서)가 char형 이여서 
			//빈칸이 있을 수 있으니 trim으로 빈칸을 제거
			new_dcode = String.format("D%04d", temp_code);
			// %d : 숫자(정수)를 표현하라
			// %4d : 왼쪽에 빈칸을 두고, 자리수를 4개로 맞추어라
			// %04d : 왼쪽에 빈칸을 0으로 채워서, 자리수를 4개로 맞추어라 : 0100
			// D%04d : 최종 결과는 D0100
			
		}
		
		return new_dcode;
		
	}
	
	public String getDName(String d_code) {
		DeptVO vo = dDao().findByDCode(d_code);
		return vo.getD_name();
	}
	
	
	public int insert(DeptVO deptVO) {
		//TODO Service insert 메소드
		
		//TODO Service insert 테스트 케이스
		// 조건 : session으로부터 DeptDao mapper를 추출
		// 결과 : deptDao mapper의 insert를 수행하여
		//		테이블에 데이터 저장 완료
//		DeptDao dDao = session.getMapper(DeptDao.class);
		int ret = dDao().insert(deptVO);
		return ret;
	}

	public List<DeptVO> findByDName(String d_name) {
		List<DeptVO> dList = dDao().findByDName(d_name);
		return dList;
	}
}
