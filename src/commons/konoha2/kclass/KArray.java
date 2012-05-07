package commons.konoha2.kclass;

import java.util.*;
import commons.konoha2.*;

public final class KArray<T> extends KObject {
	
	private ArrayList<T> list;
	
	KArray() {
		this.list = new ArrayList<T>();
	}
	
	public final int size() {
		return list.size();
	}
	
	public final boolean add(T data) {
		return list.add(data);
	}
	
	public final void insert(int index, T data) {
		list.add(index, data);
	}
	
	public final void clear() {
		list.clear();
	}
}