package guest.domain;

import java.util.List;

public class MessageListView {

	private List<Message> messageList; 	// 게시물 Message 객체 3개
	private int messageTotalCount;		// 전체 게시물의 갯수
	private int currentPageNumber;		// 현재 페이지 번호
	private int pageTotalCount;			// 페이지의 갯수
	private int messageCountPerpage;	// 한 페이지에 출력할 메시지 갯수
	private int firstRow; 				// DB limit index
	private int endRow;					// DB limit count
	
	public MessageListView(List<Message> messageList, int messageTotalCount, int currentPageNumber, int messageCountPerpage, int firstRow, int endRow) {
		this.messageList = messageList;
		this.messageTotalCount = messageTotalCount;
		this.currentPageNumber = currentPageNumber;
		this.messageCountPerpage = messageCountPerpage;
		this.firstRow = firstRow;
		this.endRow = endRow;
		calpageTotalCount();		
	}

	private void calpageTotalCount() {
		
		if(this.messageTotalCount == 0) {
			this.pageTotalCount = 0;
		} else {
			this.pageTotalCount = this.messageTotalCount / this.messageCountPerpage;
			if(this.messageTotalCount / this.messageCountPerpage > 0) {
				this.pageTotalCount++;
			}
		}
	}

	public List<Message> getMessageList() {
		return messageList;
	}

	public int getMessageTotalCount() {
		return messageTotalCount;
	}

	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public int getMessageCountPerpage() {
		return messageCountPerpage;
	}

	public int getFirstRow() {
		return firstRow;
	}

	public int getEndRow() {
		return endRow;
	}

	@Override
	public String toString() {
		return "MessageListView [messageList=" + messageList + ", messageTotalCount=" + messageTotalCount
				+ ", currentPageNumber=" + currentPageNumber + ", pageTotalCount=" + pageTotalCount
				+ ", messageCountPerpage=" + messageCountPerpage + ", firstRow=" + firstRow + ", endRow=" + endRow
				+ "]";
	}
		
}
