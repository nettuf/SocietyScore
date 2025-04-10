package com.societyscore.authservice.Util.Enums;

public enum StatusEnum {

	ACTIVE(1, "Active"), INACTIVE(0, "Inactive"), BLOCKED(2, "Blocked");

	private final int code;
	private final String descricao;

	StatusEnum(int code, String descricao) {
		this.code = code;
		this.descricao = descricao;
	}

	public int getCode() {
		return code;
	}

	public String getDescricao() {
		return descricao;
	}

	public static StatusEnum fromCode(int code) {
		for (StatusEnum status : StatusEnum.values()) {
			if (status.getCode() == code) {
				return status;
			}
		}
		throw new IllegalArgumentException("Código inválido: " + code);
	}
}