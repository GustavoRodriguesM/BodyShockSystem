package br.com.gr.bodyshock.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Dieta {

	public Dieta(String id) {
		this.id = id;
	}

	public Dieta() {
	} // JPA

	@Id
	private String id;
	@Column(nullable = false)
	private String carbo1;
	@Column(nullable = false)
	private String carbo2;
	@Column(nullable = false)
	private String carbo3;
	@Column(nullable = false)
	private String carbo4;

	@Column(nullable = false)
	private String prot1;
	@Column(nullable = false)
	private String prot2;
	@Column(nullable = false)
	private String prot3;

	@Column(nullable = false)
	private String suplem1;
	@Column(nullable = false)
	private String suplem2;

	@Column(nullable = false)
	private String vit1;
	@Column(nullable = false)
	private String vit2;
	@Column(nullable = false)
	private String vit3;

	@Column(nullable = false)
	private String ref1;
	@Column(nullable = false)
	private String ref2;
	@Column(nullable = false)
	private String ref3;
	@Column(nullable = false)
	private String ref4;
	@Column(nullable = false)
	private String ref5;
	@Column(nullable = false)
	private String ref6;
	@Column(nullable = false)
	private String ref7;

	private boolean padrao;

	public boolean getPadrao() {
		return padrao;
	}

	public void setPadrao(boolean padrao) {
		this.padrao = padrao;
	}

	public String getVit3() {
		return vit3;
	}

	public void setVit3(String vit3) {
		this.vit3 = vit3;
	}

	public String getCarbo1() {
		return carbo1;
	}

	public void setCarbo1(String carbo1) {
		this.carbo1 = carbo1;
	}

	public String getCarbo2() {
		return carbo2;
	}

	public void setCarbo2(String carbo2) {
		this.carbo2 = carbo2;
	}

	public String getCarbo3() {
		return carbo3;
	}

	public void setCarbo3(String carbo3) {
		this.carbo3 = carbo3;
	}

	public String getCarbo4() {
		return carbo4;
	}

	public void setCarbo4(String carbo4) {
		this.carbo4 = carbo4;
	}

	public String getProt1() {
		return prot1;
	}

	public void setProt1(String prot1) {
		this.prot1 = prot1;
	}

	public String getProt2() {
		return prot2;
	}

	public void setProt2(String prot2) {
		this.prot2 = prot2;
	}

	public String getProt3() {
		return prot3;
	}

	public void setProt3(String prot3) {
		this.prot3 = prot3;
	}

	public String getSuplem1() {
		return suplem1;
	}

	public void setSuplem1(String suplem1) {
		this.suplem1 = suplem1;
	}

	public String getSuplem2() {
		return suplem2;
	}

	public void setSuplem2(String suplem2) {
		this.suplem2 = suplem2;
	}

	public String getVit1() {
		return vit1;
	}

	public void setVit1(String vit1) {
		this.vit1 = vit1;
	}

	public String getVit2() {
		return vit2;
	}

	public void setVit2(String vit2) {
		this.vit2 = vit2;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRef1() {
		return ref1;
	}

	public void setRef1(String ref1) {
		this.ref1 = ref1;
	}

	public String getRef2() {
		return ref2;
	}

	public void setRef2(String ref2) {
		this.ref2 = ref2;
	}

	public String getRef3() {
		return ref3;
	}

	public void setRef3(String ref3) {
		this.ref3 = ref3;
	}

	public String getRef4() {
		return ref4;
	}

	public void setRef4(String ref4) {
		this.ref4 = ref4;
	}

	public String getRef5() {
		return ref5;
	}

	public void setRef5(String ref5) {
		this.ref5 = ref5;
	}

	public String getRef6() {
		return ref6;
	}

	public void setRef6(String ref6) {
		this.ref6 = ref6;
	}

	public String getRef7() {
		return ref7;
	}

	public void setRef7(String ref7) {
		this.ref7 = ref7;
	}

}
