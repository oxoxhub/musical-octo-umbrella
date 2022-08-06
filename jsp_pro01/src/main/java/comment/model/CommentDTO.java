package comment.model;

import java.sql.Date;

public class CommentDTO {
	// 모든 게시물의 댓글을 모아놓은 COMMENTS 테이블
	
	private int id;				//고유번호
	private int bId;			//게시물 번호
	private int empId;			//댓글을 작성한 사용자의 ID
	private String empName;		//댓글 작성자의 이름
	private String content;		//댓글 내용
	private Date createDate;	//댓글 작성일
	private boolean deleted;	//댓글 삭제 여부
	private boolean hidden;		//댓글 비/공개 여부
	private int likeCnt;		//이 댓글의 추천수
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getbId() {
		return bId;
	}
	
	public void setbId(int bId) {
		this.bId = bId;
	}
	
	public int getEmpId() {
		return empId;
	}
	
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	public String getEmpName() {
		return empName;
	}
	
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public boolean isDeleted() {
		return deleted;
	}
	
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	public boolean isHidden() {
		return hidden;
	}
	
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	
	public int getLikeCnt() {
		return likeCnt;
	}
	
	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}
	
	@Override
	public String toString() {
		return "CommentDTO [id=" + id + ", bId=" + bId + ", empId=" + empId + ", empName=" + empName + ", content="
				+ content + ", createDate=" + createDate + ", deleted=" + deleted + ", hidden=" + hidden + ", likeCnt="
				+ likeCnt + "]";
	}
	
	
}
