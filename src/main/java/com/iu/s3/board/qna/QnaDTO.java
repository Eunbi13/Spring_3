package com.iu.s3.board.qna;

import com.iu.s3.board.BoardDTO;

public class QnaDTO extends BoardDTO{
	private long rdf;
	private long step;
	private long depth;
	
	
	public long getRdf() {
		return rdf;
	}
	public void setRdf(long rdf) {
		this.rdf = rdf;
	}
	public long getStep() {
		return step;
	}
	public void setStep(long step) {
		this.step = step;
	}
	public long getDepth() {
		return depth;
	}
	public void setDepth(long depth) {
		this.depth = depth;
	}
}
