package br.com.pedro.enums;

public enum RotationEnum {
	L(-90),
	R(90);
	
    private int value;

    private RotationEnum(Integer value) {
       this.value = value;
    }
    
    public Integer getValue() {
        return value;
    }
    

	public static boolean isRotation(String cordinate){
		if(RotationEnum.L.name().equals(cordinate) || RotationEnum.R.name().equals(cordinate)){
			return true;
		}
		
		return false;
	}
	
}
