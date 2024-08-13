package edu.kh.member.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import edu.kh.member.dto.Member;

public class MemberDaoImpl implements MemberDao{
	
	// 회원 데이터가 저장될 파일 경로를 상수로 지정
		private final String FILE_PATH = "membership_servlet.dat";
		
		// 회원 목록을 저장해둘 List 객체
		private List<Member> memberList = null;
		
		// 스트림 객체 참조 변수
		private ObjectInputStream  ois = null;
		private ObjectOutputStream oos = null;
		
		
		// 기본 생성자
		// - 회원 다수를 관리할 회원 목록(List)이 필요한데
		//   이미 파일로 저장된 회원 목록이 있으면 읽어오고
		//   없으면 새로 만들기
		public MemberDaoImpl() throws FileNotFoundException, IOException, ClassNotFoundException {
			
			// membership.dat 파일이 존재하는지 검사
			File file = new File(FILE_PATH);
			
			if( file.exists() ) { // 존재하는 경우
				try {
					// 스트림 생성
					ois = new ObjectInputStream(new FileInputStream(FILE_PATH));  
					
					// 저장된 객체를 파일에서 읽어와 
					// 다운 캐스팅하여 memberList가 참조하게함
					memberList = (ArrayList<Member>)ois.readObject();
			
				} finally {
					// try에서 발생하는 예외를
					// throws 구문으로 처리하면
					// catch() 구문을 작성하지 않아도 된다!!
					
					if(ois != null) ois.close();
				}
			} 
			
			// 파일이 존재하지 않는 경우
			else {
				// 새로운 ArrayList를 만들어서 참조
				memberList = new ArrayList<Member>();
			}
		}

	@Override
	public List<Member> getMemberList() {
		return memberList;
	}

	@Override
	public boolean addMember(Member member) {
		return false;
	}

}
