package br.com.pedro.util;

import java.util.HashMap;
import java.util.Map;

import br.com.pedro.enums.MapKeys;

public class PositionUtil {
	
	public static Map<String, Integer> createInicialPosition() {
		Map<String, Integer> mapa = new HashMap<String,Integer>();
		mapa.put(MapKeys.POSITION_X.name(), 0);
		mapa.put(MapKeys.POSITION_Y.name(), 0);
		mapa.put(MapKeys.ORIENTATION.name(), 0);
		return mapa;
	}
	
	public static Integer normalize(Integer orientation){
		if(orientation==360){
			return 0;
		}
		
		if(orientation==-90){
			return 270;
		}
			
		return orientation;
	}

}
