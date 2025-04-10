package com.societyscore.authservice.Util.Enums;

public enum TypeEnum {

	NORMAL(1, "Normal"), VIP(2, "Vip"), ADMIN(9, "Admin");

	private final int code;
	private final String descricao;

	TypeEnum(int code, String descricao) {
		this.code = code;
		this.descricao = descricao;
	}

	public int getCode() {
		return code;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TypeEnum fromCode(int code) {
		for (TypeEnum status : TypeEnum.values()) {
			if (status.getCode() == code) {
				return status;
			}
		}
		throw new IllegalArgumentException("Código inválido: " + code);
	}
}