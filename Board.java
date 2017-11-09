package spil;

import desktop_resources.GUI;

public class Board {
	public static void init() {
		Field[] fields = Language.getFields();
		
		for(int i=0; i<fields.length; i++) {
			GUI.setSubText(fields[i].getId(), fields[i].getSubtext());
			GUI.setTitleText(fields[i].getId(), fields[i].getTitle());
			GUI.setDescriptionText(fields[i].getId(), Language.fieldInfo(fields[i].getId()));
		}
	}
}
