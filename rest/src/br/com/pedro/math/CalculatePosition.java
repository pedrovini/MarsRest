package br.com.pedro.math;

import java.util.Map;

import br.com.pedro.enums.MapKeys;
import br.com.pedro.enums.PositionEnum;
import br.com.pedro.enums.RotationEnum;
import br.com.pedro.util.PositionUtil;
import br.com.pedro.util.StringUtil;

public class CalculatePosition {
	
	private final Integer max = 5;
	private final Integer min = 0;
	private final Character alterPosition ='M';
	
	public String calculatePosition(String coordinateString){
		char[] cordinates = coordinateString.toCharArray();
		Map<String, Integer> mapa = PositionUtil.createInicialPosition();
		
		for (Character cordinate : cordinates) {
			if(RotationEnum.isRotation(cordinate.toString())){
				alterOrientation(mapa, cordinate);			
			}else if(alterPosition.equals(cordinate)){
				alterPosition(mapa);
			}
		}
			
		return StringUtil.formatPosition(mapa); 
	}

	private void alterPosition(Map<String, Integer> mapa) {
		Integer newPosition = 0;
		Integer orientation = mapa.get(MapKeys.ORIENTATION.name());		
		PositionEnum position = PositionEnum.getPositionByValue(orientation);
		
		switch (position) {
		case N:
			newPosition = mapa.get(MapKeys.POSITION_Y.name())+1;
			if(validPosition(newPosition)){				
				mapa.put(MapKeys.POSITION_Y.name(), newPosition);			
			}
			break;
		case S:
			newPosition = mapa.get(MapKeys.POSITION_Y.name())-1;
			if(validPosition(newPosition)){				
				mapa.put(MapKeys.POSITION_Y.name(), newPosition);			
			}
			break;
		case W:
			newPosition = mapa.get(MapKeys.POSITION_X.name())-1;
			if(validPosition(newPosition)){				
				mapa.put(MapKeys.POSITION_X.name(), newPosition);			
			}
			break;
		case E:
			newPosition = mapa.get(MapKeys.POSITION_X.name())+1;
			if(validPosition(newPosition)){				
				mapa.put(MapKeys.POSITION_X.name(), newPosition);			
			};
			break;
			
		default:
			break;
		}
	}

	private void alterOrientation(Map<String, Integer> mapa, Character rotation) {
		Integer newOrientation = mapa.get(MapKeys.ORIENTATION.name());
		
		if(RotationEnum.L.name().equals(rotation.toString())){
			newOrientation += RotationEnum.L.getValue();	
		}else{
			newOrientation += RotationEnum.R.getValue();	
		}
		
		mapa.put(MapKeys.ORIENTATION.name(), PositionUtil.normalize(newOrientation));
	}
	
	private boolean validPosition(Integer position){		
		return position <= max && position >= min;
	}

	

}
