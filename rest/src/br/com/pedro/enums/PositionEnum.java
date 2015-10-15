package br.com.pedro.enums;

public enum PositionEnum {
    N(0),
    E(90),
    S(180),
    W(270);

    private int value;

    private PositionEnum(Integer value) {
       this.value = value;
    }
    
    public Integer getValue() {
        return value;
    }

    public static PositionEnum getPositionByValue(Integer value) {
   	
        for (PositionEnum position : values()) {
            if (position.getValue().equals(value)) {
                return position;
            }
        }
        
        return null;
    }
    
	public static boolean isPosition(String cordinate){
		if(PositionEnum.N.name().equals(cordinate) || PositionEnum.S.name().equals(cordinate) 
				|| PositionEnum.W.name().equals(cordinate) || PositionEnum.E.name().equals(cordinate)){
			return true;
		}
		
		return false;
	}


}
