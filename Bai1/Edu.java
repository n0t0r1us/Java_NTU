package Bai1;

import java.util.ArrayList;
import java.util.List;

public class Edu implements IEdu {
	
	List<IEdu> edus = new ArrayList<IEdu>();
	String eduName;
	
	public Edu(String eduName) {
//		super(idol);
		this.eduName = eduName;
	}

	@Override
	public void add(IEdu e) {
		edus.add(e);
	}

	@Override
	public void remove(IEdu e) {
		edus.remove(e);
	}

	@Override
	public void display(String prefix) {
		System.out.println(prefix + "*" + eduName + ":");
		for (int i = 0; i < edus.size(); i++) {
			String temp = prefix;
			prefix += "    ";
			edus.get(i).display(prefix);
			prefix = temp;
		}
	}
	
}
