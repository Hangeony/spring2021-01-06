package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	
	@Select("SELECT sysdate FROM dual")
	public String getTime();
	
	public String getTime2();

}
/*
기존에 했던 작업
크래스 로딩
커넥션 열고
statment얻고
query 실행
resultSet 처리
커낵션 닫고

처리를 안해도 된다.


@Select("SELECT sysdate FROM dual")
	public String getTime();
이걸쓰면 우리는 query만 신경쓰면 된다.
*/