
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class test {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		
		list.add("Eeny");
		list.add("meeny");
		list.add("miny");
		list.add("moe");
		

		System.out.println(list.get(list.size()/2));
		/*
		Vector<String> colors= new Vector<>();
		colors.add("Red");
		colors.add("Blue");
		colors.add(1, "Green");
		
		Vector<String> newColors= new Vector<>();
		newColors.add("Orange");
		newColors.add("Yellow");
		newColors.add(0, "White");
		
		newColors.addAll(colors);
		System.out.println(newColors);
		*/
	}

}
	

