package io.boodskap.iot;

public enum DataType {
	
	BOOLEAN,
	BYTE,
	CHAR,
	SHORT,
	INT,
	LONG,
	FLOAT,
	DOUBLE,
	STRING,
	UUID,
	BLOB,
	JSON,
	NESTED,
	OBJECT,
	_boolean,
	_byte,
	_char,
	_short,
	_int,
	_long,
	_float,
	_double,
	_blob,
	;
	
	public final boolean isNumbericField() {
		switch(this){
		case BYTE:
		case DOUBLE:
		case FLOAT:
		case INT:
		case LONG:
		case SHORT:
		case _byte:
		case _double:
		case _float:
		case _int:
		case _long:
		case _short:
			return true;
		default:
			return false;
		}
	}

}
