package br.com.pedro.util;

import java.util.Map;

import br.com.pedro.enums.MapKeys;
import br.com.pedro.enums.PositionEnum;

public class StringUtil {
	
	public static String formatPosition(Map<String, Integer> mapa) {
		PositionEnum positionEnum = PositionEnum.getPositionByValue(mapa.get(MapKeys.ORIENTATION.name()));
				
		String position = "("+ mapa.get(MapKeys.POSITION_X.name()) +",";
		position += mapa.get(MapKeys.POSITION_Y.name()) +",";
		position += positionEnum.name()+")";
		
		return position.toString();
	}

}
