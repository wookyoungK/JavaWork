package phonebook04.list;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


// CONTROLLER 객체
//   어플리케이션의 동작, 데이터 처리(CRUD), (Business logic 담당)
public class PhonebookManager implements Pb, Closeable {
	
	public static final String FILEPATH = "data/phonebook.dat"; 

	private ArrayList<PhonebookModel> pbList = new ArrayList<PhonebookModel>();
	
	// singleton적용
	private PhonebookManager() {
		
		//TODO
		//파일이 존재하면 파일 읽어 들이기 -->pbList;
		
		
	}
	private static PhonebookManager instance = null; // 클래스 변수
	public static PhonebookManager getInstance() { //클래스 메소드
		if (instance == null) {
			instance = new PhonebookManager();
		}
		return instance;
	} // end getInstance()	
	
	
	
	// 전화번호부 생성 등록
	@Override
	public int insert(String name, String phoneNum, String memo) { // insertPhoneBook
		
		// 매개변수 검증 : 이름 필수
		if(name == null || name.trim().length() == 0) {
			throw new PhonebookException("insert() 이름입력오류: ", Pb.ERR_EMPTY_STRING);
		}
		
		PhonebookModel pm = new PhonebookModel(name, phoneNum, memo);
		pbList.add(pm);
		pm.setUid(getMaxUid() + 1); //uid값을 리턴받음
		
		return 1;
	}

	@Override
	public PhonebookModel[] selectAll() {
		PhonebookModel[] result = new PhonebookModel[pbList.size()]; //리스트를 배열로 바꾸는것이 많이 나온다
		for(int i =0; i<pbList.size(); i++) {
			result[i]=pbList.get(i);
		}
		//or pbList.toArray(new PhoneModel[pblist.size()];
		return result;
	}

	// 특정 uid 의 데이터 검색 리턴
	// 못찾으면 null 리턴
	@Override
	public PhonebookModel selectByUid(int uid) {
		
		for (int index = 0; index < pbList.size(); index++) {
			if (pbList.get(index).getUid() == uid) {
				return pbList.get(index); // uid값 발견하면 리턴
		}		  // 못찾으면 null 리턴
	}// end selectByUid()
		return null;
	}
	@Override
	public int updateByUid(int uid, String name, String phoneNum, String memo) {
		
		// 매개변수 검증
		if(uid < 1)
			throw new PhonebookException("update() uid 오류: " + uid, Pb.ERR_UID);
		
		if(name == null || name.trim().length() == 0) // 이름 필수
			throw new PhonebookException("update() 이름입력 오류: ", Pb.ERR_EMPTY_STRING);
		
		// 특정 uid 값을 가진 데이터의 배열 인덱스 찾기
		int index = findIndexByUid(uid);
		if(index < 0) 
			throw new PhonebookException("update() 없는 uid: " + uid, Pb.ERR_UID);
		
//		pbList.set(index,new PhonebookModel(name,phoneNum,memo)); //모르겠음
//		pbList.get(index).setUid(uid);
		pbList.get(index).setName(name);
		pbList.get(index).setPhoneNum(name);
		pbList.get(index).setMemo(name);
		return 1;
	}

	@Override
	public int deleteByUid(int uid) {
		// 매개변수 검증
		if(uid < 1) 
			throw new PhonebookException("deleteByUid() uid 오류: " + uid, Pb.ERR_UID);
		
		int index = findIndexByUid(uid);
		if(index < 0)
			throw new PhonebookException("deleteByUid() 없는 uid: " + uid, Pb.ERR_UID);

		pbList.remove(index);
		
		return 1;
	}
	
	// 현재 데이터중 가장 큰 uid 값을 찾아서 리턴
	private int getMaxUid() {
		int maxUid = 0;
		
		for (int index = 0; index < pbList.size(); index++) {
			if (maxUid < pbList.get(index).getUid()) {
				maxUid = pbList.get(index).getUid();
			}
		}
		
		return maxUid;
	}
	
	// 특정 uid 값을 가진 데이터의 배열 인덱스 찾기
	// 못찾으면 -1 리턴
	private int findIndexByUid(int uid) {
		
		for(int index=0; index<pbList.size(); index++) {
			if(pbList.get(index).getUid()==uid) {
				return index;
			}
			
		}
		
		return -1;
	}



	@Override
	public void close() throws IOException {
		// TODO :데이터 정장
		//pbList -> 파일 
	}
	

} // end PhonebookManager

// 예의 클래스 정의
// 예외발생하면 '에러코드' + '에러메세지'를 부여하여 관리하는게 좋다.
class PhonebookException extends RuntimeException {
	
	private int errCode = Pb.ERR_GENERIC;
	
	public PhonebookException() {
		super("Phonebook 예외 발생");
	}
	
	public PhonebookException(String msg) {
		super(msg);
	}
	
	public PhonebookException(String msg, int errCode) {
		super(msg);
		this.errCode = errCode;
	}
	
	
	// Throwable 의 getMessage 를 오버라이딩 가능
	@Override
	public String getMessage() {
		String msg = "ERR-" + errCode + "]" + Pb.ERR_STR[errCode] +
					" " + super.getMessage();
		return msg;
	}
	
} // end PhonebookException
















