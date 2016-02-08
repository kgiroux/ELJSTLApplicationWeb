package beans;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class DataTP7 implements Serializable{
	private List<Map<String,String>> listCouple;

	public DataTP7(List<Map<String, String>> listCouple) {
		super();
		this.listCouple = listCouple;
	}

	public List<Map<String, String>> getListCouple() {
		return listCouple;
	}

	public void setListCouple(List<Map<String, String>> listCouple) {
		this.listCouple = listCouple;
	}
}
